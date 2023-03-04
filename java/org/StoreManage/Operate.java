package org.StoreManage;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Operate {
    private static Operate instance = null;

    public static Operate getInstance() {
        if (instance == null) {
            instance = new Operate();
        }
        return instance;
    }

    public static boolean AddData(unit factor) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sqllnset = "INSERT INTO billbook.unit(id, name, date, quan, note) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqllnset);
            stmt.setInt(1, factor.getID());
            stmt.setString(2, factor.getName());
            stmt.setString(3, factor.getDate());
            stmt.setInt(4, factor.getQuan());
            stmt.setString(5, factor.getNote());

            int i = stmt.executeUpdate();
            if (i == 1) {
                result = true;
            }
        }
        catch (SQLException e) {
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
        return result;
    }

    public static boolean WriteDetail(detail factor) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "INSERT INTO billbook.detail(id, name, date, type, quan, note) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, factor.getID());
            stmt.setString(2, factor.getName());
            stmt.setString(3, factor.getDate());
            stmt.setString(4, factor.getType());
            stmt.setInt(5, factor.getQuan());
            stmt.setString(6, factor.getNote());
            int i = stmt.executeUpdate();
            if (i == 1) {
                result = true;
            }
        }
        catch (SQLException e) {
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
        System.out.println("write in");
        return result;
    }



    public static List<unit> selectInfo() {
        List<unit> InfoList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM billbook.unit");
            while (rs.next()) {
                unit toPrint = new unit();
                toPrint.setID(rs.getInt("id"));
                toPrint.setName(rs.getString("name"));
                toPrint.setDate(rs.getString("date"));
                toPrint.setQuan(rs.getInt("quan"));
                toPrint.setNote(rs.getString("note"));
                InfoList.add(toPrint);
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
        return InfoList;
    }

    public static List<detail> moreInfo() {
        List<detail> InfoList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM billbook.detail");
            while (rs.next()) {
                detail toPrint = new detail();
                toPrint.setID(rs.getInt("id"));
                toPrint.setName(rs.getString("name"));
                toPrint.setDate(rs.getString("date"));
                toPrint.setType(rs.getString("type"));
                toPrint.setQuan(rs.getInt("quan"));
                toPrint.setNote(rs.getString("note"));
                InfoList.add(toPrint);
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
        return InfoList;
    }

    public static boolean updateDate(String name, String date) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "UPDATE billbook.unit SET date = ? WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, date);
            stmt.setString(2, name);
            int flag = stmt.executeUpdate();
            if (flag == 1) {
                result = true;
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
        return result;
    }

    public static boolean updateQuan(String name, int quan) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "UPDATE billbook.unit SET quan = ? WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quan);
            stmt.setString(2, name);
            int flag = stmt.executeUpdate();
            if (flag == 1) {
                result = true;
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
        return result;
    }

    public static boolean updateNote(String name, String note) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "UPDATE billbook.unit SET note = ? WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, note);
            stmt.setString(2, name);
            int flag = stmt.executeUpdate();
            if (flag == 1) {
                result = true;
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
        return result;
    }

    public static unit maxID() {
        unit max = new unit();
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "SELECT * FROM billbook.unit WHERE id = (SELECT MAX(id) FROM billbook.unit) LIMIT 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                max.setID(rs.getInt("id"));
                max.setName(rs.getString("name"));
                max.setDate(rs.getString("date"));
                max.setQuan(rs.getInt("quan"));
                max.setNote(rs.getString("note"));
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
        return max;
    }

    public static detail detId() {
        detail max = new detail();
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "SELECT * FROM billbook.detail WHERE id = (SELECT MAX(id) FROM billbook.detail) LIMIT 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                max.setID(rs.getInt("id"));
                max.setName(rs.getString("name"));
                max.setDate(rs.getString("date"));
                max.setType(rs.getString("type"));
                max.setQuan(rs.getInt("quan"));
                max.setNote(rs.getString("note"));
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
        return max;
    }

    public static boolean deleteInfo(String name) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "DELETE FROM billbook.unit WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            int i = stmt.executeUpdate();
            if (i == 1) {
                result = true;
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
        return result;
    }

    public static void Table() {
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "SELECT id, name, date, quan, note FROM billbook.unit";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("编码 \t 商品名称 \t 操作日期 \t 数量 \t 注释");
            unit rec = new unit();
            while (rs.next()) {
                rec.setID(rs.getInt("id"));
                rec.setName(rs.getString("name"));
                rec.setDate(rs.getString("date"));
                rec.setQuan(rs.getInt("quan"));
                rec.setNote(rs.getString("note"));
                rec.Output();
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
    }


    public static boolean ExStorage(String path) {
        List<unit> dt = Operate.selectInfo();
        String fPath = path + "\\";
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String saveTime = formatter.format(time);
        String file = "导出的 仓储数据 文件.csv";

        CSVPrinter printer = null;
        String toPath = fPath + saveTime + " " + file;

        try {

            BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (toPath,false),"GBK"));
            // FileWriter wri = new FileWriter(toPath);
            printer = CSVFormat.EXCEL.print(writer);
            Object[] headCell = {"物品编码", "物品名称", "操作日期", "物品数量", "物品注释"};
            printer.printRecord(headCell);
            for (unit i: dt) {
                Object[] unitCell = {i.getID(),
                                     i.getName(),
                                     i.getDate(),
                                     i.getQuan(),
                                     i.getNote()};
                printer.printRecord(unitCell);
            }
            printer.flush();
            printer.close();
            return true;

        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean ExDetail(String path) {
        List<detail> dt = Operate.moreInfo();
        String fPath = path + "\\";
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String saveTime = formatter.format(time);
        String file = "导出的 物品进出仓数据 文件.csv";

        CSVPrinter printer = null;
        String toPath = fPath + saveTime + " " + file;

        try {

            BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (toPath,false),"GBK"));
            // FileWriter wri = new FileWriter(toPath);
            printer = CSVFormat.EXCEL.print(writer);
            Object[] headCell = {"物品编码", "物品名称", "操作日期", "操作类别", "物品数量", "物品注释"};
            printer.printRecord(headCell);
            for (detail i: dt) {
                Object[] unitCell = {i.getID(),
                        i.getName(),
                        i.getDate(),
                        i.getType(),
                        i.getQuan(),
                        i.getNote()};
                printer.printRecord(unitCell);
            }
            printer.flush();
            printer.close();
            return true;

        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
