<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%  
	//객체를 별도로 생성하지 않아도 jsp에서 바로 사용할 수 있는 객체
	//request, response, out, page, config, application, 
	//pageContext, exception, session
                     //이변수 이름은 바꿀 수 없음.
	String pageNum = request.getParameter("page");

	request.getRequestDispatcher(
			String.format("../view/page%s.jsp", pageNum))
			.forward(request, response);

%>    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    