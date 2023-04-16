package service2.project;

import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;



public class Project {
	String workDir = System.getProperty("user.home");
	String pathProNum = workDir + "\\ProjectNumbers.xml";
	ProjectNumber projectNumber=null;
	int percent = 0;
	
	public Project(ProjectNumber num) throws JAXBException, IOException{
		projectNumber=num;
	}
	public ProjectNumber getNum()
	{
		URL url = new URL( "http://localhost:8080/CSC2063-Service-2/?wsdl" );

		QName qname = new QName( "http://fileStorage.model/", "FileStorageService" );

		Service service = Service.create( url, qname );

		Storage obj = service.getPort( Storage.class );

		return obj.loginCheck( username, password );
	}
	public boolean upgrade(int cent)
	{
		if(cent<percent||percent==100)return false;
		percent=cent;
		return true;
	}
	public int getpercent()
	{
		return percent;
	}
}
