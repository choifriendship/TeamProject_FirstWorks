<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<c:forEach items="${list}" var="l">		
		<tr>			
			<td><span>${l.no }</span></td>
			<td><a href="/cfdetail?no=${l.no }"><span>${l.text }</span></a></td>
		</tr>		
	</c:forEach>
</table>
<br>
<a href="/cflistall">전체목록</a><br>
<a href="/cflist">내결제목록</a><br>
<a href="/">메인으로</a>
</body>
</html>