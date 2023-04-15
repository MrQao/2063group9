package service1Interface;

import java.io.IOException;

import javax.xml.bind.JAXBException;


public class IProject implements Project {
	String workDir = System.getProperty("user.home");
	String pathProNum = workDir + "\\ProjectNumbers.xml";
	int projectNumber=-1;
	int percent = 0;
	public IProject(int num) throws JAXBException, IOException{
		new IProjectNumber().add(num);
		projectNumber=num;
	}
	public int getNum()
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
