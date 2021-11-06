package chap07.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/include/main")
public class IncludeServlet1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//여기서 리퀘스트의 어트리뷰트를 설정하고 그 리퀘스트를 가지고 다른 주소로 이동한다!
		req.setAttribute("myNumber", 16);
		
		req.getRequestDispatcher("/WEB-INF/include/main.jsp").forward(req, resp);
		
	}

}
