package chap02.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chap02.model.Apple;

//http://localhost:8080/프로젝트명/@WebServlet어노테이션명 
//(@WebServlet에 프로젝트명이 안들어가는 이유)
@WebServlet("/fruit/controller")
public class FruitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String fruit = req.getParameter("fruit");
			
			System.out.println("클라이언트가 클릭한 과일 : " + fruit);
			
			// 해당 과일 이름의 파일의 내용을 읽어서 sysout으로 출력해보세요.
			String path = String.format("D:\\마이크로서비스 과정\\JAVA\\jsp-workspace\\chap02\\files\\%s.txt", fruit);
			
			File f = new File(path);
			StringBuilder detail = new StringBuilder();
			
			try (
//				FileInputStream fin = new FileInputStream(f);
//				InputStreamReader iin = new InputStreamReader(fin, "EUC-KR");		
				FileReader fin = new FileReader(f, Charset.forName("EUC-KR"));
				BufferedReader in = new BufferedReader(fin);	
			){
				String line;
				while ((line = in.readLine()) != null) {
					detail.append(line);
				}
				//System.out.println(fruit + "의 상세정보:\n" + detail);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//리퀘스트 객체의 어트리뷰트에 원하는 데이터를 실어놓을 수 있다.
			//리퀘스트에 실려있는 어트리뷰트는 포워드하는 페이지로 그대로 전달된다.
			//어트리뷰트는 완성된 것만(여기서 계산 노우) ,계산은 자바스크립트에서!
			req.setAttribute("fruitName", fruit);
			req.setAttribute("fruitDetail", detail);
			
			
			//파라미터는 랜선(url,html 요청으로 온다)으로 오기 때문에 문자열로 밖에 받을 수 밖에 없다
			//어트리뷰트는 나의 서블릿에서 다른 서블릿으로 보내는거기 때문에 여러 타입으로 가능
			
			
			//어트리뷰트에는 자바의 모든 타입들을 실어 보낼 수 있다.
			req.setAttribute("apple1", new Apple());
			req.setAttribute("apple2", new Apple());
			req.setAttribute("apple3", new Apple());
			req.setAttribute("appleArray", 
					new Apple[] {new Apple(), new Apple(), new Apple(), new Apple()});
			
			// 포워드된 jsp 페이지에서는 주로 화면을 구성한다
			req.getRequestDispatcher("/attribute/view/fruitDetail.jsp")
				.forward(req, resp);
			
			System.out.println("존재함? " + f.exists());
			System.out.println("실제 위치 어디? " + f.getAbsolutePath());
			
			
			//리다이렉트는 새로운 리쿼스트를 주기때문에 어트리뷰트가 없어짐 리다이렉트는 어트리뷰트를 유지시키지 못함.
			//그래서 어트리뷰트를 유지시켜주고 싶다면 포워드를 사용할 것
			//resp.sendRedirect("/chap02/attribute/fruitSelector.jsp");
		}
}










