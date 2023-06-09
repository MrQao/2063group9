
package model.filestorage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import model.ArrayList;
import model.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Storage", targetNamespace = "http://model/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Storage {


    /**
     * 
     * @param loginCheckUsername
     * @param loginCheckPassword
     * @return
     *     returns boolean
     * @throws IOException
     * @throws JAXBException
     */
    @WebMethod
    @WebResult(name = "loginCheckResult", partName = "loginCheckResult")
    @Action(input = "http://model/Storage/loginCheckRequest", output = "http://model/Storage/loginCheckResponse", fault = {
        @FaultAction(className = JAXBException.class, value = "http://model/Storage/loginCheck/Fault/JAXBException"),
        @FaultAction(className = IOException.class, value = "http://model/Storage/loginCheck/Fault/IOException")
    })
    public boolean loginCheck(
        @WebParam(name = "loginCheckUsername", partName = "loginCheckUsername")
        String loginCheckUsername,
        @WebParam(name = "loginCheckPassword", partName = "loginCheckPassword")
        String loginCheckPassword)
        throws IOException, JAXBException
    ;

    /**
     * 
     * @param getGradesPassword
     * @param getGradesUsername
     * @return
     *     returns model.ArrayList
     */
    @WebMethod
    @WebResult(name = "getGradesResult", partName = "getGradesResult")
    @Action(input = "http://model/Storage/getGradesRequest", output = "http://model/Storage/getGradesResponse")
    public ArrayList getGrades(
        @WebParam(name = "getGradesUsername", partName = "getGradesUsername")
        String getGradesUsername,
        @WebParam(name = "getGradesPassword", partName = "getGradesPassword")
        String getGradesPassword);

    /**
     * 
     * @param getPersonalInfoPassword
     * @param getPersonalInfoUsername
     * @return
     *     returns model.ArrayList
     */
    @WebMethod
    @WebResult(name = "getPersonalInfoResult", partName = "getPersonalInfoResult")
    @Action(input = "http://model/Storage/getPersonalInfoRequest", output = "http://model/Storage/getPersonalInfoResponse")
    public ArrayList getPersonalInfo(
        @WebParam(name = "getPersonalInfoUsername", partName = "getPersonalInfoUsername")
        String getPersonalInfoUsername,
        @WebParam(name = "getPersonalInfoPassword", partName = "getPersonalInfoPassword")
        String getPersonalInfoPassword);

}
