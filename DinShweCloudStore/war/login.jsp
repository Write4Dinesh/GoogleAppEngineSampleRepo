<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>My Webstore login screen</title>
    
        <link rel="stylesheet" href="assets/css/login.css">
    
  </head>

  <body>
<%@ page import="java.util.*"%>
	<%
   Date date = new Date();
   out.print( "<h2 align=\"left\">Today's Date:" +date.toString()+"</h2>");
%>
    <div class="wrapper">
	<div class="container">
		<h1>Welcome</h1>
		
		<form action="/loginservlet" method="POST">
			<input type="text" placeholder="Username" id="username" name="user_name" value="DineshMasthaiah">
			<input type="password" placeholder="Password" name="password"  value="DinPassword">
			<button type="submit" value="Login">Login</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="assets/js/login.js"></script>

    
    
    
  </body>
</html>
