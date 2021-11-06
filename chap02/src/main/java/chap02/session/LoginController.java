package chap02.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/logincontroller"})
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		Object id = session.getAttribute("id");
//		Object pw = session.getAttribute("pw");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println(id);
		System.out.println(pw);
		
		resp.getWriter()
		.append("Username:" +  id)
		.append(" " + pw);
	}

}




















