package view;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import controller.Controller;
import role.Role;

public class CLI {
    public static void main(String[] args) throws JAXBException, IOException {
        Controller controller=new Controller();
        role.Role role=new Role();
        controller.signUp("u1", role.Arc());
        controller.signIn("u1");
        controller.assignTask("u1", 1);
        controller.checkTast();
    }
}
