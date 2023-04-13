package project;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class Project {
	String workDir = System.getProperty("user.home");
	String pathProNum = workDir + "\\ProjectNumbers.xml";
	int projectNumber=-1;
	int percent = 0;
	
	Project(){}
	
	int setproject(int num) throws JAXBException, IOException
	{
		
		for(int i:readProNum().getprojectNumbers())
		{
			if(i==num)
			{
				projectNumber=num;
				return 1;
			}
		}
		return -1;
	}
	public ProjectNumber readProNum() throws JAXBException, IOException
	{
		ProjectNumber projectNumber;
		FileInputStream inputStream = new FileInputStream(pathProNum);
		JAXBContext jAXBContext = JAXBContext.newInstance(ProjectNumber.class);
		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
		projectNumber = (ProjectNumber)unmarshaller.unmarshal(inputStream);
		inputStream.close();
		return projectNumber;
	}
}
