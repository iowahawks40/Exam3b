/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbHelpers.UpdateQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CUSTOMERS;

/**
 *
 * @author zhart
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/updateCustomer"})
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        // Pass execution on to doPost
        doPost(request, response);
    }
        
 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get the form data and set up a Customer object
        
        int CUSTID = Integer.parseInt(request.getParameter("CUSTID"));
        String FIRSTNAME = request.getParameter("FIRSTNAME");
        String LASTNAME = request.getParameter("LASTNAME");
        String ADDR1 = request.getParameter("ADDR1");
        String ADDR2 = request.getParameter("ADDR2");
        String CITY = request.getParameter("CITY");
        String STATE = request.getParameter("STATE");
        String ZIP = request.getParameter("ZIP");
        String EMAILADDR = request.getParameter("EMAILADDR");
        
                
       CUSTOMERS CUSTOMERS = new CUSTOMERS();
       CUSTOMERS.setCUSTID(CUSTID);
       CUSTOMERS.setFIRSTNAME(FIRSTNAME);
       CUSTOMERS.setLASTNAME(LASTNAME);
       CUSTOMERS.setADDR1(ADDR1);
       CUSTOMERS.setADDR2(ADDR2);
       CUSTOMERS.setCITY(CITY);
       CUSTOMERS.setSTATE(STATE);
       CUSTOMERS.setZIP(ZIP);
       CUSTOMERS.setEMAILADDR(EMAILADDR);
       
       
       
       //create an UpdateQuery object and use it to update the customer
       UpdateQuery uq = new UpdateQuery();
       uq.doUpdate(CUSTOMERS);
       
       //pass control to the ReadServlet
       String url = "/read";
       
       RequestDispatcher dispatcher = request.getRequestDispatcher(url);
       dispatcher.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
