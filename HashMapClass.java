package ordering_system;

import java.util.HashMap;

public class HashMapClass {

    //user database
    public static HashMap<Integer, String[]> hm = new HashMap<Integer, String[]>();
    //product database
    public static HashMap<Integer, String[]> productHm = new HashMap<Integer, String[]>();
    //order database
    public static HashMap<Integer, String[]> orderedHm = new HashMap<Integer, String[]>();
    
    //adding admin 
    public static void AddAdmin() {
        String[] adminInfos = {"", "", "admin", "admin123", "admin"};
        int adminId = 1000;

        hm.put(adminId, adminInfos);
    }
}
