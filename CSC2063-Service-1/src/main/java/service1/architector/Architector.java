package service1.architector;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import service1.project.Project;
import service1.project.ProjectNumber;

public class Architector extends Project {
	String name;

	Architector(){}
	public Architector(String name)
	{
		this.name = name;
	}
	public String getName() { return name; }
	public ProjectNumber getProjects()
	{
		return getProjectsNumber();
	}
	public void addProject(ProjectNumber projectnumber) throws JAXBException, IOException
	{
		addProjectNumber(projectnumber);
	}

	public void upgradePro(ProjectNumber projectnumber, int percent)
	{
		ProjectNumber[] arr = ProjectNumber.values();
		for(ProjectNumber pro : arr)
			if(pro == projectnumber)
				upgrade(percent);
	}
	
	public int printPro(String name)
	{
		return this.getpercent();
	}
}
