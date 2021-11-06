<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 서버 기초</title>
</head>
<body>

   <h3># 루프백(loopback) 주소</h3>
   
   <ul>
      <li>127.0.0.1 : 자기 자신을 가리키는 IP주소</li>
      <li>localhost : 공유기까지 가지도 않고 그냥 자기 자신의 컴퓨터로 접속</li>
   </ul>

   <h3># HTTP URL의 구조</h3>
   
   <p>프로토콜://IP주소:포트번호/원하는 자원의 경로</p>
   <ul>
      <li>
         <p><a href="http://localhost:8080/chap01/00_basic/index.jsp">접속하기</a></p>
      </li>
      <li>8080은 톰캣이 기본적으로 사용하는 포트번호이다.</li>
      <li>
         https://www.naver.com/ <br>
         프로토콜: https <br>
         IP주소: www.naver.com (도메인으로 대체) <br>
         포트번호: http의 기본 포트번호는 80, https는 443 <br>
         원하는 자원의 경로: / (기본 자원)
      </li>
   </ul>
   
   <h3># Domain Name Service (DNS)</h3>
   <ul>
      <li> 
         URL에서 IP주소가 입력되어야 하는 자리에 IP주소 대신
         다른 영어로 된 문자가 들어있다면 바로 해당 서버를 찾아가는 것이 아니라 DNS서버에 들러 IP주소를 받은 뒤 
         찾아가게 된다.
      </li>
      <li>
         우리 IP주소는 DNS서버에 등록 되어있지 않기 때문에 아직은 도메인 이름을 사용할 수 없다
      </li>
      <li>공짜로 도메인 이름을 등록할 수 있는 서비스들도 많이 있다</li>
   </ul>
   
   <h3># 웹 서버</h3>
   
   <ul>
      <li>24시간 대기하고 있다가 사용자가 접속하면 사용자가 원하는 웹 페이지를 응답(response)해주는 프로그램</li>
      <li>사용자가 어떤 웹 페이지를 원하는지는 사용자가 요청(request)하는 URL을 통해 구분한다</li>
      
   </ul>


	<h3># Dynamic Web Project</h3>
	<ul>
		<li>java, src/main/java, Java Resources <br />
		     - 자바 코드를 작성하는 폴더</li>
		<li>webapp 또는 WebContent <br />
		     - 웹 서버에 등록될 자원들을 보관하는 폴더 <br />
		     - 기본적으로 웹서버는 접속하는 사용자에게 이곳에 등록된 
		     .html, .jsp등을 응답해준다 <br />
		</li>
	</ul>


</body>
</html>
