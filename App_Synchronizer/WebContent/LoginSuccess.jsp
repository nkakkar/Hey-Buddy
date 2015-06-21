<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("username")==null)
{
	response.sendRedirect("/SignIn.html");
}
else user = (String)session.getAttribute("username");
String userNew = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies!=null)
{
	for(Cookie cookie:cookies)
	{
		if(cookie.getName().equals("username")) userNew = cookie.getValue();
		if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
	}
}
%>

<h3>Hi <%=userNew %>, Login Successful! </h3><br>
Your Session ID = <%=sessionID %>. <br>
User = <%=user %><br>
<a href="FindConnections.jsp">Find Your Connections</a>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout"/>
</form>
</body>
</html>