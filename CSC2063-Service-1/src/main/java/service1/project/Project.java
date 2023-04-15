package service1.project;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public class Project {
	ProjectNumber projectnumber;
	int percent = 0;
	
	public ProjectNumber getProjectsNumber()
	{
		return this.projectnumber;
	}
	
	public void addProjectNumber(ProjectNumber projectnumber) throws JAXBException, IOException
	{
		this.projectnumber = projectnumber;
	}
	
	public boolean upgrade(int cent)
	{
		if(cent<this.percent||this.percent==100)return false;
		this.percent=cent;
		return true;
	}
	public int getpercent()
	{
		return this.percent;
	}
}
