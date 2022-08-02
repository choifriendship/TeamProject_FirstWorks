<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	a{
		text-decoration: none;
		color: black;		
	}
	a:hover {
		color: blue;	
	}
}
</style>
</head>
<body>
<table border="2">
	<tr>
		<td>문서번호</td>
		<td>문서제목</td>
	</tr>	
	<c:forEach items="${list}" var="list">
		<c:if test="${rank_no == 1 }">
			<tr>			
				<td><span>${list.apv_no }</span></td>
				<td><a href="/Apv_wait_detail?apv_no=${list.apv_no }"><span>${list.apv_vc_tit }</span></a></td>
			</tr>
		</c:if>
		<c:if test="${(rank_no == 2 && list.apv_mid_cf == 0)||(rank_no > 2 && list.apv_mid_cf != 0 && list.apv_fnl_cf == 0)}">
		<tr>
			<td><span>${list.apv_no }</span></td>
			<td><a href="/Apv_wait_detail?apv_no=${list.apv_no }"><span>${list.apv_vc_txt }</span></a></td>
		</tr>
		</c:if>
	</c:forEach>
</table>
<br>
<a href="/">메인으로</a>
</body>
</html>