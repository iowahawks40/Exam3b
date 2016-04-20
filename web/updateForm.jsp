<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.CUSTOMERS"%>
<% CUSTOMERS CUSTOMERS = (CUSTOMERS) request.getAttribute("CUSTOMERS"); %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>Update a Customer</title>
    </head>
    <body>
        <h1>Update a Customer Record</h1>
        
        <form name="updateForm" action="updateCustomer" method="get">
              
            <label>Customer ID:</label>
               <input type="text" name="CUSTID" value="<%= CUSTOMERS.getCUSTID()%>" readonly />
               <br>
              <label>First Name:</label>
               <input type="text" name="FIRSTNAME" value="<%= CUSTOMERS.getFIRSTNAME()%>" />
               <br>
               <label>Last Name:</label>
               <input type="text" name="LASTNAME" value="<%= CUSTOMERS.getLASTNAME()%>" />
               <br>
               <label>Address 1:</label>
               <input type="text" name="ADDR1" value="<%= CUSTOMERS.getADDR1()%>" />
               <br>
               <label>Address 2:</label>
               <input type="text" name="ADDR2" value="<%= CUSTOMERS.getADDR2()%>" />
               <br>
               <label>City:</label>
               <input type="text" name="CITY" value="<%= CUSTOMERS.getCITY()%>" />
               <br>
               <label>State:</label>
               <input type="text" name="STATE" value="<%= CUSTOMERS.getSTATE()%>" />
               <br>
               <label>Zip:</label>
               <input type="text" name="ZIP" value="<%= CUSTOMERS.getZIP()%>" />
               <br>
               <label>Email Address:</label>
               <input type="text" name="EMAILADDR" value="<%= CUSTOMERS.getEMAILADDR()%>" />
               <br>
               <input type="submit" name="submit" value="Update" />
               
        </form>
    </body>
</html>
