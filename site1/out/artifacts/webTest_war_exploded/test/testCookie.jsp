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
//    SP Cookie 处理需要对中文进行编码与解码，方法如下：
    String str =URLEncoder.encode(request.getParameter("name"),"utf-8");
    Cookie name = new Cookie("name",
            str);
    Cookie url = new Cookie("url",
            request.getParameter("url"));
    // 设置cookie过期时间为24小时。
    name.setMaxAge(60*60*24);
    url.setMaxAge(60*60*24);

    // 在响应头部添加cookie
    response.addCookie( name );
    response.addCookie( url );
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
