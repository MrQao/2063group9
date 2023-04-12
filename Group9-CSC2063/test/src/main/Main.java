package main;

import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		InputStreamReader inputreader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputreader);
		String str = null;
		System.out.println("input value");
		str=br.readLine();
		System.out.println("your value is: "+str);
		System.out.println(new String(new char[50]).replace("\0", "\r\n"));
		System.out.println("input value");
		str=br.readLine();
		System.out.println("your value is: "+str);
	}
}
