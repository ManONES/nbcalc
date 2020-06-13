/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import com.ibm.wsdl.util.IOUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.net.Proxy.Type.HTTP;
import java.nio.charset.StandardCharsets;
import javax.ejb.EJB;
import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SIES
 */
@WebServlet(name = "dukeservlet", urlPatterns = {"/dukeservlet"})
public class dukeservlet extends HttpServlet {
    
    @EJB
    private calcbeanLocal calcbean;  

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
            out.println("<title>Servlet dukeservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dukeservlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws IOException {
         
        setAccessControlHeaders(response);
        
        String dukeJsonString = calcbean.dukes().toString();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(dukeJsonString);
        out.flush();   
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
        System.out.println("doPost reached");       
        setAccessControlHeaders(response);
        
//        String _Reader = request.getReader().toString();
//        System.out.println("_Reader: " + _Reader);        
//        String InputStream = request.getInputStream().toString();
//        System.out.println("InputStream: " + InputStream);        
//        String _HeaderNames = request.getHeaderNames().toString();
//        System.out.println("_HeaderNames: " + _HeaderNames);        
//        String _String = request.toString();
//        System.out.println("String: " + _String);        
//        String _RequestedSessionId = request.getRequestedSessionId();
//        System.out.println("RequestedSessionId: " + _RequestedSessionId);        
//        String _Method = request.getMethod();
//        System.out.println("Method: " + _Method);        
//        String pathInfo = request.getPathInfo();
//        System.out.println("pathInfo: " + pathInfo);
        
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
            jb.append(line);
        } catch (Exception e) {
            throw new IOException("Error recibiendo el JSON");
        }
        try {
            System.out.println("jb.toString(): " + jb.toString());
        } catch (Exception e) {
            throw new IOException("Error parsing JSON request string");
        }
        
        String mensajeJsonString = calcbean.mensajes().toString();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(mensajeJsonString);
        out.flush();   
//        processRequest(request, response);
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
    
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    
    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
    }   

}
