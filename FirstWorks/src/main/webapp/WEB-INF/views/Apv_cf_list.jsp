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
		<td>������ȣ</td>
		<td>����</td>
	</tr>	
	<c:forEach items="${list}" var="l">		
		<tr>			
			<td><span>${l.no }</span></td>
			<td><a href="/cfdetail?no=${l.no }"><span>${l.text }</span></a></td>
		</tr>		
	</c:forEach>
</table>
<br>
<a href="/cflistall">��ü���</a><br>
<a href="/cflist">���������</a><br>
<a href="/">��������</a>
</body>
</html>