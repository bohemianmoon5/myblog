package com.day.myblog.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;

@Repository("UserDAO")
public class UserDAOOracle implements UserDAO{
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public void insert(User user) throws AddException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.myblog.dto.UserMapper.insert", user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
	}
	
}
