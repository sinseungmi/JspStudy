package chap08.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap08.controller.Controller;
import chap08.controller.MusicController;

/*
 * 1.요청의 uri를 잘라낸다
 * 2.해쉬맵(<String, Controller> controller)을 만들어서 그 uri와 일치하는 키(uri)가 있다면 값으로 controller를 부른다
 * 3.여러가지 처리들은 컨트롤러로 이동해서 처리! 대신 req,resp은 꼭 들고가야하기 때문에 컨트롤러클래스에 메서드를 만들어 놓는다.
 * 4.컨트롤러 클래스에서 db에서 꺼낸 데이터 등들을 setAttribute에 실어 놓는 등 여러가지 처리를 한다.
 * 5.마지막으로 <String, String> url_mapping을 통해 url_mapping.get(uri)를 해서 요청의 uri와 일치하는 url매핑의
 * 	값이 꺼내지게 되는데 그 값은 이동하자고하는 경로이다! 이 꺼내진 경로로 forward(req,resp) 시킨다!
 *
 * 음..url_mapping에서 일치하는 키가 없을 수도 있으므로 if문을 통해 null이면 not found를 띄워준다
 * 
 * */
public class DispatcherServlet extends HttpServlet{
	
	HashMap<String, String> url_mapping = new HashMap<>();
	HashMap<String, Controller> controller_mapping = new HashMap<>();
	                //여따 굳이 컨트롤러 인터페이스를 만들어서 넣은 이유는?
	                //뮤직 컨트롤러가 있을 수도 있고 블로그 컨트롤러가 있을 수도 있고 여러가지 컨트롤러가 존재하기 때문!
	                //여러 컨트롤러들이 인터페이스 컨트롤러를 상속받으면 해쉬맵에 컨트롤러만 적으면 컨트롤러를 상속 받은 다양한
	                //컨트롤러들이 들어갈 수 있기 때문! 만약 인터페이스 컨트롤러가 없다면? 일일히 
	                //<String, 뮤직컨트롤러>, <String, 블로그컨트롤러>..이렇게 해야함 	
   @Override
   public void init() throws ServletException {
	   
	   controller_mapping.put("/music", new MusicController());
	   
	   url_mapping.put("/blog", "WEB-INF/blog/main.jsp");
	   url_mapping.put("/blog/add", "WEB-INF/blog/newPost.jsp");
	   url_mapping.put("/music", "WEB-INF/music/main.jsp");
	   url_mapping.put("/webtoon", "WEB-INF/webtoon/");
	   
      for (char ch = 'a'; ch <= 'z'; ch++) {
         url_mapping.put(
        		String.format("/%c%c%c", ch, ch, ch),
                String.format("/WEB-INF/page/%c.jsp", ch));
	      }
	   }
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		/chap08/aaa로 들어오면 /WEB-INF/page/a.jsp
		/chap08/bbb로 들어오면 /WEB-INF/page/b.jsp
		...
		/chap08/zzz로 들어오면 /WEB-INF/page/z.jsp
		로 포워딩 해보세요
		*/
		
		/*
		String uri = req.getRequestURI();
		char ch = 'a';
		int numCh = ch - '0';

		String uriStr = uri.replace(req.getContextPath(), "");
		
		for (int i = 'a'; i < 'z'; i++) {
			char alNum = (char) (numCh + '0');
			String alNum2 = Character.toString(alNum);
			numCh++;
			String path = "/"+alNum2+alNum2+alNum2;
			
			if (uriStr.equals(path)) {
				System.out.println("실행됨?");
				req.getRequestDispatcher(String.format("/WEB-INF/page/%s.jsp", alNum2)).forward(req,resp);	
			}
		}
		*/
		
	      String uri = 
	    		  req.getRequestURI().substring(req.getContextPath().length());
	      
	      
	      //각 URI마다 다른 처리가 적용될 수 있는 코드를 만들어 보세요.
	      //(새로운 URI가 추가될 때 이곳의 코드를 수정하지 않아야 함)
	      
	      // 처리
	      //xml에 일일히 모든 클래스를 지정할 필요 없이 디스패처에 '/'로 해결할 수 있다
	      controller_mapping.get(uri).control(req, resp);
	      
	      
	      String forward_to = url_mapping.get(uri);
	      
	      /*
	      String forward_to = null;
	      
	      for (char ch = 'a'; ch <= 'z'; ch++) {
	    	  if (uri.equals(String.format("/%c%c%c", ch, ch, ch))) {
	    		  forward_to = "/WEB-INF/page/" + ch + ".jsp";
	    	  }
	      }
	      */

	      if (forward_to == null) {
	         System.out.println("No matches found");
	      } else {
	         req.getRequestDispatcher(forward_to).forward(req, resp);
	      }
		
	}

}




















