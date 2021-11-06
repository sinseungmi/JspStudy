package chap02.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/controller2")
public class PageNumController2 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page");
		
		/*
		 *  # 리다이렉트
		 *  - 이곳(서블릿 or JSP)으로 요청한 사용자에게 다른 곳으로 다시 요청할 것을 명령한다
		 *  - 사용자 웹 브라우저에서 다시 요청 보내야할 URL을 사용해야한다
		 *  - 리다이렉트는 웹 서버가 웹 브라우저에게 다른 페이지로 이동하라고 응답하는 기능이다.
		 *  - 리다이렉트가 페이지를 이동시키는 코드지만 밑에 다른 소스코드들도 무시되는게 아니라 실행된다.
		 * 
		 * */
		resp.sendRedirect(String.format("/chap02/forward/view/page%s.jsp", page));
		
		System.out.println("완료!");
		
	}

}






























