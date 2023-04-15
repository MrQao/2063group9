package service2.project;

import java.io.IOException;

import javax.xml.bind.JAXBException;


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
		return projectNumber;
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
