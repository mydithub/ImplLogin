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
		accountDao = new AccountDaoImpl();// 创建Dao层对象
		messageDao = new MessageDaoImpl();
	}

	@Override
	public Account addBankAccount(Account account, User user) {
		UserDao userDao = new UserDaoImpl();
		User u = userDao.hasUser(user);
		Account retAccount = null;
		try {
			// 设置手动提交
			DB.getCon().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 判断用户是否存在
		if (u != null) {// 存在，只增加账户对象
			account.setUserid(u.getId());
			account.setMoney(0);
			account.setAccountid(UUID.randomUUID().toString());
		} else {
			// 先添加user对象，
			User addu = userDao.addUser(user);// 增加User对象
			account.setUserid(userDao.getNewId());
			account.setMoney(0);
			account.setAccountid(UUID.randomUUID().toString());
		}
		retAccount = accountDao.addBankAccount(account);
		try {
			DB.getCon().commit();// 设置手动提交
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
			// 设置手动提交修改
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 判断账户是否存在
		if (accountDao.hasAccount(account) != null) {
			flag = accountDao.deposit(account, money);
			/*
			 * return accountDao.deposit(account, money);
			 * 这样写是不对的，因为设置了手动提交对数据库的修改， 如果直接在这里return，对数据库操作就无法提交了，
			 * 也就是直接在这里return后，下面的代码就不会执行， connection.commit();也不会执行对数据库修改的
			 * 操作不会提交。不会有数据的改变。
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
		 * 1.转出账户是否存在； 2.转出账户余额是否充足； 3.转入账户是否存在。
		 */
		if (accountDao.hasAccount(accountOut) != null && accountDao.hasAccount(accountTo) != null
				&& accountDao.hasAccount(accountOut).getMoney() >= money) {
			try {
				DB.getCon().setAutoCommit(false);
				flag = accountDao.transfer(accountOut, money, accountTo);
				// 写入转账信息
				Message message = new Message();
				message.setAccountid(accountOut.getAccountid());
				message.setAccountidto(accountTo.getAccountid());
				message.setBz(2);
				message.setMoney(money);
				message.setTransfertime(Utils.getTime());
				messageDao.addMessage(message);// 增加信息
				DB.getCon().commit();// 提交
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					// 操作失败回滚数据
					DB.getCon().rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			flag = true;
			System.out.println("转账成功。");
		} else {
			System.out.println("Error,账户不存在，或余额不足。");
		}
		try {
			DB.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
