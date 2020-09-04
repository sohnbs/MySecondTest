<%@page import="com.member.MemberVO"%>
<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
background-color:#FFD9EC;
}
h1{
background-color:green-yellow;
}
table{
background-color:rgb(159,201,60)
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<script   src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
pwdCheck=function(){
	if($("#pwd").val()==""){
		alert("비밀번호를 입력하세요");
		return false;
	}
	if($("#pwd").val()!=$("#pwd_check").val()){
		alert("비밀번호가 일치하지 않습니다.");
		$("#pwd_check").focus();
		return false;
	}
	$("#frm").submit();
}
</script>


<%
String userid = (String)session.getAttribute("userid");
MemberDAOImpl dao = new MemberDAOImpl();
MemberVO member = dao.memberView(userid);
%>
</head>
<body>
<div align="right">
<%=userid %>님 반갑습니다<br>
<a href="../board/list.jsp">게시글보기</a><br>
<a href="logout.jsp">로그아웃</a><br>
<a href="deletePro.jsp?userid=<%=userid%>">회원탈퇴</a>

	</div>
	
	<center>
	<h2>회원정보변경</h2>
	
	<form action="updatePro.jsp" method="post" id="frm">
	<input type="hidden" name="userid" value="<%=userid%>"></td>
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name" 
				  value="<%=member.getName()%>"></td>
		  </tr>
		  	<tr>
				<td>암호</td>
				<td><input type="password" name="pwd" id="pwd" ></td>
		  </tr>
		  	<tr>
				<td>암호확인</td>
				<td><input type="password" name="pwd_check" id="pwd_check" ></td>
		  </tr>
		  	<tr>
				<td>이메일</td>
				<td><input type="text" name="email" id="email" 
				  value="<%=member.getEmail()%>"></td>
		  </tr>
			<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" id="phone" 
					  value="<%=member.getPhone()%>"></td>
			</tr>
			  <tr>
					<td>등급</td>
					<td><input type="radio" name="admin" value="0">일반회원 
			 </tr>
			  <script>
			  if(<%=member.getAdmin()%>==0){ //일반회원
				  $("input:radio[value='0']").prop("checked",true);
			  }else{ //관리자
				
			  }
			  </script>
			  <tr>
			  	<td colspan="2">
			  		<input type="button" value="수정" onclick="pwdCheck()">&nbsp; &nbsp;&nbsp; &nbsp;
			  		<input type="reset" value="취소" >&nbsp; &nbsp;
			  		
			  		
			  		
			  	</td>
			  </tr>
		
		
		</table>
	</form>
</center>
</body>
</html>
