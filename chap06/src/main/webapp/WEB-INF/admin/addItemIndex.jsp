<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>현재 질문 목록</h3>

<ul>
	<c:forEach items="${questions }" var="question">
		<li>
			<c:url value="/admin/addItem/detail" var="link">
				<c:param name="wid" value="${question.wid }"/>
			</c:url>
			<a href="${link }">
				${question.name } [${question.status eq 'M'? '미완성' : '완성'}]
			</a>
		</li>	
	</c:forEach>
</ul>

</body>
</html>











