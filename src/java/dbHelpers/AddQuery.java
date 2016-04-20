
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CUSTOMERS;


public class AddQuery {
    
    private Connection conn;
    
    public AddQuery(){
        
        Properties props = new Properties();
        InputStream instr = getClass() . getResourceAsStream("dbConn.properties");
        
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doAdd(CUSTOMERS CUSTOMERS){
        
        try {
            String query = "INSERT INTO CUSTOMERS (FIRSTNAME, LASTNAME, ADDR1, ADDR2, CITY, STATE, ZIP, EMAILADDR) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, CUSTOMERS.getFIRSTNAME());
            ps.setString(2, CUSTOMERS.getLASTNAME());
            ps.setString(3, CUSTOMERS.getADDR1());
            ps.setString(4, CUSTOMERS.getADDR2());
            ps.setString(5, CUSTOMERS.getCITY());
            ps.setString(6, CUSTOMERS.getSTATE());
            ps.setString(7, CUSTOMERS.getZIP());
            ps.setString(8, CUSTOMERS.getEMAILADDR());
            
                
          
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            
    
}

    
    
