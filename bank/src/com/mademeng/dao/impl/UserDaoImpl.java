package com.mademeng.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mademeng.DB.DB;
import com.mademeng.bean.Account;
import com.mademeng.bean.User;
import com.mademeng.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public User hasUser(User user) {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select id,name,pwd from user where name=? and pwd =?";
		try {
			User u=queryRunner.query(DB.getCon(), sql, new String[] { user.getName(), user.getPwd() },
					new BeanHandler<User>(User.class));
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public User addUser(User user) {
		QueryRunner queryRunner=new QueryRunner();
		String sql="insert into user(name,pwd) values(?,?)";
		Object [] params={user.getName(),user.getPwd()};
		try {
			User u=queryRunner.insert(DB.getCon(), sql,new BeanHandler<User>(User.class), params);
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int getNewId() {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select max(id) from user";
		try {
			int newId=queryRunner.query(DB.getCon(), sql,
					new ScalarHandler<Integer>(1));
			return newId;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

}
