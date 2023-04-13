package project;

import java.util.ArrayList;

public class ProjectNumber {
	ArrayList<Integer> projectNumbers = new ArrayList<>();
	
	void add(int number)
	{
		projectNumbers.add(number);
	}
	
	ArrayList<Integer> getprojectNumbers()
	{
		return projectNumbers;
	}
}
