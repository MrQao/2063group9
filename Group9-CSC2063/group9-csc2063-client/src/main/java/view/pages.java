package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.Controller;

public class pages {

	public static int login() throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader inputreader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputreader);
		String selection = null;
		String userName = null;
		String passwd = null;
		Controller controller = new Controller();
		
		
		System.out.println("Welcome to Architecture System!!!");
		System.out.println("");
		System.out.println("You are not login yet.");
		System.out.println("");
		System.out.println("1.Enter your account and passwd to login");
		System.out.println("2.Sign up a new one");
		System.out.println("");
		System.out.print("Enter a number to keep on: ");
		String str = null;
		str=br.readLine();
		selection=str;
		
		
		switch (selection) {
		case "1":
			System.out.println("");
			System.out.print("Enter your user name: ");
			str=br.readLine();
			userName = str;
			System.out.print("Enter your password: ");
			passwd = str;
			if(controller.signIn())
			{
				System.out.println(new String(new char[10]).replace("\0", "\r\n"));
				System.out.println("Login successed!!!");
				return 1;
			}
			else 
			{
				System.out.println(new String(new char[10]).replace("\0", "\r\n"));
				System.out.println("Login failed, Check if your account and password is correct!");
				return pages.login();
			}
		case "2":
			System.out.println("");
			System.out.println("Now signUp");
			System.out.print("Enter your user name: ");
			str=br.readLine();
			userName = str;
			System.out.print("Enter your password: ");
			passwd = str;
			if(controller.signUp())
			{
				System.out.println(new String(new char[10]).replace("\0", "\r\n"));
				System.out.println("Sign up successed!!!");
				return 0;
			}
			else 
			{
				System.out.println(new String(new char[10]).replace("\0", "\r\n"));
				System.out.println("Sign up failed, your account might be used!");
				return pages.login();
			}
			
		default:
			System.out.println(new String(new char[10]).replace("\0", "\r\n"));
			System.out.print("Unknow selection！Enter it again");
			return pages.login();
		}
	}

	public static void loggedin() {
		// TODO Auto-generated method stub
		
	}

	public static void exit() {
		// TODO Auto-generated method stub
		
	}

}
