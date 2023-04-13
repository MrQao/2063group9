package main;

import view.CLI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int state=0;
		while(true)
		{
			System.out.println();
			state=CLI.page(state);
			if(state==-1)
			{
				break;
			}
		}
	}
}
