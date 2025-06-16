/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.oracle.wls.shaded.org.apache.bcel.generic.D2F;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class DBContext {

    protected Connection connection;

    /**
     * get an connection
     *
     * @return connection or null
     * @throws ClassNotFoundException
     */
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://THANH-TMP21\\SQLEXPRESS:1433;databaseName=book2;trustServerCertificate=true;";
            String user = "tmp";
            String password = "123";
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error " + e.getMessage() + " at DBContext");
            return null;
        }
    }
    public static void main(String[] args) {
        DBContext test = new DBContext() ;
        test.connection = test.getConnection() ;
        System.out.println(test.connection);
    }

   
}
