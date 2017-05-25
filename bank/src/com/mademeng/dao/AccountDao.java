package com.mademeng.dao;

import com.mademeng.bean.Account;

/**
 * 操作账户的数据访问层
 * 
 * @author mademeng
 *
 */
public interface AccountDao {

	/**
	 * 创建账户
	 * 
	 * @param account
	 * @return Account
	 */
	Account addBankAccount(Account account);

	/**
	 * 存款
	 */
	boolean deposit(Account account, int money);

	/**
	 * 是否存在账户
	 * 
	 * @param account
	 * @return
	 */
	Account hasAccount(Account account);
	
	/**
	 * 
	 * @param accountOut 转出账户
	 * @param money 转出金额
	 * @param accountTo 转入账户
	 * @return
	 */
	boolean transfer(Account accountOut,int money,Account accountTo);
}
