/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.util.Date; // ✅ ADD THIS
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GreetingServlet")
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve parameter 'name'
        String name = request.getParameter("name");

        // If null → set default value
        if (name == null || name.isEmpty()) {
            name = "Guest";
        }

        // ✅ Get current date & time
        Date currentDate = new Date();

        // Pass data to JSP
        request.setAttribute("name", name);
        request.setAttribute("date", currentDate); // ✅ ADD THIS

        // Forward to JSP page
        RequestDispatcher rd = request.getRequestDispatcher("greeting.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}