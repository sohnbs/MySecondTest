<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    회원정보를 받아서 
   <!--  
      MemberDAOImpl.java -> memberInsert() 호출하여
     Member테이블에 추가하고 
     loginForm.jsp로 돌아감 
     -->
     <%
     	request.setCharacterEncoding("utf-8");
     %>
     <jsp:useBean id="member" class="com.member.MemberVO"/>
     <jsp:setProperty property="*" name="member"/>
     <%
     		MemberDAOImpl dao = new MemberDAOImpl();
     	    String uid = request.getParameter("uid");
     	    member.setUserid(uid);
     		dao.memberInsert(member);
     		response.sendRedirect("loginForm.jsp");
     %>

     
     
     
     