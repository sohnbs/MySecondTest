<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>ing="EUC-KR"%>
<%@ page import="com.board.*" %>
<%@ page import="java.util.*" %>

<%
BoardDBBean db = new BoardDBBean();
	ArrayList<BoardBean> boardList = db.listBoard();
	
	String b_name;
	String b_email;
	String b_title;
	String b_content;
	int b_id=0;
	int i;
%>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<a href="../member/logout.jsp">로그아웃</a><br>
		<center>
			<h1>
				게시판에 등록된 글 목록 보기
			</h1>
			<table width="600">
				<tr>
					<td align="right">
						<a href="write.jsp" align="right">글쓰기</a>
					</td>
				</tr>
			</table>
			<table width="800" border="1">
				<tr height="25">
					<td width="40" align="center">번호</td>
					<td width="450" align="center">글제목</td>
					<td width="120" align="center">작성자</td>
				</tr>
				<%
					for(i=0; i<boardList.size(); i++){
						BoardBean board = boardList.get(i);
						b_id = board.getB_id();
						b_title = board.getB_title();
						b_name = board.getB_name();
						b_email = board.getB_email();
				%>
						<tr height="25" bgcolor="#F7F7F7"
							onmouseover="this.style.backgroundColor='#eeeeef'" 
							onmouseout="this.style.backgroundColor='#F7F7F7'">
							
							<td align="center">
								<%= b_id %>
							</td>
							<td>
								<a href="show.jsp?b_id=<%= b_id %>">
								<%= b_title %>
							</td>
							<td>
								<a href="mailto:<%= b_email %>">
									<%= b_name %>
								</a> 
							</td>
						</tr>
				<%
					}
				%>
			</table>
		</center>
	</body>
</html>

















