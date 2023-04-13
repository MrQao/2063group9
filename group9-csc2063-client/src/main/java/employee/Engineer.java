package employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Engineer {
	private String name;
	
	Engineer(){}
	
	Engineer(String name)
	{
		this.name = name;
	}
	public String getName() { return name; }
}
