package architector;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Architectors {
private ArrayList<Architector> architectorObjects = new ArrayList<Architector>();
	
	public Architectors() {}
	
	public void add(Architector architector)
	{
		architectorObjects.add(architector);
	}
	
	public ArrayList<Architector> getEngineersObjects(){ return architectorObjects; }
}
