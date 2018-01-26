<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form action="login" method="POST">
	<input name="u" type="text" placeholder="USUARIO"/><br/>
	<input name="p" type="password" placeholder="PASSWORD"/><br/>
	<input type="submit" value="LOG IN"/><br/>
</form>
</body>
</html>
