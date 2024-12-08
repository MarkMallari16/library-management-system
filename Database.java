package bookingsystem;

import java.util.HashMap;

public class Database {

    public static HashMap<Integer, String[]> userDb = new HashMap<Integer, String[]>();
    public static HashMap<Integer, String[]> bookDb = new HashMap<Integer, String[]>();

    public static void addAdmin() {
        String[] adminInfos = {"", "", "admin", "pogiako", "admin"};
        int adminId = 1000;

        userDb.put(adminId, adminInfos);
    }
}
