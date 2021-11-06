package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * .jsp -> 번역 -> .java(Servlet) -> compile -> 
 * 		.class(바이트 코드,자바 가상 머신이 실행할 수 있는 형태) 상태로 tomcat에 적재됨 
 * 
 * */

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet{
	
	// <%!
	
	
	// %>
	
	@Override
	public void init() throws ServletException {
		//<%@ %>는 초기화 자리에 있다
	}
	
	

	// /chap01/gugudan으로 접속한 사용자에게 멋있는 
	//구구단 테이블을 응답하는 서블릿을 만들어 보세요
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//<%@ %>  request, page, out..
		// <%
		PrintWriter out =  resp.getWriter();
		
		 for (int i = 2; i <= 9; i++){
			 out.print("<div>");
	            for (int j = 1; j <= 9; j++){
	            	out.print(String.format("%d X %d = %d <br>",i ,j ,i*j));
	            }
	         out.print("</div> <br>");
	     }
		 
		 //=======================================================
		 
		 out.print("<style>tr * {padding:10px} </style>");
		 
		 out.print("<table border='1'>");
		 for (int dan = 2; dan <= 9; dan++){
			 out.printf("<tr><th>%dDan</th>", dan);
	            for (int gop = 1; gop <= 9; gop++){
	            	out.printf("<td>%d X %d = %d</td>", dan, gop, dan * gop);
	            }
	         out.print("</tr>");
	     }
		 out.print("</table>");
		 // %>
	}

}











