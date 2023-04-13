package architector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Architector {
	String name;
	Architector(){}
	
	Architector(String name)
	{
		this.name = name;
	}
	public String getName() { return name; }
}
