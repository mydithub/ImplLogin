package com.mdm.dao;

import com.mdm.entity.Users;

public interface LoginDao {

	/**
	 * 连接数据库
	 * @param user
	 * @return
	 */
	public boolean doLogin(Users users);
}
