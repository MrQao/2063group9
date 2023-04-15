package service1Interface;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public class IProjectNumber implements ProjectNumber {
	public IProjectNumber() {}
	boolean add(int number) throws JAXBException, IOException
	{
		if(check(number))return false;
		projectNumbers.addAll(readPro().getProjectNumbers());
		projectNumbers.add(number);
		storePro(this);
		return true;
	}
}
