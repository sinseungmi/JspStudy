package chap06.main.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.DBConnector;
import chap06.dao.WorldcupDAO;

public class MainPage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//SELECT count(*) FROM worldcup; 할 예정
		//url하나에 커넥션 하나 발생하는게 일반적
		try (
				Connection conn = DBConnector.getConnection();
			){
			
			//조회 유형에 따라 메서드가 하나씩 생김
			WorldcupDAO dao = new WorldcupDAO(conn);
			req.setAttribute("q_count", dao.getCount());
			req.setAttribute("q_count2", dao.getNotYetCount());
			req.setAttribute("items", dao.getAllItemList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/index/index.jsp").forward(req, resp);
	}
}
