<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%



request.setCharacterEncoding("utf-8");
String userid= request.getParameter("userid");
MemberDAOImpl dao = new MemberDAOImpl();
dao.memberDelete(userid);
session.invalidate();
response.sendRedirect("loginForm.jsp");
    
 %>