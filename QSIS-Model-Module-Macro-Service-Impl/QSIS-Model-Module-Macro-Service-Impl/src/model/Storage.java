package model;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.JAXBException;


@WebService
@SOAPBinding(style=Style.RPC)
public interface Storage {

	@WebMethod
	public @WebResult(name = "loginCheckResult") boolean loginCheck( @WebParam(name = "loginCheckUsername") String username, @WebParam(name = "loginCheckPassword") String password ) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "getPersonalInfoResult") ArrayList<String> getPersonalInfo( @WebParam(name = "getPersonalInfoUsername") String username, @WebParam(name = "getPersonalInfoPassword") String password );

	@WebMethod
	public @WebResult(name = "getGradesResult") ArrayList<String> getGrades( @WebParam(name = "getGradesUsername") String username, @WebParam(name = "getGradesPassword") String password );
}