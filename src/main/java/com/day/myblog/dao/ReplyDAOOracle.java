package com.day.myblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.day.myblog.dto.Reply;
import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.RemoveException;

@Repository("ReplyDAO")
public class ReplyDAOOracle implements ReplyDAO{
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public List<Reply> selectAll(int boardId) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			List<Reply> list = session.selectList("com.day.myblog.dto.ReplyMapper.selectAll", boardId);
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
	public String insert(Reply reply) throws AddException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.myblog.dto.ReplyMapper.insert", reply);
			session.commit();
			return "댓글 등록 성공!!";
		} catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public Reply selectById(int id) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Reply reply = session.selectOne("com.day.myblog.dto.ReplyMapper.selectById", id);
			session.commit();
			return reply;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException("댓글 보기 실패!! 아이디를 찾을 수 없습니다. id : " + id);
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
			session.delete("com.day.myblog.dto.ReplyMapper.delete", id);
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

}
