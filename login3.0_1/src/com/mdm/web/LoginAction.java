package com.mdm.web;

import com.mdm.biz.LoginBiz;
import com.mdm.biz.impl.LoginBizImpl;
import com.mdm.entity.Student;
import com.mdm.entity.Users;
import com.mdm.utils.Utilss;

/**
 * 接受界面数据
 * @author mademeng
 *
 */
public class LoginAction {

	private LoginBiz biz;
	public LoginAction() {
		biz=new LoginBizImpl();
	}
	public boolean login(String username,String password){
		boolean flag=false;
		 Users users=new Users();
		 users.setUsername(username);
		 users.setPassword(password);
		Student student=biz.myLogin(users);
		if (student!=null) {
			Utilss.print(student.getStuno());
			Utilss.print(student.getScore());
			flag=true;
		}
		return flag;
	}
}
