<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> <!-- pageEncoding 사실상 아무의미 없음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR"> <!-- html을 해석할 때 쓸 수도 있고 안쓸 수도 있다 -->
<title>한글 보내는 페이지</title>
</head>
<body>
	<h3># JSP의 여러가지 charset 설정</h3>
	<dd>
		<dt>1. meta 태그의 charset 설정:</dt>
		<dd>클라이언트의 웹 브우저가 페이지를 해석할 때 사용할 charset을 설정한다</dd>
		
		<dt>2. pageEncoding의 charset 설정:</dt>
		<dd>이 JSP 코드들을 서블릿으로 변환할 때 사용할 charset을 의미한다</dd>
		
		<dt>3. contentType의 charset 설정:</dt>
		<dd>서블릿으로 생성된 결과물(응답)의 종류 및 인코딩 타입을 설정한다</dd>
	</dd>

	<h3># 한글 전송해보기 페이지</h3>

	<h5># GET 방식</h5>
	<form action="/chap03/language/kr" method="GET">
		<input type="hidden" name="msg"value='안녕하세요'/>
		<input type="submit" value="'안녕하세요' 보내기"/>
	</form>
	
	<h5># POST 방식</h5>
	<form action="/chap03/language/kr" method="POST">
		<input type="hidden" name="msg"  value='안녕하세요'/>
		<input type="submit" value="'안녕하세요' 보내기"/>
	</form>

</body>
</html>














