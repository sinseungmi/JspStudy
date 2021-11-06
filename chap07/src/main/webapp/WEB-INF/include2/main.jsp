<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	디렉티브 태그? <%@ %>
	: JSP 페이지를 어떻게 처리할 것인지를 설정하는 태그
 --%>
<%-- <jsp:include page="./header.jsp"/> --%>
<%-- 인클루드 디렉티브 방법 --%>
<%@ include file="./tags.jspf" %>
<%@ include file="./a.jspf" %>

<%
	System.out.println(a);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include2 Main Page</title>
<%@ include file="./header.jspf" %> <%--head에도 script가 들어갈 수 있음 --%>
</head>
<body>
   
<%=a %>

<c:url value="/abc"/>

<h3># jsp include와 include directive의 차이점</h3>

<ul>
   <li>jsp include는 req, resp를 전달하고 그곳에서 완성된 응답만을 포함한다</li>
   <li>include directive는 요청을 받기 전에 소스 파일을 가져와서 합쳐놓는다</li>
</ul>
<%@ include file="./sub.jsp" %>

</body>
</html>





