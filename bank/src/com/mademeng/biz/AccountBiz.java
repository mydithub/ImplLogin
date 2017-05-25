package com.mademeng.biz;

import com.mademeng.bean.Account;
import com.mademeng.bean.User;

/**
 * 操作账户的业务
 * @author mademeng
 *
 */
public interface AccountBiz {

	/**
	 * 增加账户业务
	 * @param account
	 * @return
	 */
	Account addBankAccount (Account account,User user);
	/**
	 * 存款
	 * @param account
	 * @param money
	 */
	boolean deposit(Account account,int money);
	/**
	 * 
	 * @param accountOut 转出账户
	 * @param money 转出金额
	 * @param accountTo 转入账户
	 * @return
	 */
	boolean transfer(Account accountOut,int money,Account accountTo);
}
