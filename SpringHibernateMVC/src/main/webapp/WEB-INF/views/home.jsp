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

<form action="api/cursos/save" method="POST">
	<input name="curso" type="text" placeholder="NOMBRE"/><br/>
	<input type="submit" value="GUARDAR"/><br/>
</form>
</body>
</html>
