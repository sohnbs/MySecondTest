<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.board.*"%>

<%
	int bid=Integer.parseInt(request.getParameter("b_id"));
	BoardDBBean db= new BoardDBBean();
	BoardBean board = db.getBoard(bid);
	
	String b_name="";
	String b_title="";
	String b_content="";
	String b_email="";
	int b_id=0;
	
	if(board !=null){
		b_id = board.getB_id();
		b_name = board.getB_name();
		b_email = board.getB_email();
		b_title = board.getB_title();
		b_content = board.getB_content();
	}
%>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<a href="list.jsp">게시글보기</a><br>
		<a href="../member/logout.jsp">로그아웃</a><br>
		<center>
			<h1>
				글 내 용 보 기 		</h1> 
			

		
			<table border="1" width="600">
				<tr height="30" align="center">
					<td width="100">글번호</td>
					<td width="200"><%= b_id %></td>
				</tr>
				<tr height="30" align="center">
					<td width="100">작성자</td>
					<td width="200"><%= b_name %>&nbsp;</td>
				</tr>
				<tr height="30" align="center">
					<td width="100">글제목</td>
					<td colspan="3"><%= b_title %>&nbsp;</td>
				</tr>
				<tr height="30" align="center">
					<td width="100">글내용</td>
					<td colspan="3"><%= b_content %>&nbsp;</td>
				</tr>
			</table>
		</center>
	</body>
</html>
















