package chap03.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/language/kr")
public class HanguelController extends HttpServlet{
	//인코드와 디코드를 같은 타입으로! 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get방식 요청은 URL뒤에 추가되어서 도착한다.
		//그 곳에 실려온 데이터의 인코딩은 웹서버(톰캣)가 담당한다
		//톰캣은 기본 값으로 인코딩 타입이 UTF-8이 지정.
		
		//req.setCharacterEncoding("UTF-8"); 
		//server.xml의 Connector의 URIEcoding 속성을 통해서
		//GET방식 인코딩 타입을 변경할 수 있다
		System.out.println(req.getParameter("msg"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post방식의 요청은 요청 객체 내부에 실려서 도착한다.
		
		req.setCharacterEncoding("EUC-KR"); //바이트를 꺼내면서 합쳐줌
		System.out.println(req.getParameter("msg"));
	}
	
}
