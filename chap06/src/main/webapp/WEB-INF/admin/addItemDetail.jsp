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

<h3>${question.name }</h3>

<ul>
<c:choose>
	<c:when test="${items.size() eq 0 or empty items }">
	<li>아직 항목이 없습니다</li>
	</c:when>
	<c:otherwise>
		<c:forEach items="${items }" var="item">
		<li>${item.name }[${item.win }승 ${item.lose }패
		/ 최종승리 ${item.final_win }회]</li>
		</c:forEach>
	</c:otherwise>
</c:choose>
</ul>

<hr />

<form id="addForm" action="./detail" method="POST">
	새 항목 추가: <input type="text" name="name" /> <br />
	<button id="CompleteBtn">추가하고 완성하기</button> 
	<button id="ContinueBtn">추가하고 나중에 더 만들기</button> <br />
</form>

<input id="status" name="status" type="hidden" form="addForm" value="M"/>
<input name="wid" type="hidden" form="addForm" value="${question.wid }"/>

<script src="<%=request.getContextPath()%>/resource/js/worldcup/detail.js"></script>

</body>
</html>







