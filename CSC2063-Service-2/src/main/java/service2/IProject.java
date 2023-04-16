package service2;

import javax.jws.WebService;

import service2.project.ProjectNumber;

@WebService
@SOAPBinding(style=Style.RPC)
public interface IProject {
	ProjectNumber getNum();
	boolean upgrade(int cent);
	int getpercent();
}
