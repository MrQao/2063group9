package usecase;

import java.util.ArrayList;

public class CLI {
    public static void main(String[] args) {
        ArrayList<EndUser> endUsers = new ArrayList<EndUser>();
        endUsers.add(new EndUser("1", EndUserRole.ENGINEER));
        endUsers.add(new EndUser("2", EndUserRole.ARCHITECT));
        Controller controller = new Controller();
        int result = controller.batchRegisterEndUsers(endUsers);
        if (result == 0) {
            System.out.println("End-users registered successfully.");
        } else if (result == -1) {
            System.out.println("Error: end-users with same IDs already exist.");
        } else {
            System.out.println("Error: failed to register end-users.");
        }
    }
}
