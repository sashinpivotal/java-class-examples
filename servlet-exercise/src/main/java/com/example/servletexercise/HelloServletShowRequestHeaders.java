package com.example.servletexercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(
        name = "helloServletShowRequestHeaders",
        urlPatterns = {"/helloShowRequestHeaders"}
)
public class HelloServletShowRequestHeaders extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Servlet Example: Showing Request Headers";
        out.println(
                "<B>Request Method: </B>" +
                        request.getMethod() + "<BR>\n" +
                        "<B>Request URI: </B>" +
                        request.getRequestURI() + "<BR>\n" +
                        "<B>Request Protocol: </B>" +
                        request.getProtocol() + "<BR><BR>\n" +
                        "\n");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<B>"+headerName +": </B>"
                        + request.getHeader(headerName) + "<BR>");
        }

    }

}