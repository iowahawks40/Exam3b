
package model;

public class CUSTOMERS {
    
    private int CUSTID;
    private String FIRSTNAME;
    private String LASTNAME;
    private String ADDR1;
    private String ADDR2;
    private String CITY;
    private String STATE;
    private String ZIP;
    private String EMAILADDR;

    
    public CUSTOMERS() {
        this.CUSTID = 0;
        this.FIRSTNAME = "";
        this.LASTNAME = "";
        this.ADDR1 = "";
        this.ADDR2 = "";
        this.CITY = "";
        this.STATE = "";
        this.ZIP = "";
        this.EMAILADDR = "";
    }
    
    public CUSTOMERS(int CUSTID, String FIRSTNAME, String LASTNAME, String ADDR1, String ADDR2, String CITY, String STATE, String ZIP, String EMAILADDR) {
        this.CUSTID = CUSTID;
        this.FIRSTNAME = FIRSTNAME;
        this.LASTNAME = LASTNAME;
        this.ADDR1 = ADDR1;
        this.ADDR2 = ADDR2;
        this.CITY = CITY;
        this.STATE = STATE;
        this.ZIP = ZIP;
        this.EMAILADDR = EMAILADDR;
    }

    public int getCUSTID() {
        return CUSTID;
    }

    public void setCUSTID(int CUSTID) {
        this.CUSTID = CUSTID;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getADDR1() {
        return ADDR1;
    }

    public void setADDR1(String ADDR1) {
        this.ADDR1 = ADDR1;
    }

    public String getADDR2() {
        return ADDR2;
    }

    public void setADDR2(String ADDR2) {
        this.ADDR2 = ADDR2;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public String getEMAILADDR() {
        return EMAILADDR;
    }

    public void setEMAILADDR(String EMAILADDR) {
        this.EMAILADDR = EMAILADDR;
    }

    @Override
    public String toString() {
        return "CUSTOMERS{" + "CUSTID=" + CUSTID + ", FIRSTNAME=" + FIRSTNAME + ", LASTNAME=" + LASTNAME + ", ADDR1=" + ADDR1 + ", ADDR2=" + ADDR2 + ", CITY=" + CITY + ", STATE=" + STATE + ", ZIP=" + ZIP + ", EMAILADDR=" + EMAILADDR + '}';
    }
    
    
    
    
}