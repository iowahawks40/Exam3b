<%-- 
    Document   : add
    Created on : Apr 20, 2016, 2:14:12 PM
    Author     : zhart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Customer</title>
    </head>
    <link rel="stylesheet" href="style.css" type="text/css">
    <body>
        
         <div class="wrap">

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>
            
         <div class="main">   
            
        
        <h1>Add a New Customer</h1>
        
        <form name="addForm" action="addCustomer" method="get">
              
              <label>First Name:</label>
               <input type="text" name="FIRSTNAME" value="" />
               <br>
               <label>Last Name:</label>
               <input type="text" name="LASTNAME" value="" />
               <br>
               <label>Address 1:</label>
               <input type="text" name="ADDR1" value="" />
               <br>
               <label>Address 2:</label>
               <input type="text" name="ADDR2" value="" />
               <br>
               <label>City:</label>
               <input type="text" name="CITY" value="" />
               <br>
               <label>State:</label>
               <input type="text" name="STATE" value="" />
               <br>
               <label>Zip:</label>
               <input type="text" name="ZIP" value="" />
               <br>
               <label>Email Address:</label>
               <input type="text" name="EMAILADDR" value="" />
               <br>
               <input type="submit" name="submit" value="Submit" />
               
        </form>
        
         </div>

            <%@ include file="includes/footer.jsp" %>
            
        </div>
            
    </body>
</html>