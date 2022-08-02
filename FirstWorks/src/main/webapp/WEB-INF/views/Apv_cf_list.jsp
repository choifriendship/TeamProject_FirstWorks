<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<td>내용</td>
	</tr>	
	<c:forEach items="${list}" var="list">		
		<tr>			
			<td><span>${list.apv_no }</span></td>
			<td><a href="/Apv_cf_detail?no=${list.apv_no }"><span>${list.apv_vc_txt }</span></a></td>
		</tr>		
	</c:forEach>
</table>
<br>
<a href="/Apv_cf_list_all">전체목록</a><br>
<a href="/Apv_cf_list">내결제목록</a><br>
<a href="/">메인으로</a>
</body>
</html>