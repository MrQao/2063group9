package view.CLI;

import java.net.MalformedURLException;

import controller.StorageController;
import controller.StorageType;
import model.ArrayList;
import model.filestorage.IOException;
import model.filestorage.JAXBException;


public class StudentCLI {

	public static void main( String[] args ) throws MalformedURLException, IOException, JAXBException {

		StdInput stdInput = new StdInput();

		StorageController storageController = new StorageController();


		String username = null;
		do{ username = stdInput.read( "username" ); }
		while( username != null && username.isEmpty() );

		String password = null;
		do{ password = stdInput.read( "password"); }
		while( password != null && password.isEmpty() );


		boolean result = storageController.loginCheck( username, password, StorageType.FILE );


		while( result == true ){

			System.out.println( "\n1. View Personal Details" );
			System.out.println( "2. View Grades" );
			System.out.println( "3. Exit" );
			String choice = stdInput.read( "choice" );


			if( choice.equals( "1" ) ) {

				ArrayList info = storageController.getPersonalInfo( username, password, StorageType.FILE );

				System.out.println( info );
			}

			else if( choice.equals( "2" ) ) {

				ArrayList info = storageController.getGrades( username, password, StorageType.FILE );

				System.out.println( info );
			}

			else if( choice.equals( "3" ) ) break;
		}
	}
}