package chap02.river;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */                              
@WebServlet(description = "abcdefg", 
			urlPatterns = { "/register" , "/cleanup/register"})
public final class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿을 처음 초기화 할 때 한번만 실행됩니다");
		System.out.println("초기화 중입니다");
		System.out.println("초기화가 끝났습니다");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 방식과 상관없이 service()가 호출됩니다.");
		
		//원래 service를 처리한 후 알맞은 doMethod()를 호출함
		//service의 기본 동작은 요청의 method에 따라 요청을 알맞은 
		//doMethod()로 분배하는 것이다.
		super.service(request,response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get 방식 요청인 경우 doGet()이 호출됩니다.");
		
		//HttpServletRequest에는 사용자의 요청에 대한 모든 정보가 담겨 있다.
		
		// 그중에서 form을 통해 실려온 데이터는 요청 객체의 parameter에 담겨있다.
		// 전송된 데이터들을 파라미터에 알아서 보관한다.
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		
		//잘못된 파라미터를 가져오는 경우 null이 리턴 됨
		String nickName = request.getParameter("nick-name");
		
		System.out.printf("사용자가 보낸 이름: %s %s\n",firstName, lastName);
		
		/*
		 * getWriter()는 '쓰기'를 통해 응답하겠다는 메서드. 데이터타입은 PrintWriter.
		 * out.print("<html>");
		 * 위에서 out이라는 객체가 생성되었으므로 out.print();를 통해 html페이지에 
		 * 원하는 결과를 출력할 수 있습니다.
		 * */
		response.getWriter()
			.append("Username:" +  firstName)
			.append(" " + lastName)
			.append("<br> Nickname: " + nickName);
		
		System.out.println("request로 알 수 있는 정보들");
		System.out.println("url : " + request.getRequestURL()); 
		System.out.println("uri : " + request.getRequestURI()); 
		System.out.println("method : " + request.getMethod());
		
		//contextPath : 현재 프로젝트를 웹 서버(톰캣)에 등록할 때 사용하고 있는 경로 이름
		System.out.println("contextPath : " + request.getContextPath());
		System.out.println("요청자 IP주소 : " + request.getRemoteAddr());
		System.out.println("포트번호 : " + request.getServerPort());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request에 들어있는 데이터를 해석할 인코딩 타입을 설정
		request.setCharacterEncoding("EUC-KR");
		
		System.out.println("Post방식 요청인 경우 doPost()가 호출됩니다");
		
		System.out.println(request.getParameter("first-name"));
		System.out.println(request.getParameter("last-name"));
		System.out.println(request.getParameter("time"));
		
		//하나의 name 속성에 여러개의 값을 받아야 하는 경우(체크박스 등)
		String[] intrests = request.getParameterValues("intrest");
		System.out.println(Arrays.toString(intrests));
		
		//getParameterNames()는 체크박스에서 맨앞 값만 꺼낸다
		// name 속성값을 몰라도 받은 모든 것을 꺼낼 수 있다
		//Enumeration은 다음 내용이 있는지 확인하는 hasMoreElements() 메서드와 
		//그 값을 가져오는 nextElement() 메서드가 있고 컬렉션의 데이터를 삭제하는 기능은 없습니다.
		//Enumeration 인터페이스는 객체들의 집합(Vector)에서 
		//각각의 객체들을 한순간에 하나씩 처리할 수 있는 메소드를 제공하는 켈렉션이다.

		Enumeration<String> paramNames = request.getParameterNames();
		
		//java.sql의 ResultSet과 비슷한 느낌으로 사용한다
		while (paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			
			System.out.println("Enumeration으로 꺼내봄 : " + 
			Arrays.toString(request.getParameterValues(name)));
		}
		
		// 응답 객체에 실어놓을 데이터의 인코딩 타입을 설정
		// 서블릿에서 화면에 데이터를 출력할 때 한글이 깨지지 않게 하기위해
		// response.setCharacterEncoding을 추가한다.
		response.setCharacterEncoding("UTF-8");
	}

}












