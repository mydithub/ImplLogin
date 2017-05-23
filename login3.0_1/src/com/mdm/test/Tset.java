package com.mdm.test;

import java.util.Scanner;

import com.mdm.web.LoginAction;

public class Tset {

	public static void main(String[] args) {
		LoginAction action=new LoginAction();
		Scanner input=new Scanner(System.in);
		System.out.println("ÓÃ»§Ãû£º");
		String username=input.next();
		System.out.println("ÃÜ  Âë:");
		String password=input.next();
		boolean flag=action.login(username, password);
		if (flag) {
			System.out.println("Success");
		}else {
			System.out.println("Error");
		}
	}
}
