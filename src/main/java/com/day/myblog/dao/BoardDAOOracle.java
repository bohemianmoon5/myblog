package com.day.myblog.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.day.myblog.dto.Board;
import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.ModifyException;
import com.day.myblog.exception.RemoveException;
import com.day.myblog.utils.PagingVO;

@Repository("BoardDAO")
public class BoardDAOOracle implements BoardDAO{
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public String insert(Board board) throws AddException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.myblog.dto.BoardMapper.insert", board);
			session.commit();
			return "글쓰기 성공";
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Board> selectAll(PagingVO vo) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			HashMap<String, Integer>map = new HashMap<>();
			map.put("cnt_per_page", vo.getCntPerPage());
			map.put("currentPage", vo.getNowPage());
			List<Board> list = session.selectList("com.day.myblog.dto.BoardMapper.selectPage", map);
			if(list.size() == 0) {
				//throw new FindException("해당 정보가 없습니다.");
				System.out.println("해당 정보가 없습니다.");
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
	public int CountBoard() {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			int cnt = session.selectOne("com.day.myblog.dto.BoardMapper.countPage");
			session.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getStackTrace());
			return 0;
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public Board selectById(int id) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Board check = session.selectOne("com.day.myblog.dto.BoardMapper.selectById", id);
			session.commit();
			return check;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException("글 상세보기 실패!! : 아이디를 찾을 수 없습니다. : " + id);
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
			session.delete("com.day.myblog.dto.BoardMapper.delete", id);
			session.commit();
			System.out.println("id : " + id + " 삭제가 완료되었습니다.");
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
	public void update(Board board) throws ModifyException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.myblog.dto.BoardMapper.update", board);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModifyException("수정에 실패했습니다.");
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public void updateCnt(int id) throws ModifyException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.myblog.dto.BoardMapper.updateCnt", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModifyException("조회수 수정에 실패했습니다.");
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

}
