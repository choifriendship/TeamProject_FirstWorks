<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
        #brej{       
            position: absolute;
            z-index: -9999;     
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            /*backdrop-filter: blur(5px);*/
        }
        #rej{
            display: none;
            position: fixed;
            top: calc(50vh - 300px); left: calc(50vw - 200px);
            background-color: #999AFE;            
            border-radius: 10px;
            width: 400px;
            height: 600px;    
            z-index: 999;  
            opacity: 1; 
        }
        #b{
            display: flex;
            justify-content: center; align-items: center;
        }
        #cus{
            width: 90%; height: 440px;
        }
        #b1{
            margin-top: 20px;
            display: flex;
            justify-content: center; align-items: center;
        }
    </style>
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
	<c:if test="${lev==2 }">
		<form action="/twocf" method="post">
			<input type="submit" value="결재">
			<input type="hidden" value="${list.no }" name="no"> 
			<input type="button" id="modal" onclick="aaa()" value="반려"></input>			
		</form>
	</c:if>
	<c:if test="${lev==3 }">
		<form action="/threecf" method="post">
			<input type="submit" value="결재">
			<input type="hidden" value="${list.no }" name="no"> 
			<input type="button" id="modal" onclick="aaa()" value="반려"></input>			
		</form>
	</c:if>	  
	<div id="brej">        
        <div id="rej">
            <form action="/rej">
                <div id="b">
                    <h1>반려사유</h1>
                </div>
                <div id="b">
                    <textarea id="cus" name="rej"></textarea>
                </div>
                <div id="b1">
                    <input type="submit" value="반려">
                    <input type="button" value="접기" onclick="bbb()">
                    <input type="hidden" value="${list.no }" name="no"> 
                    <input type="hidden" value="${mem_no}" name="one_no">                   
                </div>
            </form>
        </div>
    </div>	
<script type="text/javascript">
function aaa(){
    document.querySelector("#modal").style.color = 'red';
    document.querySelector("#rej").style.display = 'block';
         
}
function bbb(){
    document.querySelector("#modal").style.color = 'black';
    document.querySelector("#rej").style.display = 'none';
}
</script>
</body>
</html>