package com.mademeng.dao;

import com.mademeng.bean.User;

/**
 * User对象相关操作
 * @author mademeng
 *
 */
public interface UserDao {

	/**
	 * 是否有此user对象,如果有返回对象，没有返回null
	 * @return
	 */
	User hasUser(User user);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	User addUser(User user);
	/**
	 * 获取新增加的User的ID
	 * @return
	 */
	int getNewId();
}
