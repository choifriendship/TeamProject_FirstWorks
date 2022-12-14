<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 이모티콘 -->
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="/resources/css/header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="/resources/css/aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="/resources/css/mailform.css" /><!-- basic css -->
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
	
    <section id="message_box">
    <form method="post" action="/email/writepro"> 
      <!-- post방식으로 자료를 컨트롤러로 보냄 -->
      <div id="write_msg">
	<input type="hidden" value="${mem_no}" name='memnum'><br>
	<input type="hidden" value="${mem_eml}" name='sendermail'> <br>
	        <ul>
	            <li>
	                <span class="col1">보내는 사람 : </span>
	                <span class="col2">${mem_nm}</span>
	            </li>
	            <li>
	                <span class="col1">수신 이메일: </span>
	                <span class="col2"><input name='receivemail'></span>
	            </li>
	            <li>
	                <span class="col1">제목 : </span>
	                <span class="col2"><input name='title'></span>
	            </li>
	            <li id="textarea">
	                <span class="col1">내용 : </span>
	                <span class="col2"><textarea rows="5" cols="80" name='content'></textarea></span>
	            </li>                                
	        </ul>
	        <!-- 서밋버튼 -->
	        <input type="submit" value="보내기">
    	</div>
      </form>
</section>

</body>
</html>
