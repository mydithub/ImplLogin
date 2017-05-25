package com.mademeng.dao;

import com.mademeng.bean.Account;

/**
 * �����˻������ݷ��ʲ�
 * 
 * @author mademeng
 *
 */
public interface AccountDao {

	/**
	 * �����˻�
	 * 
	 * @param account
	 * @return Account
	 */
	Account addBankAccount(Account account);

	/**
	 * ���
	 */
	boolean deposit(Account account, int money);

	/**
	 * �Ƿ�����˻�
	 * 
	 * @param account
	 * @return
	 */
	Account hasAccount(Account account);
	
	/**
	 * 
	 * @param accountOut ת���˻�
	 * @param money ת�����
	 * @param accountTo ת���˻�
	 * @return
	 */
	boolean transfer(Account accountOut,int money,Account accountTo);
}
