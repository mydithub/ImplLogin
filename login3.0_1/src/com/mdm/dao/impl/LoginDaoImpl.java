package com.mdm.dao.impl;

import com.mdm.dao.LoginDao;
import com.mdm.entity.Users;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean doLogin(Users users) {
		boolean flag=false;
		//ģ��ȶ����ݿ���Ϣ
		if ("admin".equals(users.getUsername())&&"admin".equals(users.getPassword())) {
			flag=true;
		}
		return flag;
	}

}
