
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CUSTOMERS;


public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery(){
    
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doRead(){
        
        try {
            String query = "Select * from CUSTOMERS";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable(){
        
        String table = "";
        
        table += "<table border=1>";
        
        
        
        table += "<th>";
        table += "CUSTID";
        table += "</th>";
        
        table += "<th>";
        table += "FIRSTNAME";
        table += "</th>";
        
        table += "<th>";
        table += "LASTNAME";
        table += "</th>";
        
        table += "<th>";
        table += "ADDR1";
        table += "</th>";
        
        table += "<th>";
        table += "ADDR2";
        table += "</th>";
        
        table += "<th>";
        table += "CITY";
        table += "</th>";
        
        table += "<th>";
        table += "STATE";
        table += "</th>";
        
        table += "<th>";
        table += "ZIP";
        table += "</th>";
        
        table += "<th>";
        table += "EMAILADDR";
        table += "</th>";
        
         table += "<th>";
        table += "Update & Delete";
        table += "</th>";
        
        try {
            while(this.results.next()){
                
                CUSTOMERS CUSTOMERS = new CUSTOMERS();
                CUSTOMERS.setCUSTID(this.results.getInt("CUSTID"));
                CUSTOMERS.setFIRSTNAME(this.results.getString("FIRSTNAME"));
                CUSTOMERS.setLASTNAME(this.results.getString("LASTNAME"));
                CUSTOMERS.setADDR1(this.results.getString("ADDR1"));
                CUSTOMERS.setADDR2(this.results.getString("ADDR2"));
                CUSTOMERS.setCITY(this.results.getString("CITY"));
                CUSTOMERS.setSTATE(this.results.getString("STATE"));
                CUSTOMERS.setZIP(this.results.getString("ZIP"));
                CUSTOMERS.setEMAILADDR(this.results.getString("EMAILADDR"));
                
                table += "<tr>";
                
                table += "<td>";
                table += CUSTOMERS.getCUSTID();
                table += "</td>";
                
                
                
                table += "<td>";
                table += CUSTOMERS.getFIRSTNAME();
                table += "</td>";
                
                
                
                table += "<td>";
                table += CUSTOMERS.getLASTNAME();
                table += "</td>";
                
           
                table += "<td>";
                table += CUSTOMERS.getADDR1();
                table += "</td>";
                
                
           
                table += "<td>";
                table += CUSTOMERS.getADDR2();
                table += "</td>";
                
                
                
                table += "<td>";
                table += CUSTOMERS.getCITY();
                table += "</td>";
                
                
                table += "<td>";
                table += CUSTOMERS.getSTATE();
                table += "</td>";
                
                
                table += "<td>";
                table += CUSTOMERS.getZIP();
                table += "</td>";
                
                
                table += "<td>";
                table += CUSTOMERS.getEMAILADDR();
                table += "</td>";
     
                table += "<td>";
                table += "<a href=update?CUSTID=" + CUSTOMERS.getCUSTID() + "> Update </a>" + "<a href=delete?CUSTID=" + CUSTOMERS.getCUSTID() + ">Delete </a>";
                table += "</td>"; 
                
                
                
                
                table += "</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        table += "</table>";
        
            return table;
        
    }
    
    
}

          
        
        
    



