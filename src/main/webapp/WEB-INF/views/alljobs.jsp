<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="job" items="${jobs}" >
<h3>${job}</h3>
</c:forEach>

</body>
</html>