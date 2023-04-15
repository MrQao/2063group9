package view;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import controller.Controller;
import role.Role;

public class CLI {
    public static void main(String[] args) throws JAXBException, IOException {
        Controller controller=new Controller();
        controller.signUp("u1", Role.ARCHITECTOR);
        controller.signIn("u1");
        controller.assignTask("u1", ProjectNumber.P_1);
        controller.checkTast();
    }
}
