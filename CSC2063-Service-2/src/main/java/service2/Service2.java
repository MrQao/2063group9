package service2;



import service2.project.ProjectNumber;

public interface Service2 {
	ProjectNumber getNum();
	boolean upgrade(int cent);
	int getpercent();
}
