<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL (JSP Standard Tag Library)</title>
</head>
<body>

<h3># JSTL</h3>

<ul>
	<li>JSP에서 JAVA코드를 사용하기에 너무 불편해서 나온 라이브러리</li>
	<li>JAVA의 여러가지 기능을 태그 형태로 사용할 수 있다</li>
	<li>JAVA의 모든 기능을 사용할 수 있는 것은 아니지만 유용하다</li>
	<li>JSP코드를 깔끔하게 유지할 수 있다</li>
</ul>

<h3># JSTL core</h3>
<p>자바의 주요 기능들이 구현되어 있는 커스텀 태그 라이브러리</p>

<dl>
	<dt>1. c:set</dt>
	<dd>setAttribute를 편하게 사용할 수 있다</dd>
	
	<dt>2. c:if</dt>
	<dd>if문을 편하게 사용할 수 있다. else if,else는 없다</dd>
	
	<dt>3. c:choose</dt>
	<dd>if, else if, else처럼 사용되는 조건문. c:when, c:otherwise와 함께 사용한다</dd>
	
	<dt>4. c:forEach</dt>
	<dd>숫자 또는 iterable 객체를 이용한 반복문을 간편하게 작성할 수 있다</dd>

	<dt>5. c:forTokens</dt>
	<dd>문자열을 split한 뒤 하나씩 꺼내며 반복할 수 있다. 딜리미터를 여러개 설정 할 수 있음</dd>

	<dt>6. c:redirect</dt>
	<dd>간편하게 리다이렉트 할 수 있다</dd>
	
	<dt>7. c:url</dt>
	<dd>복잡한 URL을 좀 더 편리하게 생성할 수 있다</dd>
</dl>

<hr />

<p>                    
	만들어진 URL:        /프로젝트명 이 알아서 붙는다(원래 만드는 방식보다 간편)
		<c:url value="/news/add">
			<c:param name="type" value="weather"/>
			<c:param name="reporter" value="waitingPark"/>
		</c:url>
	<hr />   //엔터하면 띄어쓰기돼서 가로로 늘려쓰는 불편함이 있다
	원래 URL만드는 방식: <%=request.getContextPath() %>/news/add?type=<%="weather"%>&reporter=<%="waitingPark"%>;
</p>

<%-- 
<c:if> 태그에 사용될 수 있는 속성은 다음 세 가지 입니다.

- test : 필수 속성으로 속성값으로 EL 비교식을 가집니다.

- var : 조건 결과를 저장할 변수를 지정합니다.

- scope : 조건 결과를 저장할 변수의 저장 scope을 지정합니다.

--%>

<%-- 
<c:if test="${not empty login }">
	<c:redirect url="http://naver.com/"/>
</c:if>
--%>

<c:forTokens var="animal" items="cow,chicken,dog,cat/monkey/horse" delims="/,">
	<div>${animal }</div>
</c:forTokens>

<%
	java.util.ArrayList<String> list = new java.util.ArrayList<>();

	list.add("철수");
	list.add("민수");
	list.add("민식");
	list.add("철수");
	list.add("민수");
	list.add("민식");
	list.add("철수");
	list.add("민수");
	list.add("민식");
	
	pageContext.setAttribute("list", list);

%>
<%-- 
	<c:foreach items="${리스트가 받아올 배열이름}"
           var="for문 내부에서 사용할 변수"
           varStatus="상태용 변수">

	varStatus.first: 첫 번째 반복일 때 true
	varStatus.last: 마지막 반복일 때 true
	varStatus.index: 몇 번째 반복인지 알 수 있음(0 base)(0부터 셈)
	varStatus.count: 몇 개째인지 알 수 있음 (1 base)(1부터 셈)
	varStatus.begin: 몇 부터 시작했는지 알 수 있음
	varStatus.end: 언제 끝나는지 알 수 있음
--%>
<c:forEach items="${list }" var="item" varStatus="status">
	${status.count }. ${item },  
</c:forEach>

<div class="container">
<c:forEach var="i" begin="0" end="10" varStatus="status">
	<div>[이 반복문은 ${status.begin }부터 시작되어 ${status.end }에서 끝납니다.]</div>
	<div>${i }</div>
</c:forEach>
</div>
<%
	//request.setAttribute("fruit", "apple");
%>

<!-- scope=[page|request|session|application] -->
<c:set var="fruit" value="pineapple" scope="application"/>
<p>${fruit }</p>
<c:set var="fruit" value="apple"/>
<p>${fruit }</p>
<c:set var="fruit" value="banana"/>
<p>${fruit }</p>

<c:if test="${fruit eq 'banana' }">
	<p>c:if문에 의해 나타날 문장</p>
</c:if>

<c:set var="color" value="blue"/>
<c:choose>
	<c:when test="${empty color }">
		<p>color 어트리뷰트가 비어있습니다.</p>
	</c:when>
	<c:when test="${color == 'red' }">
		<p>color가 빨간색입니다.</p>
	</c:when>
	<c:otherwise>
		<p style="color: ${color };">빨간색 이외의 색상입니다.</p>
	</c:otherwise>
</c:choose>

</body>
</html>

















