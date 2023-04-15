package service1;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import service1.project.ProjectNumber;

public interface Service1 {
	public int signUp(String name) throws JAXBException, IOException;
	public int assignTask(String userID, ProjectNumber projectNum) throws JAXBException, IOException;
	public int updateTask(String userID, ProjectNumber projectnumber, int percent) throws JAXBException, IOException;
	public String checkTast(String userID) throws JAXBException, IOException;
}
