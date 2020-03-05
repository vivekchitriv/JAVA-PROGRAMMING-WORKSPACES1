<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.*"
    errorPage="Error.jsp"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%=new Date()%>
			<%! int fact;
			int factorial(int n)
			{
				fact=1;
				for(int i=n;i>=1;i--)
				{
					fact =fact*i;
				}
				return fact;
			}
			%>	
			<%
				int n=Integer.parseInt(request.getParameter("val"));
				out.println("factorial:"+factorial(n)+"<br>");			
			%>
			<%@include file="input.html" %>
</body>
</html>