<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 	
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
	<h1>휴가결재서</h1>
	<h4>사원 ${mem_no }</h4>
	<p></p>
	<h4>중간관리자</h4>
	<p></p>
	<h4>최종관리자</h4>
	<p></p>
	<input type="hidden" name="mem_no" value="${mem_no }"/>
	신청서 제목:<input type="text" name="apv_vc_tit">
	첨부파일:<input type="text" name="apv_vc_file">
	반려사유:<input type="text" name="apv_vc_rjt">
	신청서 제목:<input type="text" name="apv_vc_txt">
	휴가시작날짜:<input type="date" name="apv_vc_str_dt">
	휴가종료날짜:<input type="date" name="apv_vc_tit">
	기안부서: ${dept_no }<input type="hidden" name="dept_no" value="${dept_no }"/>
	<h1>결재내용</h1>
	<form action="/Apv_vc_pro" method="post">
		<textarea rows="40" cols="40" name="text"></textarea>
		<input type="submit" value="완료">		
	</form>
</body>
</html>