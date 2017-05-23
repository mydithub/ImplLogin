package com.mademeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mademeng on 2017/5/20.
 */
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");//设置输出内容的格式，(支持中文)
        PrintWriter out=resp.getWriter();
        String html="<h1>这是:FirstServlet<h1/>";
        out.println(html);
        out.println(req.getContextPath());
    }
}
