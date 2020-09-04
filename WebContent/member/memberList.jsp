<%@page import="com.member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="member.js"> </script>

<%
String userid =(String)session.getAttribute("userid");
MemberDAOImpl dao = new MemberDAOImpl();
ArrayList<MemberVO> arr= dao.memberList();
%>
</head>
<body>
<div align="right">
<%= userid %> 관리자 님 반갑습니다.
<a href="logout.jsp">로그아웃</a>   
</div>
<center>
	<h3>회원관리(관리자모드)</h3>
		<table border = "1">
			<thead>
				<tr>
					<th>이름</th>
					<th>아이디</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>구분</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
		<%
				for(MemberVO mvo :arr){
					String mode =mvo.getAdmin()==0?"일반회원":"관리자";
		%>		
					<tr>
						<td><%=mvo.getName() %></td>
						<td><%=mvo.getUserid() %></td>
						<td><%=mvo.getEmail() %></td>
						<td><%=mvo.getPhone() %></td>
					    <td><%=mode %></td>
					    
					    <td onclick="del('<%=mvo.getUserid()%>')">삭제</td>  
					  
					</tr>
				
		<%
				}
		%>		
				
		
			
			</tbody>
		</table>
</center>

</body>
</html>