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
	<h4><a href="/Login_form">로그인</a></h4>
	<h4><a href="/Mem_form">멤버가입</a></h4>
</c:if>
<c:if test="${mem_no != null }">
	<c:if test="${rank_no==1 }">
		<h4><a href="/Apv_vc_form">휴가결재</a></h4>
	</c:if>
	<c:if test="${rank_no==2 }">
		<h4><a href="/Apv_vc_form1">휴가결재</a></h4>
	</c:if>
	<c:if test="${rank_no==3 }">
		<h4><a href="/Apv_vc_form2">휴가결재</a></h4>
	</c:if>	
	<h4><a href="/Apv_wait_list">결재대기함</a><c:if test="${count!=0}"><span id="c">${count }</span></c:if></h4>	
	<h4><a href="/Apv_cf_list">결재완료함</a></h4>
	<h4><a href="/Apv_rjt_list">반려함</a></h4>
	<h4><a href="/Logout">로그아웃</a></h4>
</c:if>
<%-- <h4>레벨:${lev }</h4>
<h4>카운트:${count }</h4> --%>
</body>
</html>
