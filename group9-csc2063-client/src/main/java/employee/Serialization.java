package employee;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Serialization {
	Engineers engineers;
	String workDir = System.getProperty("user.home");
	String path = workDir + "\\Engineers.xml";
	public Serialization(Engineers engineers)
	{
		this.engineers=engineers;
	}
	
	public void store() throws JAXBException, IOException
	{
		FileOutputStream outputStream = new FileOutputStream(path);
		JAXBContext jAXBContext = JAXBContext.newInstance(Engineers.class);
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal(engineers, outputStream);
		outputStream.close();
	}
	
	public void read()
	{
		
	}
}
