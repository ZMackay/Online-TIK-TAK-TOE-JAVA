package Conn;

import Runnables.BoardCheck;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DBConnection {

    public static boolean checkpoint = false;

    private DBConnection() {
    }

    public static Connection con;
    private static String user = "USER";
    private static String pass = "USERPASS50";
    private static String url = "jdbc:mysql://192.168.0.52:3696/TIKTAKTOE";

    public static void startInstance() {
        Connection conTemp = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            conTemp = DriverManager.getConnection(url, user, pass);

            if (!conTemp.isClosed()) {
                System.out.println("CONNECTION SUCCESSFULLY OPENED");
            }
        } catch (SQLException e) {
            System.out.println("TRYING SECONDARY METHOD OF CONN");
            try {
                url = "jdbc:mysql://72.204.107.95:3696/TIKTAKTOE";
                conTemp = DriverManager.getConnection(url, user, pass);

                if (!conTemp.isClosed()) {
                    System.out.println("CONNECTION SUCCESSFULLY OPENED");
                }
            } catch (Exception ex) {
                return;
            }

        }
        con = conTemp;
        try {
            con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void stopInstance() {
        try {
            if (con != null) {
                while (!con.isClosed()) {
                    con.commit();
                    con.close();
                }
            }
            System.out.println("CONNECTION SUCCESSFULLY CLOSED");
        } catch (SQLException e) {
            return;
        }
    }

    public static void dbCheckPoint() {
        System.out.println("CHECKPOINT");
        try {
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkpoint = true;
        Thread turnCheck = new Thread(new BoardCheck());
        turnCheck.start();

    }

}
