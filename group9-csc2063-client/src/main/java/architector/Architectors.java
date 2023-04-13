package architector;

import java.util.ArrayList;

import engineer.Engineer;

public class Architectors {
private ArrayList<Architector> architectorObjects = new ArrayList<Architector>();
	
	public Architectors() {}
	
	public void add(Architector architector)
	{
		architectorObjects.add(architector);
	}
	
	public ArrayList<Architector> getEngineersObjects(){ return architectorObjects; }
}
