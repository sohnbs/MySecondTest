<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.board.*" %>

<jsp:useBean id="board" class="com.board.BoardBean">
	<jsp:setProperty name="board" property="*"/>
</jsp:useBean>
<%
BoardDBBean db = new BoardDBBean();
	if(db.insertBoard(board) == 1){
		response.sendRedirect("list.jsp");
	}else{
		response.sendRedirect("write.jsp");
	}
%>
















