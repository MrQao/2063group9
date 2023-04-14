package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.lang.model.element.NestingKind;
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
import project.ProjectNumber;
import role.Role;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Controller {
	String workDir = System.getProperty("user.home");
	String pathEng = workDir + "\\Engineers.xml";
	String pathArc = workDir + "\\Architects.xml";
	
	boolean eng=false;
	boolean arc=false;
	String userlogd=null;
	
	
	public Controller()
	{}
	
	public int signUp(String name,String role) throws JAXBException, IOException
	{
		if(role.equals(new Role().Eng()))
		{
			Engineers engineers = new Engineers();
			if(new File(pathEng).exists())
				{engineers=readEng();}
			if(engineers.getEngineersObjects().size() == 4) return -1;
			for(Engineer engineer : engineers.getEngineersObjects())
			{
				if(engineer.getName()==name) 
				{return -1;}
			}
			engineers.getEngineersObjects().add(new Engineer(name));
			storeEng(engineers);
			return 1;
		}
		else if(role.equals(new Role().Arc()))
		{
			Architectors architectors = new Architectors();
			if(new File(pathArc).exists())
				{architectors=readArc();}
			if(architectors.getArchitectorObjects().size() == 4)return -1;
			for(Architector architector : architectors.getArchitectorObjects())
			{
				if(architector.getName()==name) 
				{return -1;}
			}
			architectors.getArchitectorObjects().add(new Architector(name));
			storeArc(architectors);
			return 1;
		}
		return -1;
	}
	
	public int signIn(String userID) throws JAXBException, IOException
	{
		userlogd=null;
		Engineers engineers = new Engineers();
		if(new File(pathEng).exists())
			{engineers=readEng();}
		eng=false;
		arc=false;
		for(Engineer engineer : engineers.getEngineersObjects())
		{
			if(engineer.getName()==userID) 
			{
				eng=true;
				userlogd=userID;
				break;
			}
		}
		Architectors architectors=readArc();
		for(Architector architector : architectors.getArchitectorObjects())
		{
			if(architector.getName()==userID)
			{
				arc=true;
				userlogd=userID;
				break;
			}
		}
		if(arc||eng)return 1;
		return -1;
	}
	
	public int assignTask(String userID, int projectNum) throws JAXBException, IOException
	{
		int flag=-1;
		if(!arc)return -1;
		if(new File(pathEng).exists()) {
			Engineers engineers=readEng();
			for(Engineer engineer : engineers.getEngineersObjects())
			{
				if(engineer.getName()==userID)
				{
					engineer.addProject(projectNum);
					flag=1;
					storeEng(engineers);
				}
			}
		}
		if(new File(pathArc).exists()) {
			Architectors architectors=readArc();
			for(Architector architector : architectors.getArchitectorObjects())
			{
				if(architector.getName()==userID)
				{
					architector.addProject(projectNum);
					flag=1;
					storeArc(architectors);
				}
			}
		}
		return flag;
	}
	
	public int updateTask(String userID, int projectnumber, int percent) throws JAXBException, IOException
	{
		int flag=-1;
		if(!arc)return -1;
		if(!new ProjectNumber().check(projectnumber))return -1;
		if(new File(pathEng).exists()) {
			Engineers engineers=readEng();
			for(Engineer engineer : engineers.getEngineersObjects())
			{
				if(engineer.getName()==userID)
				{
					engineer.upgradePro(projectnumber, percent);
					storeEng(engineers);
					flag=1;
				}
			}
		}
		if(new File(pathArc).exists()) {
			Architectors architectors=readArc();
			for(Architector architector : architectors.getArchitectorObjects())
			{
				if(architector.getName()==userID)
				{
					architector.upgradePro(projectnumber,percent);
					storeArc(architectors);
					flag=1; 
				}
			}
		}
		return flag;
	}
	
	public int checkTast() throws JAXBException, IOException
	{
		if(!arc)return -1;
		if(new File(pathArc).exists()) {
			Architectors architectors=readArc();
			for(Architector architector : architectors.getArchitectorObjects())
			{
				if(architector.getName()==userlogd)
				{
					if(architector.printPro())return 1;
				}
			}
		}
		return -1;
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
		FileOutputStream outputStream = new FileOutputStream(pathArc);
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
		FileInputStream inputStream = new FileInputStream(pathArc);
		JAXBContext jAXBContext = JAXBContext.newInstance(Architectors.class);
		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
		architectors = (Architectors)unmarshaller.unmarshal(inputStream);
		inputStream.close();
		return architectors;
	}
}
