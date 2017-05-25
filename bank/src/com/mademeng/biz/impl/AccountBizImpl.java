package com.mademeng.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import com.mademeng.DB.DB;
import com.mademeng.bean.Account;
import com.mademeng.bean.Message;
import com.mademeng.bean.User;
import com.mademeng.biz.AccountBiz;
import com.mademeng.dao.AccountDao;
import com.mademeng.dao.MessageDao;
import com.mademeng.dao.UserDao;
import com.mademeng.dao.impl.AccountDaoImpl;
import com.mademeng.dao.impl.MessageDaoImpl;
import com.mademeng.dao.impl.UserDaoImpl;
import com.mademeng.utils.Utils;

public class AccountBizImpl implements AccountBiz {

	AccountDao accountDao = null;
	MessageDao messageDao = null;

	public AccountBizImpl() {
		accountDao = new AccountDaoImpl();// ����Dao�����
		messageDao = new MessageDaoImpl();
	}

	@Override
	public Account addBankAccount(Account account, User user) {
		UserDao userDao = new UserDaoImpl();
		User u = userDao.hasUser(user);
		Account retAccount = null;
		try {
			// �����ֶ��ύ
			DB.getCon().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// �ж��û��Ƿ����
		if (u != null) {// ���ڣ�ֻ�����˻�����
			account.setUserid(u.getId());
			account.setMoney(0);
			account.setAccountid(UUID.randomUUID().toString());
		} else {
			// �����user����
			User addu = userDao.addUser(user);// ����User����
			account.setUserid(userDao.getNewId());
			account.setMoney(0);
			account.setAccountid(UUID.randomUUID().toString());
		}
		retAccount = accountDao.addBankAccount(account);
		try {
			DB.getCon().commit();// �����ֶ��ύ
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retAccount;
	}

	@Override
	public boolean deposit(Account account, int money) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = DB.getCon();
			// �����ֶ��ύ�޸�
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// �ж��˻��Ƿ����
		if (accountDao.hasAccount(account) != null) {
			flag = accountDao.deposit(account, money);
			/*
			 * return accountDao.deposit(account, money);
			 * ����д�ǲ��Եģ���Ϊ�������ֶ��ύ�����ݿ���޸ģ� ���ֱ��������return�������ݿ�������޷��ύ�ˣ�
			 * Ҳ����ֱ��������return������Ĵ���Ͳ���ִ�У� connection.commit();Ҳ����ִ�ж����ݿ��޸ĵ�
			 * ���������ύ�����������ݵĸı䡣
			 */
		}
		try {
			connection.commit();
			DB.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean transfer(Account accountOut, int money, Account accountTo) {
		boolean flag = false;
		/**
		 * 1.ת���˻��Ƿ���ڣ� 2.ת���˻�����Ƿ���㣻 3.ת���˻��Ƿ���ڡ�
		 */
		if (accountDao.hasAccount(accountOut) != null && accountDao.hasAccount(accountTo) != null
				&& accountDao.hasAccount(accountOut).getMoney() >= money) {
			try {
				DB.getCon().setAutoCommit(false);
				flag = accountDao.transfer(accountOut, money, accountTo);
				// д��ת����Ϣ
				Message message = new Message();
				message.setAccountid(accountOut.getAccountid());
				message.setAccountidto(accountTo.getAccountid());
				message.setBz(2);
				message.setMoney(money);
				message.setTransfertime(Utils.getTime());
				messageDao.addMessage(message);// ������Ϣ
				DB.getCon().commit();// �ύ
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					// ����ʧ�ܻع�����
					DB.getCon().rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			flag = true;
			System.out.println("ת�˳ɹ���");
		} else {
			System.out.println("Error,�˻������ڣ������㡣");
		}
		try {
			DB.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
