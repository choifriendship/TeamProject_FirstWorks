<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>휴가결재서</h1>
	<h4>사원</h4>
		<c:if test="${list.one_stamp!=null }">
			<p>${list.one_stamp }</p>
		</c:if> 
	<h4>중간관리자</h4>
		<c:if test="${list.two_stamp!=null }">
			<p>${list.two_stamp }</p>
		</c:if> 
	<h4>최종관리자</h4>
		<c:if test="${list.three_stamp!=null }">
			<p>${list.three_stamp }</p>
		</c:if> 
	<h1>결재내용</h1>
	<p>${list.text }</p>	
</body>
</html>