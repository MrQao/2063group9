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
	
	public ArrayList<Engineer> getEngineersObjects(){ return engineersObjects; }
	//public int getsize(){ return engineersObjects.size();};
	public Engineer getEngineer(int i){ return engineersObjects.get(i); }
	public void renewEnigneer(int i, Engineer engineer) { engineersObjects.set(i, engineer); }
}
