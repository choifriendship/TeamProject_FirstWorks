<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<c:forEach var="cfwait" items="${list1 }">     
	<a href="/cfdetail?apv_no=${cfwait.apv_no }">${cfwait.apv_vc_tit }</a><br>
</c:forEach>
</body>
</html>