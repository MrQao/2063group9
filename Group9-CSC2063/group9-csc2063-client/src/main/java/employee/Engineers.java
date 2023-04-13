package employee;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Engineers {
	private ArrayList<Engineer> engineersObjects = new ArrayList<Engineer>();
	
	public Engineers() {}
	
	public void add(Engineer employee)
	{
		engineersObjects.add(employee);
	}
	
	ArrayList<Engineer> getEngineersObjects(){ return engineersObjects; }
}
