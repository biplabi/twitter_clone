<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.bbd.server.UserBean"
    import = "com.bbd.server.PostBean"
    import = "java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		UserBean ub = (UserBean)session.getAttribute("ub");
	%>

	<%
		String msg = (String)request.getAttribute("msg");
		out.println(msg + "<br>");
		String uName = (String) ub.getuName();
		out.println("Welcome " + uName + "!<br>");
	%>
	
	
	<hr>
	<h2>Add a new post</h2>
	<form action = "addPost" method = "post">
		<textarea name = "content" placeholder = "Write something..." rows="4" cols="50" required></textarea><br>
		<input type = "hidden" name = "uid" value = "<%= ub.getuId() %>">
		<input type = "submit" value = "post">
	</form>
	<hr>
	<h2>Welcome to your feed</h2>
	<%
		ArrayList<PostBean> pl = (ArrayList<PostBean>)session.getAttribute("pl");
	
		Iterator<PostBean> it = pl.iterator();
		
		while(it.hasNext())
		{
			PostBean pb = it.next();
			
			out.println(pb.getPostId() + "&nbsp&nbsp" + pb.getUserId() + "&nbsp&nbsp" + pb.getContent() + "&nbsp&nbsp" + pb.getCreatedAt() + "&nbsp&nbsp" + pb.getLikeCount() + "likes" + " <a href = 'like?pid="+ pb.getPostId() +"&uid="+ pb.getUserId() +"'>Like</a><br>");
				
		}
	%>
	
</body>
</html>