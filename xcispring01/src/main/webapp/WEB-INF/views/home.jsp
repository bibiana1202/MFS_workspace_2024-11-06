<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello Sprint~!
</h1>

<P>  The time on the server is ${serverTime}. </P>
<ol>
	<li><a href="/mvc">spring mvc 1.0</a>
	<li><a href="/board/list">board list</a>
</ol>
<img src="/resources/img/a.jpg"/>
</body>
</html>
