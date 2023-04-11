package usecase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private static final int MAX_ENGINEERS = 100;
    private static final int MAX_ARCHITECTS = 50;
    private static final String ENGINEERS_FILE = "engineers.xml";
    private static final String ARCHITECTS_FILE = "architects.xml";

    public int batchRegisterEndUsers(ArrayList<EndUser> endUsers) {
        for (EndUser endUser : endUsers) {
            if (endUser.getRole() == EndUserRole.ENGINEER) {
                if (registerEndUser(endUser, MAX_ENGINEERS, ENGINEERS_FILE) == -1) {
                    return -1;
                }
            } else if (endUser.getRole() == EndUserRole.ARCHITECT) {
                if (registerEndUser(endUser, MAX_ARCHITECTS, ARCHITECTS_FILE) == -1) {
                    return -1;
                }
            }
        }
        return 0;
    }

    private int registerEndUser(EndUser endUser, int maxEndUsers, String fileName) {
        try {
            File file = new File(fileName);
            ArrayList<EndUser> endUsers = new ArrayList<EndUser>();
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                fileInputStream.read(data);
                fileInputStream.close();
                String xml = new String(data, "UTF-8");
                endUsers = XMLParser.parse(xml);
            }
            if (endUsers.size() >= maxEndUsers) {
                return -1;
            }
            for (EndUser existingEndUser : endUsers) {
                if (existingEndUser.getId().equals(endUser.getId())) {
                    return -1;
                }
            }
            endUsers.add(endUser);
            String xml = XMLParser.serialize(endUsers);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(xml.getBytes("UTF-8"));
            fileOutputStream.close();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }
}


