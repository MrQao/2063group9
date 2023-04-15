package engineer;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import project.Project;
import project.ProjectNumber;

@XmlAccessorType(XmlAccessType.FIELD)
public class Engineer {
	private String name;
	private ArrayList<Project> projects = new ArrayList<>();
	
	Engineer(){}
	
	public Engineer(String name)
	{
		this.name = name;
	}
	public String getName() { return name; }
	public ArrayList<Project> getProjects()
	{
		return projects;
	}
	public void addProject(ProjectNumber num) throws JAXBException, IOException
	{
		projects.add(new Project(num));
	}
	public Project getProject(ProjectNumber projectnumber)
	{
		for(Project project:projects)
		{
			if(project.getNum()==projectnumber)
				return project;
		}
		return null;
	}
	public void upgradePro(ProjectNumber projectnumber, int percent)
	{
		getProject(projectnumber).upgrade(percent);
	}
}
