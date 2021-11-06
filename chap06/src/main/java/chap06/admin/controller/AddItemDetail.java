package chap06.admin.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.DBConnector;
import chap06.dao.WorldcupDAO;

public class AddItemDetail extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int wid = Integer.parseInt(req.getParameter("wid"));

		try (
				Connection conn = DBConnector.getConnection();				
			){
			
			WorldcupDAO dao = new WorldcupDAO(conn);
			
			req.setAttribute("question", dao.getWorldcup(wid));
			req.setAttribute("items", dao.getWorldcupItemList(wid));
			
			req.getRequestDispatcher("/WEB-INF/admin/addItemDetail.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String wid = req.getParameter("wid");
		
		System.out.println("status: " + req.getParameter("status"));
		System.out.println("item-name: " + req.getParameter("name"));
		
		resp.sendRedirect(req.getContextPath() + "/admin/addItem/detail?wid=" + wid);
	}

}









