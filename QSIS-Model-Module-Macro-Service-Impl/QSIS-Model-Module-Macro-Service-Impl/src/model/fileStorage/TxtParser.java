package model.fileStorage;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


class TxtParser {

	ArrayList<String> read( String path ){

		ArrayList<String> values = new ArrayList<String>();

		try{

	       FileInputStream fstream = new FileInputStream( new File( path ) );

	       DataInputStream in = new DataInputStream( fstream );

	       BufferedReader br = new BufferedReader( new InputStreamReader( in ) );

           String strLine = null;

           while( ( strLine = br.readLine() ) != null ) values.add( strLine );

           in.close();
		}

        catch( Exception ex ){ ex.printStackTrace(); }


		return values;
	}
}
