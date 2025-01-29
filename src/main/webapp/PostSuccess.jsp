<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.bbd.server.UserBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
	
		out.println(msg + "<br>");
		
		UserBean ub = (UserBean)session.getAttribute("ub");
		out.println("Page belongs to: " + ub.getuName());
		
	%>
	
</body>
</html>