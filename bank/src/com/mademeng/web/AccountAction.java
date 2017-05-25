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
	 * 增加账户 显示层调用业务
	 */
	public void addAccount() {
		// 调用添加账户业务
		Account account = new Account();
		System.out.println("用户名：");
		String name = input.next();
		System.out.println("密码：");
		String pwd = input.next();
		User user=new User();
		user.setName(name);
		user.setPwd(pwd);
		accountBiz.addBankAccount(account,user);
	}
	/**
	 * 存钱
	 */
	public boolean deposit(){
		boolean flag=false;
		Account account=new Account();
		System.out.println("存钱的账户：");
		account.setAccountid(input.next());
		System.out.println("金额：");
		int money=input.nextInt();
		flag=accountBiz.deposit(account, money);
		if (flag) {
			System.out.println("账户"+account.getAccountid()+"存款成功。");
		}
		return flag;
		
	}
	/**
	 * 转账
	 */
	public void transfer(){
		Account accountOut=new Account();
		Account accountTo=new Account();
		int money=0;
		System.out.println("转出账户：");
		accountOut.setAccountid(input.next());
		System.out.println("转入到：");
		accountTo.setAccountid(input.next());
		System.out.println("金额：");
		money=input.nextInt();
		accountBiz.transfer(accountOut, money, accountTo);
		
	}
}
