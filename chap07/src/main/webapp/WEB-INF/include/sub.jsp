<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

//여긴 서블릿! 서블릿을 이렇게 이용 가능!

%>                       <%--IncludeServlet1에서부터 req,resp을 들고 main.jsp로 이동하고
                         이쪽으로 이동했기 때문에 req의 담긴 값을 쓸 수 있다! ${}은 어트리뷰트를 편하게 쓰기 위한 el이다
                         request.getAttribute("myNumber") 대신! 참고로 request는 jsp의 내장 객체 --%>
<c:forEach begin="1" end="${myNumber }" var="i">
	<div id="div${i }">${i }</div>
</c:forEach>