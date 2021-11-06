package chap07.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward/main") //이건 매핑(원래는 실제 경로를 입력해야하지만 매핑으로 그런 수고를 덜 수 있다)
public class ForwardServle extends HttpServlet{
	//요청한다는 것은 클라이언트가 웹 서버에게 웹 페이지를 달라고 하는 것도 된다!
	// /forward/main 이 주소를 검색창에 치면 서블릿으로 들어오고, 실제로 가는 주소는 
	// /WEB-INF/forward/main.jsp 이게 된다! .xml 서블릿 버전!
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// 서블릿을 거쳐서 jsp로 가는게 좋다
		req.getRequestDispatcher("/WEB-INF/forward/main.jsp").forward(req, resp);
		
	}
	/*
	 * jsp가 WEB-INF안에 있다면 그 경로를 인터넷에 쳐도 나오지 않음.(Ctrl + F11도 마찬가지)
	 * 그래서 xml 매핑 또는 
	 * 서블릿(어노테이션 주소) -> req.getRequestDispatcher("url").forward(req, resp) -> jsp 
	 * 이렇게 넘어간다
	 * 
	 * */
}
