package engineer;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import project.Project;

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
	public void addProject(int num) throws JAXBException, IOException
	{
		projects.add(new Project(num));
	}
	public Project getProject(int num)
	{
		for(Project project:projects)
		{
			if(project.getNum()==num)
				return project;
		}
		return null;
	}
	public void upgradePro(int num, int percent)
	{
		getProject(num).upgrade(percent);
	}
}
