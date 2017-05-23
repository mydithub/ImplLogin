package com.mdm.biz.impl;

import com.mdm.biz.LoginBiz;
import com.mdm.dao.LoginDao;
import com.mdm.dao.StudentDao;
import com.mdm.dao.impl.LoginDaoImpl;
import com.mdm.dao.impl.StudentDaoImpl;
import com.mdm.entity.Student;
import com.mdm.entity.Users;

public class LoginBizImpl implements LoginBiz {

	private LoginDao lDao;
	private StudentDao sDao;

	public LoginBizImpl() {
		lDao=new LoginDaoImpl();
		sDao=new StudentDaoImpl();
	}
	@Override
	public Student myLogin(Users users) {
		Student student=new Student();
		boolean flag=lDao.doLogin(users);
		if (flag) {
			student=sDao.initStudentInfo();
		}else {
			student=null;
		}
		return student;
	}

}
