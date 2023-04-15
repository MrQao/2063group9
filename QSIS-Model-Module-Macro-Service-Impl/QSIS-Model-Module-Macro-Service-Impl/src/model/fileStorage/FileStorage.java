package model.fileStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Storage;


@WebService(endpointInterface="model.Storage")

public class FileStorage implements Storage{

	private String workDir = System.getProperty("user.home");
	private String path = workDir + "/students.txt";
	private String serialization = workDir + "/UnsuccessfulLogins.xml";


	private TxtParser txtParser = new TxtParser();

	private Tokenizer tokenizer = new Tokenizer();


	private UnsuccessfulLogins logins = new UnsuccessfulLogins();

	public boolean loginCheck( String username, String password ) throws JAXBException, IOException {

		System.out.println("The 'user.home' path is the following: " + path);

		ArrayList<String> lines = txtParser.read( path );

		for( int i = 0; lines != null && i < lines.size(); ++i ) {

			String line = lines.get( i );

			List<String> tokens = tokenizer.tokenize( line, ',' );

			if( tokens.get( 0 ).equals( username ) && tokens.get( 1 ).equals( password ) ) {

				System.out.println("The user (" + username + ", " + password + ") exists.");

				return true;
			}
		}

		if( new File(serialization).exists() ) {

			FileInputStream inputStream = new FileInputStream(serialization);

	        JAXBContext jAXBContext = JAXBContext.newInstance(UnsuccessfulLogins.class);

	        Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();

	        logins = (UnsuccessfulLogins) unmarshaller.unmarshal(inputStream);

	        inputStream.close();
		}

		UnsuccessfulLogin login = new UnsuccessfulLogin(username, password);

		int i = 0;

		for(; i < logins.getUnsuccessfulLogins().length; ++i) if(logins.getUnsuccessfulLogins()[i] == null) break;

		logins.getUnsuccessfulLogins()[i] = login;


		FileOutputStream outputStream = new FileOutputStream(serialization);

	    JAXBContext jAXBContext = JAXBContext.newInstance(UnsuccessfulLogins.class);

	    Marshaller marshaller = jAXBContext.createMarshaller();

	    marshaller.marshal(logins, outputStream);

	    outputStream.close();


		i = 0;

		for(; logins.getUnsuccessfulLogins() != null && i < logins.getUnsuccessfulLogins().length; ++i) if(logins.getUnsuccessfulLogins()[i] != null) System.out.println("Unsuccessful login[" + i +"] = (" + logins.getUnsuccessfulLogins()[i].getUsername() + ", " + logins.getUnsuccessfulLogins()[i].getPassword() + ")");

		return false;
	}

	public ArrayList<String> getPersonalInfo( String username, String password ){

		ArrayList<String> info = new ArrayList<String>();

		ArrayList<String> lines = txtParser.read( path );

		for( int i = 0; lines != null && i < lines.size(); ++i ) {

			String line = lines.get( i );

			List<String> tokens = tokenizer.tokenize( line, ',' );

			if( tokens.get( 0 ).equals( username ) && tokens.get( 1 ).equals( password ) ) {

				info.add( tokens.get( 2 ) );
				info.add( tokens.get( 3 ) );
			}
		}

		return info;
	}

	public ArrayList<String> getGrades( String username, String password ){

		ArrayList<String> grades = new ArrayList<String>();

		ArrayList<String> lines = txtParser.read( path );

		for( int i = 0; lines != null && i < lines.size(); ++i ) {

			String line = lines.get( i );

			List<String> tokens = tokenizer.tokenize( line, ',' );

			if( tokens.get( 0 ).equals( username ) && tokens.get( 1 ).equals( password ) ) {

				for( int j = 4; tokens != null && j < tokens.size(); ++j ) grades.add( tokens.get( j ) );
			}
		}

		return grades;
	}
}