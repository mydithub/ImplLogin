package com.mdm.biz;

import com.mdm.entity.Student;
import com.mdm.entity.Users;

public interface LoginBiz {

	/**
	 * ��¼�ɹ�����ѧ����Ϣ
	 * @param users
	 * @return
	 */
	public Student myLogin(Users users);
}
