
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


public class ReadRecord {

    private Connection conn;
    private ResultSet results;
    private CUSTOMERS CUSTOMERS = new CUSTOMERS();
    private int CUSTID;
    
    
public ReadRecord (int CUSTID) {
   
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
    
    this.CUSTID = CUSTID;
    
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    public void doRead(){
        
        try {
            
            //set up a string to hold our query
            String query = "SELECT * FROM CUSTOMERS WHERE CUSTID = ?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement (query);
            
            //fill in the preparedstatement
            ps.setInt (1, CUSTID);
            
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            CUSTOMERS.setCUSTID(this.results.getInt("CUSTID"));
            CUSTOMERS.setFIRSTNAME(this.results.getString("FIRSTNAME"));
            CUSTOMERS.setLASTNAME(this.results.getString("LASTNAME"));
            CUSTOMERS.setADDR1(this.results.getString("ADDR1"));
            CUSTOMERS.setADDR2(this.results.getString("ADDR2"));
            CUSTOMERS.setCITY(this.results.getString("CITY"));
            CUSTOMERS.setSTATE(this.results.getString("STATE"));
            CUSTOMERS.setZIP(this.results.getString("ZIP"));
            CUSTOMERS.setEMAILADDR(this.results.getString("EMAILADDR"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public CUSTOMERS getCUSTOMERS(){
    
    return this.CUSTOMERS;
    
}
}

