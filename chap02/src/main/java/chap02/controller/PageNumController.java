package chap02.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 * jsp(응답)은 예쁘게 꾸민다
 * 서블릿은 자바코드
 * 
 * */



@WebServlet(urlPatterns = {"/page/controller"})
public class PageNumController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		
		System.out.printf("전달 받은 페이지는 %s페이지 입니다.\n", page);
		
		//전달 받은 값에 따라서 다른 내용을 응답해줘야 하는 경우
		//서블릿만 사용하면 코드가 매우 지저분해진다
		
		//forward는 가서 끝나는거, include는 갔다 다시 돌아오는거
		
		//이 때, 다른 .jsp 페이지로 request를 그대로 전달하여 전달한 .jsp에서 응답을 생성하는 것을
		//forward라고 한다.
		
		//getRequestDispatcher()가 실행되는 순간 지정된 페이지를 읽어들여서 리다이렉트(다시보낸다) 시킨다. 
		//서버단에서 모든 작업이 이루어진다. getRequestDispatcher() 
		//이후 코드는 실행되지 않고 무시된다. request, response 를 리다이렉트 시키는 페이지에 전달해서 사용할 수 있다.
		
		/*
		 * request.getRequestDispatcher()메서드의 인자 값으로 이동할 페이지의 경로를 지정.
		 * forward()메서드는 페이지를 이동시키는 메서드. 이동하면서 현재페이지에서 사용하던
		 * request, response객체를 인자값으로 전달.
		 * 
		 * */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(  
						String.format("/forward/view/page%s.jsp", page));
		
		//dispatcher.forward(request, response);
		
		//include는 다른 .jsp 페이지로 request를 보낸 후 생성된 결과를 이 서블릿으로 다시 가져온다.
		/*
		 * 말 그대로 중간에 포함한다는 의미이다. response의 output stream에 데이터를 쓰는
		 * 중간에 include 구문을 만나면 해당 스트림을 그대로 유지한 채 include되는 url의 데이터를 
		 * 그 뒤에 이어 쓴다. include문 종료 후에도 해당 스트림을 그대로 유지하여 데이터를 
		 * 이어 쓸 수 있다.
		 * */
		response.setCharacterEncoding("EUC-KR");
		dispatcher.include(request, response);
		
		//이어서 응답을 만들어 나갈 수 있다.
		response.getWriter().append("<h3>서블릿에서 추가됨. by PageNumController</h3>");
		//response.getWriter()는 바디에 추가된다.
	}

}

















