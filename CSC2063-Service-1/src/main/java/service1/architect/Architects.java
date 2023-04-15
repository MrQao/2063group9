package service1.architect;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Architects {
private ArrayList<Architect> architectorObjects = new ArrayList<Architect>();
	
	public Architects() {}
	
	public void add(Architect architector)
	{
		architectorObjects.add(architector);
	}
	
	public ArrayList<Architect> getArchitectorObjects(){ return architectorObjects; }
}
