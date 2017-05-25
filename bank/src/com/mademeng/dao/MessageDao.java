package com.mademeng.dao;

import com.mademeng.bean.Message;

public interface MessageDao {

	/**
	 * 增加信息
	 * @param message
	 * @return
	 */
	boolean addMessage(Message message);
}
