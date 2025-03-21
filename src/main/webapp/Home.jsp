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
<link rel = "stylesheet" href = "home.css">
</head>
<body>	
	<div id = "menu-section">
		<p id = "logo" style="
				    display: flex;
				    justify-content: center;
				    font-size: 2vw;
				    font-weight: bold;">B!B@</p>
		<div id = "menu">
			<div class = "item">
				<a href = "Home.jsp">
					<img src = "./images/home.png" alt = "home"/>
					Home
				</a>
			</div>
			<div class = "item">
				<a href = "Home.jsp">
					<img src = "./images/search.png" alt = "explore"/>
					Explore
				</a>
			</div>
			<div class = "item">
				<a href = "Home.jsp">
					<img src = "./images/notification.png" alt = "notification"/>
					Notifications
				</a>
			</div>
			<div class = "item">
				<a href = "Home.jsp">
					<img src = "./images/messages.png" alt = "message"/>
					Messages
				</a>
			</div>
			<div class = "item">
				<a href = "Home.jsp">
					<img src = "./images/grok.png" alt = "grok"/>
					Grok
				</a>
			</div>
			<div class = "item">
				<a href = "Home.jsp">
					<img src = "./images/profile.png" alt = "profile"/>
					Profile
				</a>
			</div>
			<div class = "item">
				<a href = "Home.jsp">
					<img src = "./images/more.png" alt = "more"/>
					More
				</a>
			</div>
		
		</div>
	</div>
	
	<div id= "post-section">
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
			<textarea name = "content" placeholder = "What is happening?!" rows="4" cols="50" required></textarea><br>
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
				
				String base64Image = "";
				
				if(pb.getProfilePic() != null)
				{
					base64Image = Base64.getEncoder().encodeToString(pb.getProfilePic());
				}
				
		%>
			<div id = "post-container">
				<div id = "post-heading">
					<img src="data:image/jpeg;base64,<%= base64Image %>" alt="Profile Picture" width="40" height="40">
					<!-- <p><%= pb.getPostId() %></p> -->
					<!-- <p><%= pb.getUserId() %></p> -->
					<p><%= pb.getuName() %></p>
					<p><%= pb.getCreatedAt() %></p>
				</div>
				<div id = "post-content">
					<p><%= pb.getContent() %></p>
				</div>
				<div id = "post-footer">
					<div id = "like-box">
						<div id= "likes"><%= pb.getLikeCount() %> likes</div>
						<a href = "like?pid=<%= pb.getPostId() %>&uid=<%= pb.getUserId() %>"><img src = "./images/like-btn.png" style = "width: 1.5vw" alt = "like-btn"/></a>
					</div>
				</div>
			</div>
		<%			
			}
		%>
	
	</div>
	
</body>
</html>