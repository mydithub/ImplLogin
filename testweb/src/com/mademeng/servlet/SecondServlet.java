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
 */

/**
 * 使用注解
 * urlPatterns = {"/SecondServlet"} 相当于<url-pattern>/SecondServlet</url-pattern>
 * 必须有"/"
 */
@WebServlet(urlPatterns = {"/SecondServlet"})
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");//
        PrintWriter out=resp.getWriter();
        out.println("<h1>这是:SecondServlet<h1/>");
    }
}
