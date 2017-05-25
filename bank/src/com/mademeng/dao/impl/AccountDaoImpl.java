package com.mademeng.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mademeng.DB.DB;
import com.mademeng.bean.Account;
import com.mademeng.bean.User;
import com.mademeng.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

	@Override
	public Account addBankAccount(Account account) {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into account(userid,accountid,money) values(?,?,?)";
		Object[] params = { account.getUserid(), account.getAccountid(), account.getMoney() };
		try {
			Account a = queryRunner.insert(DB.getCon(), sql, new BeanHandler<Account>(Account.class), params);
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean deposit(Account account, int money) {

		QueryRunner queryRunner = new QueryRunner();
		String sql = "update account set money=money+? where accountid=?";
		String[] params=new String []{money+"",account.getAccountid()};
		try {
			int a = queryRunner.update(DB.getCon(), sql, params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Account hasAccount(Account account) {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select * from account where accountid=?";
		try {
			Account a=queryRunner.query(DB.getCon(), sql, new String []{account.getAccountid()}, new BeanHandler<Account>(Account.class));
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean transfer(Account accountOut, int money, Account accountTo) {
		QueryRunner queryRunner = new QueryRunner();
		String sqlOut = "update account set money=money-? where accountid=?";//转出账户
		String sqlTo = "update account set money=money+? where accountid=?";//转入账户
		try {
			//转出账户
			int out = queryRunner.update(DB.getCon(), sqlOut, new Object[]{money,accountOut.getAccountid()});
			//转入账户
			int to=queryRunner.update(DB.getCon(), sqlTo, new Object[]{money,accountTo.getAccountid()});
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
