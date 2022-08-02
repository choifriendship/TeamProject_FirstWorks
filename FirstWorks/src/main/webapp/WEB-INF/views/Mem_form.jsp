<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="mem_insert_pro" method="post">
	사원번호:<input type="number" name="mem_no"><br>
	부서번호:<input type="number" name="dept_no"><br>
	아이디:<input type="text" name="mem_id"><br>
	비번:<input type="text" name="mem_pw"><br>
	이름:<input type="text" name="mem_nm"><br>
	이메일:<input type="text" name="mem_eml"><br>
	전화번호:<input type="tel" name="mem_tel"><br>
	사원도장:<input type="text" name="mem_stamp"><br>
	직급:<input type="number" name="rank_no"><br>
	<input type="submit" value="완료"> 
</form>
</body>
</html>