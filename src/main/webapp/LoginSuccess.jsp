<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		String uName = (String)request.getAttribute("uName");
		out.println("Welcome " + uName);
	%>
</body>
</html>