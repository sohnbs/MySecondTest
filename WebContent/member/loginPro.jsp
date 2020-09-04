<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
   String userid= request.getParameter("userid");
   String pwd = request.getParameter("pwd");
   MemberDAOImpl dao = new MemberDAOImpl();
   int flag = dao.loginCheck(userid, pwd);
   if(flag == 0 || flag == 1){ //0은 일반회원, 1은 관리자
	   session.setAttribute("userid", userid); 
	   
   }
    out.println(flag);
    
 %>
