package employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import projects.projects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Engineer {
	private String name;
	projects projects;
	
	Engineer(){}
	
	public Engineer(String name, projects project)
	{
		this.name = name;
		this.projects = project;
	}
	
	public String getName() { return name; }
	
	public void setProject(projects newproject) {this.projects = newproject;}
	public projects getProject() { return this.projects;}
}
