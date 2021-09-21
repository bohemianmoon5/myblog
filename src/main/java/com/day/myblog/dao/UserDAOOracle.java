package com.day.myblog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.ModifyException;
import com.day.myblog.exception.RemoveException;
import com.day.myblog.handler.GlobalExceptionHandler;

@Repository("UserDAO")
public class UserDAOOracle implements UserDAO{
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public String insert(User user) throws AddException {
		SqlSession session = null;
		GlobalExceptionHandler exception = new GlobalExceptionHandler();
		try {
			session = sessionFactory.openSession();
			User check = session.selectOne("com.day.myblog.dto.UserMapper.selectByName", user.getUsername());
			if(check == null) {
				session.insert("com.day.myblog.dto.UserMapper.insert", user);
				session.commit();
				return "회원가입 성공!!";
			}else {
				throw new AddException("회원가입 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public User selectById(int id) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			User user = session.selectOne("com.day.myblog.dto.UserMapper.selectById", id);
			if(user == null) {
				throw new FindException("해당 유저는 없습니다. id : " + id);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<User> selectAll() throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			List<User> list = session.selectList("com.day.myblog.dto.UserMapper.selectAll");
			if(list.size() == 0) {
				throw new FindException("해당 정보가 없습니다.");
			}
			return list;
		} catch (Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}		
	}

	@Override
	public List<User> selectAll(int currentPage) throws FindException {
		int cnt_per_page = 2;
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			HashMap<String, Integer>map = new HashMap<>();
			map.put("cnt_per_page", cnt_per_page);
			map.put("currentPage", currentPage);
			List<User> list = session.selectList("com.day.myblog.dto.UserMapper.selectPage", map);
			if(list.size() == 0) {
				throw new FindException("해당 정보가 없습니다.");
			}
			return list;
		} catch (Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}		
	}

	@Override
	public String update(User user) throws ModifyException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.myblog.dto.UserMapper.update", user);
			session.commit();
			return "수정 완료!!";
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModifyException("수정에 실패하였습니다.");
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public String deleteById(int id) throws RemoveException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			User user = session.selectOne("com.day.myblog.dto.UserMapper.selectById", id);
			if(user == null) {
				throw new FindException("해당 유저는 없습니다. id : " + id);
			}else {
				session.delete("com.day.myblog.dto.UserMapper.delete", id);
				session.commit();
				System.out.println("id : " + id + " 삭제가 완료되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoveException("삭제에 실패했습니다.");
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public User selectByUsername(String username) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			User user = session.selectOne("com.day.myblog.dto.UserMapper.selectByName", username);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		} 
	}

}
