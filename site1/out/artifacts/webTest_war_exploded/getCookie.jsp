<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/28
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.*" %>
<%
    Cookie ck=null;
    Cookie[] cks=null;
    cks=request.getCookies();
    if(cks!=null){
        out.println("<h2>test getCookies</h2>");
        for (Cookie cookie : cks) {
            out.println("Cookie name: "+cookie.getName()+"\r\n");
            out.println("Cookie value: "+URLDecoder.decode(cookie.getValue(),"utf-8")+"</br>");
            out.println("----------------------</br>");
        }
    }else {
        out.println("<h2>didn't find cookie!</h2>");
    }
%>
<html>
<head>
    <title>test cookie</title>
</head>
<body>

<h1>设置 Cookie</h1>

<ul>
    <li><p><b>网站名:</b>
        <%= request.getParameter("name")%>
    </p></li>
    <li><p><b>网址:</b>
        <%= request.getParameter("url")%>
    </p></li>
</ul>
</body>
</html>
