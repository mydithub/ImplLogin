package com.mademeng.dao;

import com.mademeng.bean.Message;

public interface MessageDao {

	/**
	 * ������Ϣ
	 * @param message
	 * @return
	 */
	boolean addMessage(Message message);
}
