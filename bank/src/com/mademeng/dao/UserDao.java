package com.mademeng.dao;

import com.mademeng.bean.User;

/**
 * User������ز���
 * @author mademeng
 *
 */
public interface UserDao {

	/**
	 * �Ƿ��д�user����,����з��ض���û�з���null
	 * @return
	 */
	User hasUser(User user);
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	User addUser(User user);
	/**
	 * ��ȡ�����ӵ�User��ID
	 * @return
	 */
	int getNewId();
}
