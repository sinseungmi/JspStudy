<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>자바빈</title>
</head>
<body>

<h3># 자바빈 객체 (JavaBean Object)</h3>
<ul>
	<li>JSP에서 데이터를 편리하게 주고받기 위한 클래스의 표준 형식</li>
	<li>자바빈 표준에 맞춰 정의한 클래스는 JSP에서 편리하게 사용할 수 있다</li>
</ul>

<h3># 자바빈 객체의 규칙</h3>
<ol>
	<li>반드시 public class여야 한다</li>
	<li>기본 생성자가 반드시 존재해야 한다</li>
	<li>필드의 접근 제어자가 private이어야 한다</li>
	<li>필드에는 반드시 getter/setter를 통해 접근해야한다</li>
</ol>

<h3># 연습문제</h3>
<ol>
	<li>현재 페이지의 아래에 학생의 이름과 점수를 입력하는 폼을 생성한다</li>
	<li>이름과 점수와 함께 서버에 요청을 보내면 성적표 페이지를 응답 받는다</li>
	<li>성적표에는 이름/점수/평균/등수가 적혀있다</li>
	<li>Student 클래스에 메서드와 필드는 자유롭게 추가할 수 있다</li>
	<li>원래는 DB를 활용해야 하지만 이번엔 활용하지 말고 풀어보세요</li>
</ol>

<form id="student-form" action="/chap03/student/add" method="POST">
<ul type="none">
	<li>이름 : <input type="text" name="name"></li>
	<li>국어 : <input type="number" name="kor"></li>
	<li>영어 : <input type="number" name="eng"></li>
	<li>수학 : <input type="number" name="math"></li>
	<li><input style="width:150px;" type="submit" value="등록"/></li>
</ul>
</form>

<form id="student-form2" action="/chap03/javabean/userBeanController.jsp" method="POST">
<ul type="none">
	<li>이름 : <input type="text" name="name"></li>
	<li>국어 : <input type="number" name="kor"></li>
	<li>영어 : <input type="number" name="eng"></li>
	<li>수학 : <input type="number" name="math"></li>
	<li><input style="width:150px;" type="submit" value="등록"/></li>
</ul>
</form>

</body>
</html>








