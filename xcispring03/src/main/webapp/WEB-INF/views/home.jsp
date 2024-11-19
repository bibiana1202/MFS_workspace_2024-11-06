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

<P>  The time on the server is ${serverTime}. </P>
<ol>
	<li><a href="/board/list">board list</a>
	<li><a href="/uploadForm">file upload</a>	
</ol>
</body>
</html>
