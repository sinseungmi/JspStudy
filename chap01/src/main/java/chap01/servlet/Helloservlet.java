package chap01.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * # 웹 사이트가 클라이언트에게 보여지는 과정 (JSP)
 * 
 * 호스트 : 웹 페이지를 가지고 있는 웹 페이지의 주인
 * 클라이언트 : 웹 서버에 접속하는 사용자
 * 
 * (1) 클라이언트가 호스트에게 웹 페이지를 보여달라고 요청한다.
 *		요청할 때 원하는 페이지가 무엇인지 웹 주소(URL)에 적어서 보낸다.
 * 
 * 		http://naver.com/news
 * 
 * 		htt:// - 통식 방식 (http, https, ftp ...)
 * 		naver.com - 웹 서버 컴퓨터의 IP주소 (또는 도메인)
 * 		/news - 사용자가 해당 웹 서버에서 특별히 원하는 자원(웹페이지 또는 그림 등...)
 * 
 * (2) 사용자 요청이 Apache - Tomcat에 도착한다
 * 		Apache - Tomcat에 등록되어 있는 URL 매핑들 중 일치하는 자원을 찾는다
 * 		
 * 		등록할 수 있는 자원들 - .jsp, .java(Servlet), .html, 
 * 							기타 자원들(.js, .css, .jpg..)
 * 
 * 		등록 방법들 - @WebServlet 어노테이션, webapp(WebContent) 밑에 직접 넣기..등
 * 
 * (3) 등록된 자원들 중 사용자의 요청에 따라 다른 결과들이 나오는 페이지를 동적 웹 페이지라고한다
 * 
 * (4) 클라이언트의 요청이 올바른 요청이었다면 (톰캣에 등록된 자원이 맞다면)
 * 		해당 자원을 만들어서(servlet 프로그램 실행) 응답한다. 
 * 		(또는 이미 있는 자원을 그대로 응답한다, 동적 웹 페이지가 아닌 자원들)
 * 
 * (5) 웹 서버에서 응답한 자원이 요청 보냈던 클라이언트의 웹 브라우저에 도착한다
 * 		웹 브라우저는 응답 받은 내용을 해석하여 사용자에게 보여준다.
 * */

/*
 * HttpServlet 클래스에서 사용자 요청을 처리하는 doGet/doPost 메서드는 모두 
 * HttpServletRequest와 HttpServletResponse 객체를 매개변수로 가지고 있다.
 * HttpServletRequest와 HttpServletResponse 객체는 서블릿과 클라이언트 사이를 연결해주는 중요한 객체들 이다.
 * 
 * */


// 이 서블릿으로 접속하려면 어떤 URL로 접속해야하는지 설정하는 어노테이션 (/chap01/hello)
@WebServlet("/hello")
public class Helloservlet extends HttpServlet {
   //요청이 들어오면 응답을 생성하는게 서블릿
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      // HttpServletRequest : 사용자가 보낸 모든 요청 정보를 담을 수 있는 클래스
      // HttpServletResponse: 받은 요청을 통해 알맞은 응답을 담아놓을 수 있는 클래스
      
	  /*
	   * 응답 스트림에 텍스트를 기록하는 것도 가능하며, 이 작업을 하기 위해서 response.getWriter()를 호출해야 합니다.
	   * 스트림에는 바이너리 기반의 스트림과 텍스트 기반의 스트림이 있습니다.
	   * 보통 바이너리 기반의 스트림은 InputStream(입력), OutputStrream(출력)이라는 것으로 끝나고,
	   * 텍스트 기반의 스트림은 reader(입력), Writer(출력)로 끝납니다.
	   * 
	   * 
	   * 매핑(mapping)이란?
	   * : Url경로가 너무 길고, 보안에 노출되어 있는데, 이러한 경로를 간단하게 표현하는 것 입니다.
	   * 
	   * 
	   * * 어노테이션 : @ 와 함께 쓰인 것을 어노테이션이라고 합니다.
	   * @WebServlet("/맵핑명")과 같이 java코드에 직접 입력하여 맵핑할 수 있습니다.
	   * 
	   * 
	   * 톰캣은 어노테이션을 확인하여 "해당 Servlet으로 접근하기 위해서는 URL에 /hello로 접근하면 된다"
	   * 는 매핑을 합니다
	   * 
	   * */ 
	   
	   
	  //resp객체에 쓴다
      PrintWriter out = resp.getWriter();
      
      out.println("<html><head><title>Hello</title></head><body>");
      out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\r\n"
            + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css\">");
      out.println("<h1>Hello!</h1>");
      out.println("<table class=\"table table-hover\">\r\n"
            + "        <!-- On rows -->\r\n"
            + "        <tr class=\"active\">\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "        </tr>\r\n"
            + "        <tr class=\"success\">\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "        </tr>\r\n"
            + "        <tr class=\"warning\">\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "        </tr>\r\n"
            + "        <tr class=\"danger\">\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "        </tr>\r\n"
            + "        <tr class=\"info\">\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "            <td>table content</td>\r\n"
            + "        </tr>\r\n"
            + "    </table>");
      out.println("</body></html>");
   }

}



