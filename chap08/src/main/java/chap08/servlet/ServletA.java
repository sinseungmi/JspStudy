package chap08.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletA extends HttpServlet{
   
   String name;
   String tel;
   String user;
   String charSet;
   
   /*
    * # 웹 컨테이너
    * 
    *  웹 컨테이너란 웹 서버의 내부에서 서블릿 클래스 또는 JSP 파일을 실행하기 위한 실행 환경을 
    *  제공하는 역할을 하며 특히 서블릿 클래스에 대한 웹 컨테이너를 서블릿 컨테이너, 
    *  JSP 파일에 대한 웹 컨테이너를 JSP 컨테이너라고 한다. 
    * 
    * 
    * # DD
    * 
    *  DD(Deployment Descriptor : 배포서술자)는 WEB-INF폴더 아래 web.xml이라는 파일명으로 
    *  항상 존재해야 하며 서버 시작시 메모리에 로딩된다. 
    * 
    * 
    * # 서블릿 생성자에서는 getSetvletConfig()메서드를 호출할수 없다. init()메서드가 호출되고 
    *   난 후에야 서블릿은 정체성을 가지기 때문이다.
    *   
    * */
   
   @Override
   public void init() throws ServletException {
      // 컨텍스트에 처음 실릴 때 (서버가 시작될 때)
	  //같은 웹 응용프로그램에 소속된 서블릿과 JSP 프로그램들은 공동된 실행환경을 서로 공유한다. 
	  //이러한 환경을 Context라하고 이 컨텍스트를 통해서 같은 웹응용프로그램에서 소속된 서블릿과 JSP는 서로 데이터를 공유할 수 있다.

      ServletConfig config = this.getServletConfig();
      
      //웹 애플리케이션은 오직 하나의 ServletContext으로 전체 웹 애플리케이션에서 정보를 공유한다. 
      //하지만 웹 애플리케이션 안에 있는 서블릿은 자신만의 ServletConfig를 가진다!
      
      //서버당 하나씩 있는게 어플리케이션
      //컨텍스트(Context) 초기화 파라미터는 특정 하나의 서블릿만 사용하는 것이 아니라
      //모든 웹 애플리케이션에서 이용할 수 있다는 차이가 있다.
      //웹 애플리케이션에 있는 모든 JSP 서블릿에서 별다른 코딩없이도 컨텍스트 초기화 파라미터 정보에 접근할수 있다
      ServletContext application = getServletContext();
      
      this.name = config.getInitParameter("name");
      this.tel = config.getInitParameter("TEL");
      this.user = application.getInitParameter("user");
      this.charSet = application.getInitParameter("encoding");
      
      System.out.println("name : " + name);
      System.out.println("tel : " + tel);
      System.out.println("user : " + user);
   }
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
	  req.setCharacterEncoding("EUC-KR"); 
	  resp.setCharacterEncoding("EUC-KR");
      resp.getWriter().append("잘 되고 있나? Servlet_A <br>")
                  .append("name: " + name);
      
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding(charSet);
      resp.setCharacterEncoding(charSet);
      
   }

}