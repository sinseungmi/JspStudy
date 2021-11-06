<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>helloJSP</title>
</head>
<body>

<h3>JSP (Java Server Page)</h3>

<ul>
	<li>Servlet으로 html을 입력하기 너무 불편 -> jsp 등장</li>
	<li>.jsp가 톰캣에 등록되는 과정: <br />
		JSP로 작성한 코드 -> Servlet 코드로 변환 -> 컴파일 ->
		Tomcat에 등록</li>
	<li>서블릿이 톰캣에 등록되는 과정: <br />
		Servlet -> 컴파일 -> Tomcat에 등록</li>
	<li>JSP: html 코드가 메인, JAVA코드를 특수한 영역 태그를 사용해 추가</li>
	<li>서블릿: JAVA 코드가 메인, html 코드를 문자열로 추가</li>
	<li>
		HTML코드의 양이 많은 페이지를 생성할 땐 JSP를 사용하고,
		JAVA코드의 양이 많은 페이지를 생성할 땐 서블릿을 사용하는 것이 유리하다
	</li>
</ul>

<%--JSP Script --%>
<%--
	<% %> : 모든 자바 코드를 사용할 수 있는 영역
	<%! %>: 함수를 선언할 수 있는 영역 (변수 선언도 가능) (전역변수, 함수)
	<%= %>: 원하는 값을 HTML영역에 출력 (out.print()의 간편한 버전)
	<%@ %>: 현재 서블릿에 대한 다양한 설정

 --%>
 
 <%!
 	private String createColorRedText(String text) {
	 return String.format("<div style='color:red;'>%s</div>",text);
 }
 
 	private String createBgColorRedText(String text) {
	 return String.format(
			 "<div style='background-color:red; color:white;'>%s</div>",text);
 }
 %>
 
 <%
 
 	//쓰고 싶은 자바 코드를 다 쓸 수 있는 영역(문법적으로 메서드 내부에 쓸 수 있는 것들만)
 	class Apple {} //클래스 선언 가능, 메서드 선언 불가능
 		
 	int sum = 0;
 	
  	for (int i = 0; i < 10; ++i){
  		sum += i;
  	}
  	
  	//JSP 번역 과정에서 기본적으로 반드시 생성하는 객체들이 몇 가지 있다. (JSP 내장객체)
  	// 그 중 하나가 out이다.
 	out.print(createColorRedText("Hello"));
 	out.print(createBgColorRedText("Hello"));
 %>
 
 <script>
 	let a = <%=sum %>;
 	let b = 20;
 </script>
 
 <%=createColorRedText("Hi!")%>
 <%=sum %>
 <%=createBgColorRedText("Everything") %>
 
 <h1>Hello!</h1>

</body>
</html>



























