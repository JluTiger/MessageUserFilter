<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	session.setAttribute("loginUser", username);
	response.sendRedirect(request.getContextPath()+"/message.jsp");


%>