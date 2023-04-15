package model.fileStorage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
class UnsuccessfulLogin {

	private String username, password;

	UnsuccessfulLogin(){}

	UnsuccessfulLogin(String username, String password){

		this.username = username;
		this.password = password;
	}

	String getUsername(){ return username; } 
	String getPassword(){ return password; }
}