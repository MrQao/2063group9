package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class ProjectNumber {
	String workDir = System.getProperty("user.home");
	String pathPro = workDir + "\\ProjectNumbers.xml";
	ArrayList<Integer> projectNumbers = new ArrayList<>();
	
	boolean add(int number) throws JAXBException, IOException
	{
		
		if(check(number))return false;
		projectNumbers.addAll(readPro().getProjectNumbers());
		projectNumbers.add(number);
		storePro(this);
		return true;
	}
	
	public boolean check(int num) throws JAXBException, IOException
	{
		ProjectNumber projectNumber=readPro();
		for(int i:projectNumber.getProjectNumbers())
		{
			if(i==num)return true;
		}
		return false;
	}
	
	ArrayList<Integer> getProjectNumbers() {
		return projectNumbers;
	}
	
	ProjectNumber readPro() throws JAXBException, IOException
	{
		if(! new File(pathPro).exists())return null;
		ProjectNumber projectNumber;
		FileInputStream inputStream = new FileInputStream(pathPro);
		JAXBContext jAXBContext = JAXBContext.newInstance(ProjectNumber.class);
		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
		projectNumber = (ProjectNumber)unmarshaller.unmarshal(inputStream);
		inputStream.close();
		return projectNumber;
	}
	public void storePro(ProjectNumber projectNumber) throws JAXBException, IOException
	{
		FileOutputStream outputStream = new FileOutputStream(pathPro);
		JAXBContext jAXBContext = JAXBContext.newInstance(ProjectNumber.class);
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal(projectNumber, outputStream);
		outputStream.close();
	}
}
