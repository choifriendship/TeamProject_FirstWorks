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
<c:forEach var="Apv_cf_wait" items="${list1 }">     
	<a href="/cfdetail?apv_no=${Apv_cf_wait.apv_no }">${Apv_cf_wait.apv_vc_tit }</a><br>
</c:forEach>
</body>
</html>