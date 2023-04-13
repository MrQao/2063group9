package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

import employee.Engineer;
import employee.Engineers;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Controller {
	String workDir = System.getProperty("user.home");
	String pathEng = workDir + "\\Engineers.xml";
	String pathArc = workDir + "\\Architects.xml";
	public Controller()
	{}
	
	public boolean signUp() throws JAXBException, IOException
	{
		InputStreamReader inputreader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputreader);
		Engineers engineers=readEng();
		System.out.print("Enter your name: ");
		String name=br.readLine();
		for(Engineer engineer : engineers.getEngineersObjects())
		{
			if(engineer.getName()==name) 
			{br.close();return false;}
		}
		return true;
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
}
