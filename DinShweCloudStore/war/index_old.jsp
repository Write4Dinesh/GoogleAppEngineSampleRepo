<html>
<head><meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>DinShweCloudStore</title></head>
<body bgcolor="#00ff00">
<h1>Welcome to my cloud Home page</h1>
	<h2>This site is being designed to manage my personal data in
		cloud</h2>

	<table>
		<tr>
			<td colspan="2" style="font-weight: bold;">Col1 in Row1</td>
			<td colspan="2" style="font-weight: bold;">Col2 in Row1</td>
		</tr>
		<tr>
			<td><a href="login_screen.html">Login</a></td>
		</tr>
	</table>
	<%@ page import="java.util.*"%>
	<%
   Date date = new Date();
   out.print( "<h2 align=\"left\">Today's Date:" +date.toString()+"</h2>");
%>
	 	 
  <%
 	double num = Math.random();
    if (num > 0.95) {
  %>
      <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
  <%;
    } else {
  %>
      <h2>This line is displayed from Java code</h2><p>(<%= num %>)</p>
  <%
    }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
</body>
</html>