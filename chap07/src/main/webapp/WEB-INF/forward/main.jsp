<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main JSP page</title>
</head>
<body>

<h3># .jsp 파일은 서블릿과 같다</h3>

<p>근데 왜 forward는 서블릿에서만 하지?</p>

<%--
# 이전 내용이 실행되지 않는 이유
<jsp:forward>를  실행하기 이전에 출력 버퍼에 저장됐던 내용은 웹 브라우저에 전송되지 않습니다.
출력 버퍼를 비우고 새로운 내용을 버퍼에 삽입하기 때문에!
또한 <jsp:forward>액션 태그 뒤에 위치한 코드는 실행 조차 되지 않습니다.

그리고 jsp:forward는 jsp가 기존에 가지고 있는 태그임. 외부 라이브러리 안가져와도 됨! 헷갈리지마셈​

 --%>
<jsp:forward page="./sub.jsp"/>

<p>나도 실행 안돼? 응 안돼. 당연하지 포워드는 설정한 주소로 이동하면 돌아오지 않잖음</p>

</body>
</html>