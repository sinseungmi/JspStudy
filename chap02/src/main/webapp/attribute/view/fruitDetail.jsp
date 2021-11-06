<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>'<%=request.getAttribute("fruitName") %>'의 상세정보 페이지</title>
</head>
<body>

<h1><%=request.getAttribute("fruitName") %></h1>

<p><%=request.getAttribute("fruitDetail") %></p>

<hr />

<table border="1">
	<tr>
		<th>PRICE</th>
		<th>SIZE</th>
	</tr>
	<%=request.getAttribute("apple1") %>
	<%=request.getAttribute("apple2") %>
	<%=request.getAttribute("apple3") %>
	<%
		Object[] apples = (Object[])request.getAttribute("appleArray");
		
		for (int i = 0; i < apples.length; i++){
			out.print(apples[i]);
		}
	%>
</table>

<hr />

<h3># Attribute에 들어있는 값들을 쉽게 꺼내 쓰는 방법(EL, Expression Language)</h3>
<h5>Java Bean component에 저장된 데이터 접근 가능성, request, application, session 같은 다른 객체를 간소화 한 것</h5> 

<ul>
	<li>Attribute에 들어있는 오브젝트를 쉽게 꺼내 쓸 수 있다</li>
	<li>JSP를 서블릿으로 변환하는 과정에서 
	  해당 클래스의 toString()을 호출하여 html페이지에 출력한다</li>
	<li>EL을 통해 인스턴스의 필드값에 접근하면 해당 필드의 getter를 자동으로 호출한다</li>
	<li>.찍고 접근한 필드가 getter가 없는 필드라면 에러가 발생한다</li>
</ul>

<p>
	Attribute에 들어있는 값이 인스턴스인 경우 
	.찍고 필드명을 쓰면 해당 필드의 getter를 자동으로 호출한다
</p>

<ul>
	<li>${fruitName }</li>
	<li>${fruitDetail }</li>
	<li>${apple1.price }</li>
	<li>${apple1.size }</li> <!--해당 객체의 투스트링을 가져다 쓴다.
	     퍼블릭이여서도 그냥 변수는 못가져옴. 게터로 무조건 설정해서 가져와야함.
	     apple1.price 이렇게 생긴 애들은 사실 게터를 부르는 것
	     -->
</ul>

</body>
</html>












