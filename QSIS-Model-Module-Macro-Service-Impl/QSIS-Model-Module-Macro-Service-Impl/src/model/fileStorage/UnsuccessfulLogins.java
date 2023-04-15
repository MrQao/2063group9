package model.fileStorage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
class UnsuccessfulLogins {

	private UnsuccessfulLogin[] logins = new UnsuccessfulLogin[1000];

	UnsuccessfulLogins(){}

	UnsuccessfulLogin[] getUnsuccessfulLogins() { return logins; }
}