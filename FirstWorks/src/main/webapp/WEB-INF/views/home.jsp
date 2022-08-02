<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
	#c{
		color: black;
		border: 1px solid red;
		background-color: red;
		border-radius: 100px;  
	}
</style>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is </P>
<c:if test="${mem_no==null }">
	<h4><a href="/login">로그인</a></h4>
	<h4><a href="/mem_form">멤버가입</a></h4>
</c:if>
<c:if test="${mem_no != null }">
	<c:if test="${lev==1 }">
		<h4><a href="/vcform">휴가결재</a></h4>
	</c:if>
	<c:if test="${lev==2 }">
		<h4><a href="/vcformtwo">휴가결재</a></h4>
	</c:if>
	<c:if test="${lev==3 }">
		<h4><a href="/vcformthree">휴가결재</a></h4>
	</c:if>	
	<h4><a href="/watinglist">결재대기함</a><c:if test="${count!=0}"><span id="c">${count }</span></c:if></h4>	
	<h4><a href="/cflist">결재완료함</a></h4>
	<h4><a href="/rejlist">반려함</a></h4>
	<h4><a href="/logout">로그아웃</a></h4>
</c:if>
<%-- <h4>레벨:${lev }</h4>
<h4>카운트:${count }</h4> --%>
</body>
</html>
