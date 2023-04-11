package view;

public class CLI {
	public CLI()
	{}

	public static int page(int state) {
		switch (state) {
		case 0:
			pages.login();
			break;
			
		case 1:
			pages.loggedin();
			
		default:
			pages.exit();
			break;
		}
		
		
		return 0;
	}
}
