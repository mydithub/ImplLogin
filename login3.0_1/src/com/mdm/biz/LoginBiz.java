package com.mdm.biz;

import com.mdm.entity.Student;
import com.mdm.entity.Users;

public interface LoginBiz {

	/**
	 * 登录成功返回学生信息
	 * @param users
	 * @return
	 */
	public Student myLogin(Users users);
}
