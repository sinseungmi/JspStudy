<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
    //세션 아이디는 그대로 유지하고 어트리뷰트만 삭제
	session.removeAttribute("choice");
	//session.setAttribute("choice", null);
	response.sendRedirect("/chap02/scope/scope.jsp");

%>