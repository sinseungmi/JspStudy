package chap06.admin.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.DBConnector;
import chap06.dao.WorldcupDAO;

@WebServlet(urlPatterns = {"/admin/addQuestion"})
public class AddQuestion extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/admin/addQuestion.jsp")
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String question = req.getParameter("question");
		//question을 DB에 등록해야함
		System.out.println("등록할 질문: " + question);
		
		try (
				Connection conn = DBConnector.getConnection();				
			){
			WorldcupDAO dao = new WorldcupDAO(conn);
			dao.addQuestion(question);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath() + "/home");
		
		
	}
	
}









