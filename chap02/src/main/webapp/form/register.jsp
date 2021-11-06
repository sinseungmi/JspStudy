<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%!
	private String getTimeLabel(String time) {
		if (time == null) {
			return "시간이 널값";
		}
		
		switch (time) {
		case "am":
			return "오전 희망";
		case "pm":
			return "오후 희망";
		case "other":
			return "그 외 시간";
		case "any":
			return "아무때나 필요한 시간";
		default:
			return "버그임";
		}
	}

%>
    
<%
   //우리가 어떤 .jsp파일 또는 .html파일에서 폼 태그에 입력한 값을 전송한다고 가정할때
   //폼 태그에서 입력한 값을 전송할 때는 get,post방식으로 나뉜다. post방식으로 보내는 값이
   //한글일 경우 깨지지않게 전달하기 위해 request.setCharacterEncoding("")을 사용한다.
   //get방식으로 보내진 한글은 톰캣이 기본적으로 utf-8문자 코드가 적용되어 있어서 자동으로
   //한글 처리를 해주기 때문에 한글이 깨지지않는다.
	request.setCharacterEncoding("EUC-KR");

	String firstName = request.getParameter("first-name");
	String lastName = request.getParameter("last-name");
	String time = request.getParameter("time");
	String intrests = request.getParameter("intrests");
%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="EUC-KR">
<title>전송받은 내용 등록 결과</title>
</head>
<body>

	FirstName : <%=firstName != null ? firstName : "없음" %> <br>
	LastName : <%=lastName != null ? lastName : "없음" %> <br>
	희망시간 : <%=getTimeLabel(time) %>
	

</body>
</html>