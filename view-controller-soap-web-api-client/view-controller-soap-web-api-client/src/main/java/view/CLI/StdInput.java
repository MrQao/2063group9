package view.CLI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class StdInput {

	String read( String label ) {

		System.out.println( "\nProvide " + label + ":" );
		System.out.println( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
		String value = null;

		try { value = input.readLine(); }
		catch( IOException ex ) { ex.printStackTrace(); }


	    return value;
	}
}
