package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

import architector.Architector;
import architector.Architectors;
import engineer.Engineer;
import engineer.Engineers;
import role.Role;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Controller {
	String workDir = System.getProperty("user.home");
	String pathEng = workDir + "\\Engineers.xml";
	String pathArc = workDir + "\\Architects.xml";
	
	
	
	public Controller()
	{}
	
	public int signUp(String name,String role) throws JAXBException, IOException
	{
		if(role.equals(new Role().Eng()))
		{
			Engineers engineers=readEng();
			for(Engineer engineer : engineers.getEngineersObjects())
			{
				if(engineer.getName()==name) 
				{return -1;}
			}
			return 1;
		}
		else if(role.equals(new Role().Arc()))
		{
			Architectors architectors=readArc();
			for(Architector architector : architectors.getEngineersObjects())
			{
				if(architector.getName()==name) 
				{return -1;}
			}
			return 1;
		}
		return -1;
	}
	
	public boolean signIn()
	{
		return true;
	}
	
	public void assignTask()
	{
		
	}
	
	public void updateTask()
	{
		
	}
	
	public void checkTast()
	{
		
	}
	public void storeEng(Engineers engineers) throws JAXBException, IOException
	{
		FileOutputStream outputStream = new FileOutputStream(pathEng);
		JAXBContext jAXBContext = JAXBContext.newInstance(Engineers.class);
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal(engineers, outputStream);
		outputStream.close();
	}
	public void storeArc(Architectors architectors) throws JAXBException, IOException
	{
		FileOutputStream outputStream = new FileOutputStream(pathEng);
		JAXBContext jAXBContext = JAXBContext.newInstance(Architectors.class);
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal(architectors, outputStream);
		outputStream.close();
	}
	public Engineers readEng() throws JAXBException, IOException
	{
		Engineers engineers;
		FileInputStream inputStream = new FileInputStream(pathEng);
		JAXBContext jAXBContext = JAXBContext.newInstance(Engineers.class);
		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
		engineers = (Engineers)unmarshaller.unmarshal(inputStream);
		inputStream.close();
		return engineers;
	}
	public Architectors readArc() throws JAXBException, IOException
	{
		Architectors architectors;
		FileInputStream inputStream = new FileInputStream(pathEng);
		JAXBContext jAXBContext = JAXBContext.newInstance(Architectors.class);
		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
		architectors = (Architectors)unmarshaller.unmarshal(inputStream);
		inputStream.close();
		return architectors;
	}
}
