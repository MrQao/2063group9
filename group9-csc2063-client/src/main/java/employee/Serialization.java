package employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Serialization {
	String workDir = System.getProperty("user.home");
	String path = workDir + "\\Engineers.xml";
	public Serialization(){}
	
	public void store(Engineers engineers) throws JAXBException, IOException
	{
		FileOutputStream outputStream = new FileOutputStream(path);
		JAXBContext jAXBContext = JAXBContext.newInstance(Engineers.class);
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal(engineers, outputStream);
		outputStream.close();
	}
	
	public Engineers read() throws JAXBException, IOException
	{
		Engineers engineers;
		FileInputStream inputStream = new FileInputStream(path);
		JAXBContext jAXBContext = JAXBContext.newInstance(Engineers.class);
		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
		engineers = (Engineers)unmarshaller.unmarshal(inputStream);
		inputStream.close();
		return engineers;
	}
}
