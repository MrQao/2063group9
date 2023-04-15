package controller;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import model.ArrayList;
import model.filestorage.IOException;
import model.filestorage.JAXBException;
import model.filestorage.Storage;


public class StorageController {

	public boolean loginCheck( String username, String password, StorageType storageType ) throws MalformedURLException, IOException, JAXBException  {

		if( storageType == StorageType.FILE ) {

			URL url = new URL( "http://localhost:8080/QSIS-Model-Module-Macro-Service-Impl/?wsdl" );

			QName qname = new QName( "http://fileStorage.model/", "FileStorageService" );

			Service service = Service.create( url, qname );

			Storage obj = service.getPort( Storage.class );

			return obj.loginCheck( username, password );
		}

		return false;
	}

	public ArrayList getPersonalInfo( String username, String password, StorageType storageType ) throws MalformedURLException{

		if( storageType == StorageType.FILE ) {

			URL url = new URL( "http://localhost:8080/QSIS-Model-Module-Macro-Service-Impl/?wsdl" );

			QName qname = new QName( "http://fileStorage.model/", "FileStorageService" );

			Service service = Service.create( url, qname );

			Storage obj = service.getPort( Storage.class );

			return obj.getPersonalInfo( username, password );
		}

		return null;
	}

	public ArrayList getGrades( String username, String password, StorageType storageType ) throws MalformedURLException{

		if( storageType == StorageType.FILE ) {

			URL url = new URL( "http://localhost:8080/QSIS-Model-Module-Macro-Service-Impl/?wsdl" );

			QName qname = new QName( "http://fileStorage.model/", "FileStorageService" );

			Service service = Service.create( url, qname );

			Storage obj = service.getPort( Storage.class );

			return obj.getGrades( username, password );
		}

		return null;
	}
}