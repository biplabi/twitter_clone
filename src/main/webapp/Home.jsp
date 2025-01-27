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
		String uName = (String)request.getAttribute("uName");
		out.println("Welcome " + uName);
	%>
	
	<%
		UserBean ub = (UserBean)session.getAttribute("ub");
	%>
	<h2>Add a new post</h2>
	<form action = "addPost" method = "post">
		<textarea name = "content" placeholder = "Write something..." rows="4" cols="50" required></textarea><br>
		<input type = "hidden" name = "uid" value = "<%= ub.getuId() %>">
		<input type = "submit" value = "post">
	</form>
</body>
</html>