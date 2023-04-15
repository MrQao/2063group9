package service2.engineer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import service2.Service2;
import service2.project.ProjectNumber;

public class Engineers extends Engineer implements Service2{
	private ArrayList<Engineer> engineerObjects = new ArrayList<Engineer>();
	String workDir = System.getProperty("user.home");
	String pathArc = workDir + "\\Engineers.xml";
		
		public Engineers() {}
		
		public void add(Engineer engineer)
		{
			engineerObjects.add(engineer);
		}
		
		public ArrayList<Engineer> getArchitectorObjects(){ return engineerObjects; }
		
		public int signUp(String name) throws JAXBException, IOException
		{
			Engineers engineers = new Engineers();
				if(new File(pathArc).exists())
					{engineers=readEng();}
				if(engineers.getArchitectorObjects().size() == 4)return -1;
				for(Engineer engineer : engineers.getArchitectorObjects())
				{
					if(engineer.getName()==name) 
					{return -1;}
				}
				engineers.getArchitectorObjects().add(new Engineer(name));
				storeEng(engineers);
			return 1;
		}

		public int assignTask(String userID, ProjectNumber projectNum) throws JAXBException, IOException
		{
			int flag=-1;
			if(new File(pathArc).exists()) {
				Engineers engineers=readEng();
				for(Engineer engineer : engineers.getArchitectorObjects())
				{
					if(engineer.getName()==userID)
					{
						engineer.addProject(projectNum);
						flag=1;
						storeEng(engineers);
					}
				}
			}
			return flag;
		}
		
		public int updateTask(String userID, ProjectNumber projectnumber, int percent) throws JAXBException, IOException
		{
			int flag=-1;
			if(new File(pathArc).exists()) {
				Engineers engineers=readEng();
				for(Engineer engineer : engineers.getArchitectorObjects())
				{
					if(engineer.getName()==userID)
					{
						engineer.upgradePro(projectnumber,percent);
						storeEng(engineers);
						flag=1; 
					}
				}
			}
			return flag;
		}
		
		public String checkTast(String userID) throws JAXBException, IOException
		{
			if(new File(pathArc).exists()) {
				Engineers engineers=readEng();
				for(Engineer engineer : engineers.getArchitectorObjects())
				{
					if(engineer.getName()==userID)
					{
						return String.valueOf(engineer.printPro(userID));
					}
				}
			}
			return "";
		}
		
		public void storeEng(Engineers engineers) throws JAXBException, IOException
		{
			FileOutputStream outputStream = new FileOutputStream(pathArc);
			JAXBContext jAXBContext = JAXBContext.newInstance(Engineers.class);
			Marshaller marshaller = jAXBContext.createMarshaller();
			marshaller.marshal(engineers, outputStream);
			outputStream.close();
		}
		
		public Engineers readEng() throws JAXBException, IOException
		{
			Engineers engineers;
			FileInputStream inputStream = new FileInputStream(pathArc);
			JAXBContext jAXBContext = JAXBContext.newInstance(Engineers.class);
			Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
			engineers = (Engineers)unmarshaller.unmarshal(inputStream);
			inputStream.close();
			return engineers;
		}
}
