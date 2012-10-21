/*
 * DataOperation.java
 *
 * Created on August 5, 2008, 9:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mp3tags;
import java.io.*;
import java.lang.*;
import java.sql.* ;
/**
 *
 * @author Raghu
 */
public class DataOperation {
    
    Connection con;
    PreparedStatement ps;
    
    public DataOperation() throws SQLException {
    try {Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle Driver
         } catch (java.lang.ClassNotFoundException e) {
            System.out.printf("ClassNotFoundException: " + e.getMessage());
}
    con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","govind","270289gk");
    }
    void Insert (ID3v1 mp3tag,File song) throws SQLException
    {
         String insertStmt= "INSERT INTO MUSIC VALUES (?, ?, ?, ?, ?)";
              ps = con.prepareStatement(insertStmt);
              ps.setString(1,mp3tag.Title);
              ps.setString(2,song.getAbsolutePath());
              ps.setString(3,mp3tag.Artist); 
              ps.setString(4,mp3tag.Album); 
              ps.setString(5,mp3tag.Year); 
              ResultSet rs = ps.executeQuery();
              //System.out.println(mp3tag.Title); 
              ps.close();  
}
    void Select(String Table) throws SQLException
    {
         String a;
       String insertStmt= "SELECT * FROM MUSIC";
              ps = con.prepareStatement(insertStmt);
             // ps.setString(1,Table);
              ResultSet rs = ps.executeQuery();
              
              rs.next();
              a = rs.getString(5);System.out.println(a);
              ps.close();   
    }
    
}
