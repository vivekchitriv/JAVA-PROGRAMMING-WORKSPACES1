<%@ page language="java" contentType="text/html; "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			String name = request.getParameter("uname");
			int a = Integer.parseInt(application.getInitParameter("a"));
			int b = Integer.parseInt(config.getInitParameter("b"));
			out.println("welcome :"+name);
			out.println("<br>===servletContext=====");
			out.println("<br>Server Info:"+application.getServerInfo());
			out.println("<br> The Value a:"+a);
			out.println("<br>===Servlet Config====");
			out.println("<br> Jsp Name:"+config.getServletName());
			out.println("<br> The Value b:"+b);
		%>
</body>
</html>