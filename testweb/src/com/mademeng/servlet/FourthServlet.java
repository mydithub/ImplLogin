package com.mademeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mademeng on 2017/5/20.
 * urlPatterns = {"/FourthServlet"} 相当于<url-pattern>/ThirdServlet</url-pattern>
 * "/" 必须有
 */
@WebServlet(urlPatterns = {"/FourthServlet"})
public class FourthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        out.println("<h1>This is FourthServlet.<h1/>");
    }
}
