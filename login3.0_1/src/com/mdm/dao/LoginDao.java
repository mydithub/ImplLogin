package com.mdm.dao;

import com.mdm.entity.Users;

public interface LoginDao {

	/**
	 * �������ݿ�
	 * @param user
	 * @return
	 */
	public boolean doLogin(Users users);
}
