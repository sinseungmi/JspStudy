<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Main Page</title>
<style>
	.container {
		display: grid;
		grid-template-columns:1fr 2fr 1fr;
	}
	
	.container > * {
		background-color: black;
		margin: 5px;
		color: white;
		padding: 50px;
	}
	
</style>
</head>
<body>

jsp페이지에서 페이지 분할이 가능하다. include는 내용을 갖다 붙인다 생각해도 됨

<h3># include도 jsp페이지에서 쓸 수 있다</h3>

<p>포워드는 서블릿에서 사용하는 것이 용도에 맞고 
include는 jsp에서 사용하는 것이 용도에 맞다</p>

<p> req, resp이 갔다가 끝내는 건 forward 이고 
갔다가 돌아오는 건 include</p>
인클루드는 req, resp을 데리고 지정한 주소로 갔다가 일로 다시 온다
	
<div class="container">
	<jsp:include page="./sub.jsp"/>
</div>

<hr />

<footer>
	<jsp:include page="./footer.jsp"/>
</footer>

</body>
</html>







