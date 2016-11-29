package qinqiu1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */
@WebServlet(name = "doGet")
public class doGet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet:");
        System.out.println("para1"+request.getParameter("para1"));
        System.out.println("para2"+request.getParameter("para2"));
        System.out.println(request.getHeader("header"));
        PrintWriter out=response.getWriter();
        out.write(request.getParameter("para1")+"-"+request.getParameter("para2"));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
