package model.fileStorage;

import java.util.ArrayList;


class Tokenizer{

	ArrayList<String> tokenize( String phrase, char separator ){

		ArrayList<String> terms = new ArrayList<String>();


		int pos = -1;

		do{
			//pos = findNextTerm( phrase, separator );

			pos = -1;

			for( int i = 0; phrase != null && i < phrase.length(); ++i ) {

				if( phrase.charAt( i ) == separator ) {

					pos = i;

					break;
				}
			}

			if( pos != -1 ){

				String term = phrase.substring( 0, pos );

				terms.add( term );

				phrase = phrase.substring( pos + 1, phrase.length() );
			}

			else if( ! phrase.equals( "" ) ) terms.add( phrase );

		} while( pos != -1 );


		return terms;
	}


	/*private static int findNextTerm( String phrase, char separator ){

		for( int i = 0; phrase != null && i < phrase.length(); ++i ) if( phrase.charAt( i ) == separator ) return i;

		return -1;
	}*/
}
