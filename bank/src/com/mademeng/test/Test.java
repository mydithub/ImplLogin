package com.mademeng.test;

import java.util.Scanner;

import com.mademeng.web.AccountAction;

public class Test {

	public static void main(String[] args) {
		AccountAction accountAction=new AccountAction();
		Scanner input=new Scanner(System.in);
		System.out.println("选择操作：1.开户；2.存款；3.转账");
		int cho=input.nextInt();
		switch (cho) {
		case 1:
			accountAction.addAccount();
			System.out.println("SUCCESS.");
			break;
		case 2:
			accountAction.deposit();
			System.out.println("SUCCESS.");
			break;
		case 3:
			accountAction.transfer();
			System.out.println("SUCCESS.");
			break;
		default:
			System.out.println("Error.");
			break;
		}
	}
}
