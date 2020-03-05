<%@ page language="java" contentType="text/html; "%>
<!DOCTYPE html>
<html>
<head>

<title>JSP APP2</title>
</head>
<body>
	<% 
		String uName = request.getParameter("uname");
		String mId = request.getParameter("mid");
		out.println("User Name:"+uName);
		out.println("<br>Mail Id:"+mId);
	%>
</body>
</html>