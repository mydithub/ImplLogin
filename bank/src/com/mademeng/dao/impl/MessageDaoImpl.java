package com.mademeng.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mademeng.DB.DB;
import com.mademeng.bean.Message;
import com.mademeng.dao.MessageDao;

public class MessageDaoImpl implements MessageDao {

	@Override
	public boolean addMessage(Message message) {
		boolean flag = false;
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into message(accountid,bz,money,accountidto,transfertime) values(?,?,?,?,?)";
		Object[] params = { message.getAccountid(), message.getBz(), message.getMoney(), message.getAccountidto(),
				message.getTransfertime() };
		try {
			Message m = queryRunner.insert(DB.getCon(), sql, new BeanHandler<Message>(Message.class), params);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

}
