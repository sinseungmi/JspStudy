<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap02.hash.MyHashing" %> <%--JSP Import --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3># login.jsp</h3>

<ol>
	<li>DB에 회원 정보를 저장할 수 있는 테이블을 하나 생성한다.(ID,PASSWORD,EMAIL)(인설트로 넣기)</li>
	<li>비밀번호는 해시값으로 저장해야한다.(sha256)</li>
	<li>사용자는 지금 이 페이지에서 아이디와 비밀번호를 입력한다</li>
	<li>컨트롤러에서 DB에서 꺼내온 아이디/비밀번호와 사용자가 입력한 아이디/비밀번호를 대조하여
		세션에 로그인에 성공 여부를 저장한다.
	</li>
	<li>로그인 된 상태로 현재 페이지를 보면 로그인 폼은 사라지고, 
		회원 정보와 로그아웃 버튼이 보여야한다.</li>
	<li>로그아웃 기능도 구현해야한다.</li>
</ol>

<hr />

<h3># 자바로 만든 클래스를 .jsp에서 자유롭게 가져다 사용할 수 있다</h3>

<%=MyHashing.hash("12345") %>

<h3># Dynamic Web Project에 외부 라이브러리를 사용하기 위해서는
	WEB-INF/lib 폴더에 .jar 등을 넣어줘야한다</h3>

<form action="/chap02/logincontroller" method="post">
	id : <input type="text" name="id"/> 
	pw : <input type="password" name="password" />
	<input type="submit" value="로그인"/>
</form>


</body>
</html>













