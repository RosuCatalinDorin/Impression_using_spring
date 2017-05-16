
package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Impression {
    
    private int id;
 private String username;
 private String text;

    public int getId() {
    return id;
}
    public String getUsername() {
    return username;
}
    public String getText() {
    return text;
}
    public void setId(int id) {
    this.id = id;
}
    public void setUsername(String username) {
    this.username = username;
}
    public void setText(String text) {
    this.text = text;
}
    public static String allImpressions() throws ClassNotFoundException, SQLException {
        
        StringBuilder all_impressions = new StringBuilder();

        
        Class.forName("com.mysql.jdbc.Driver");

        try (java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/inpresion_db", "root", "Burriana_29red");)
 {
        Statement st = conn.createStatement();
        st.executeQuery("select username, text from impression");
         ResultSet rs = st.getResultSet();
            
         while (rs.next()) {
 
             all_impressions.append(rs.getString("username"));
             all_impressions.append(": ");
             all_impressions.append(rs.getString("text"));
             all_impressions.append("\n");
             
 }
 } catch (SQLException ex) {
     
           all_impressions.append(ex.getMessage());
 }
            return all_impressions.toString();
 }
    
        
            public void insertImpression() throws ClassNotFoundException {

                Class.forName("com.mysql.jdbc.Driver");
 
 try (java.sql.Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/inpresion_db", "root", "Burriana_29red");) {

     if (username != null && !(username.isEmpty()) && text != null && !(text.isEmpty())) {
 
         Statement st = conn.createStatement();
 
         st.execute("insert into impression(username,text) values ('" + username + "','" + text +"')");
 }
 } catch (SQLException ex) {
 
     System.out.println("Error in databaseconnection: \n" + ex.getMessage());
 }
 }

    
    
}
