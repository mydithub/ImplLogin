package com.mademeng.web;

import java.util.Scanner;

import com.mademeng.bean.Account;
import com.mademeng.bean.User;
import com.mademeng.biz.AccountBiz;
import com.mademeng.biz.impl.AccountBizImpl;

public class AccountAction {

	Scanner input = new Scanner(System.in);
	AccountBiz accountBiz = null;
	public AccountAction() {
		accountBiz=new AccountBizImpl();
	}

	/**
	 * �����˻� ��ʾ�����ҵ��
	 */
	public void addAccount() {
		// ��������˻�ҵ��
		Account account = new Account();
		System.out.println("�û�����");
		String name = input.next();
		System.out.println("���룺");
		String pwd = input.next();
		User user=new User();
		user.setName(name);
		user.setPwd(pwd);
		accountBiz.addBankAccount(account,user);
	}
	/**
	 * ��Ǯ
	 */
	public boolean deposit(){
		boolean flag=false;
		Account account=new Account();
		System.out.println("��Ǯ���˻���");
		account.setAccountid(input.next());
		System.out.println("��");
		int money=input.nextInt();
		flag=accountBiz.deposit(account, money);
		if (flag) {
			System.out.println("�˻�"+account.getAccountid()+"���ɹ���");
		}
		return flag;
		
	}
	/**
	 * ת��
	 */
	public void transfer(){
		Account accountOut=new Account();
		Account accountTo=new Account();
		int money=0;
		System.out.println("ת���˻���");
		accountOut.setAccountid(input.next());
		System.out.println("ת�뵽��");
		accountTo.setAccountid(input.next());
		System.out.println("��");
		money=input.nextInt();
		accountBiz.transfer(accountOut, money, accountTo);
		
	}
}
