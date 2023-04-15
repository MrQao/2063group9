package service1.architector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import service1.Service1;
import service1.project.ProjectNumber;

public class Architectors extends Architector implements Service1{
private ArrayList<Architector> architectorObjects = new ArrayList<Architector>();
String workDir = System.getProperty("user.home");
String pathArc = workDir + "\\Architects.xml";
	
	public Architectors() {}
	
	public void add(Architector architector)
	{
		architectorObjects.add(architector);
	}
	
	public ArrayList<Architector> getArchitectorObjects(){ return architectorObjects; }
	
	public int signUp(String name) throws JAXBException, IOException
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

	public int assignTask(String userID, ProjectNumber projectNum) throws JAXBException, IOException
	{
		int flag=-1;
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
	
	public int updateTask(String userID, ProjectNumber projectnumber, int percent) throws JAXBException, IOException
	{
		int flag=-1;
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
	
	public String checkTast(String userID) throws JAXBException, IOException
	{
		if(new File(pathArc).exists()) {
			Architectors architectors=readArc();
			for(Architector architector : architectors.getArchitectorObjects())
			{
				if(architector.getName()==userID)
				{
					return String.valueOf(architector.printPro(userID));
				}
			}
		}
		return "";
	}
	
	public void storeArc(Architectors architectors) throws JAXBException, IOException
	{
		FileOutputStream outputStream = new FileOutputStream(pathArc);
		JAXBContext jAXBContext = JAXBContext.newInstance(Architectors.class);
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal(architectors, outputStream);
		outputStream.close();
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
