<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
  //세션아이디를 키값으로 써서 밸류를 꺼낸다(session : 세션아이디로 가져오는 인스턴스) session도 내장 객체
  //세션이 많이 누적되면 서버가 뻗을 수 있다. 만료된 세션은 삭제해야한다
	
	//세션을 바로 만료시킨다.(로그아웃 같은 거)
	session.invalidate();
	response.sendRedirect("/chap02/scope/scope.jsp");
%>