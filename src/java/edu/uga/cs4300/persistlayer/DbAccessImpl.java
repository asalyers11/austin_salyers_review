
package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAccessImpl {
    
    
    public static Connection connect() {
        
        Connection conn = null;
        try {
            Class.forName(DbAccessConfiguration.DRIVE_NAME);

            
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } 
        try {
            conn = DriverManager.getConnection(  DbAccessConfiguration.CONNECTION_URL, 
                                                DbAccessConfiguration.DB_CONNECTION_USERNAME, 
                                                DbAccessConfiguration.DB_CONNECTION_PASSWORD);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return conn;
    }
    
    public static ResultSet retrieve( Connection conn, String query) {
        ResultSet rset = null;
        try {
                Statement stmt = conn.createStatement();
                rset = stmt.executeQuery(query);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return rset;      
    }
    
    public static int create( Connection conn, String query) {
        System.out.println("DbAccessImpl.create entered-----------------------");
        int rowCount = 0;
        try{
            Statement stmt = conn.createStatement();
            System.out.println("++" + query + "++");
            rowCount = stmt.executeUpdate(query);
            System.out.println( rowCount );
            
        } catch (SQLException e) {
            System.out.println("DbAccessImpl.create: SQLexception" + e.toString() );
        
        }
        return rowCount;
    }
    
    public static int update( Connection conn, String query) {
        int rowCount = 0;
        try{
            Statement stmt = conn.createStatement();
            rowCount = stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
    
    public static int delete( Connection conn, String query) {
        int rowCount = 0;
        try{
            Statement stmt = conn.createStatement();
            rowCount = stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
    
    public static void disconnect(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

}
