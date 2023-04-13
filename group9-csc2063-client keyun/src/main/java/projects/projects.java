package projects;

public class projects {
	private String projectname;
	private String projectnumber;
	
	projects(){}
	
	public projects(String projectName,String projectNumber) {
		this.projectname = projectName;
		this.projectnumber = projectNumber;
	}
	
	public String getName() { return projectname; }
	public String getNumber() { return projectnumber; }
	
	public void setName(String projectName) { this.projectname = projectName; }
	public void setNumber(String projectNumber) { this.projectnumber = projectNumber; }
}
