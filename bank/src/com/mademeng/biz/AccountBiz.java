package com.mademeng.biz;

import com.mademeng.bean.Account;
import com.mademeng.bean.User;

/**
 * �����˻���ҵ��
 * @author mademeng
 *
 */
public interface AccountBiz {

	/**
	 * �����˻�ҵ��
	 * @param account
	 * @return
	 */
	Account addBankAccount (Account account,User user);
	/**
	 * ���
	 * @param account
	 * @param money
	 */
	boolean deposit(Account account,int money);
	/**
	 * 
	 * @param accountOut ת���˻�
	 * @param money ת�����
	 * @param accountTo ת���˻�
	 * @return
	 */
	boolean transfer(Account accountOut,int money,Account accountTo);
}
