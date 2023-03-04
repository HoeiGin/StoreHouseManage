package org.StoreManage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Login {
    private static admin once = null;

    public static admin getOnce() {
        if (once == null) {
            once = new admin();
        }
        return once;
    }

    private static List<admin> getAdmin() {
        List<admin> adminList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM billbook.users");
            while (rs.next()) {
                admin person = new admin();
                person.setId(rs.getInt("id"));
                person.setFindId(rs.getString("findid"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setTelephone(rs.getString("telephone"));
                adminList.add(person);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adminList;
    }

    public static boolean toLogin(String UsN, String PsW) {
        List<admin> userList = getAdmin();
        for (admin factor: userList) {
            // factor.print();
            if (factor.returnUsername().equals(UsN)) {
                if (factor.returnPassword().equals(PsW)) {
                    return true;
                }
            }
        }
        return false;
    }
}
