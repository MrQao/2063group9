package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

import employee.Engineer;
import employee.Engineers;
import projects.projects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Controller {
	String workDir = System.getProperty("user.home");
	String pathEng = workDir + "\\Engineers.xml";
	String pathArc = workDir + "\\Architects.xml";
	projects nullprojects = new projects("null", "null");
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
	
	public int signIn(String userID, String userRole) throws JAXBException, IOException
	{
		int i=1;
		if(! new File(pathEng).exists()) {
			Engineers engineers = new Engineers();
			engineers.add(new Engineer(userID, nullprojects));
			storeEng(engineers);
		}else {
			Engineers engineers=readEng();
			for(Engineer engineer : engineers.getEngineersObjects())
			{
				if(engineer.getName()==userID) 
					return -1;
				i++;
			}
			if(i == 3) return -1;
			engineers.add(new Engineer(userID, nullprojects));
			storeEng(engineers);
		}
		return 0;
	}
	
	public int assignTask(String userID, String projectname) throws JAXBException, IOException
	{
		int i =1 ; 
		if(new File(pathEng).exists()) {
			Engineers engineers=readEng();
			for(Engineer engineer : engineers.getEngineersObjects())
			{
				if(engineer.getName()==userID) break;
				i++;
				if (i == 4) return -1;
			}
			Engineer engineer = engineers.getEngineer(i);
			if (engineer.getProject().getName() == "null") return -1;
			projects project = new projects(projectname, "0");
			engineer.setProject(project);
			engineers.renewEnigneer(i, engineer);
			storeEng(engineers);
		}
		return 0;
	}
	
	public int updateTask(String userID, String projectnumber) throws JAXBException, IOException
	{
		int i =1 ; 
		if(new File(pathEng).exists()) {
			Engineers engineers=readEng();
			for(Engineer engineer : engineers.getEngineersObjects())
			{
				if(engineer.getName()==userID) break;
				i++;
				if (i == 4) return -1;
			}
			Engineer engineer = engineers.getEngineer(i);
			if (engineer.getProject().getName() == "null") return -1;
			projects project = new projects(engineer.getProject().getName(), projectnumber);
			engineer.setProject(project);
			engineers.renewEnigneer(i, engineer);
			storeEng(engineers);
		}
		return 0;
	}
	
	public String checkTast(String userID) throws JAXBException, IOException
	{
		int i =1 ; 
		if(new File(pathEng).exists()) {
			Engineers engineers=readEng();
			for(Engineer engineer : engineers.getEngineersObjects())
			{
				if(engineer.getName()==userID) break;
				i++;
				if (i == 4) return "";
			}
			Engineer engineer = engineers.getEngineer(i);
			if (engineer.getProject().getName() == "null") return "";
			return engineer.getProject().getNumber();
		}
		return "";
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
