package chap08.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	 //인터페이스는 바디{} 넣으면 안됨. 대신 접근제어자를 디폴트로 한다면 바디 구현 가능!
	 //이걸 클래스로 만들면 여기서 꼭 구현해야함. 그래서 인터페이스로한 것.인터페이스는 구현 안해도 되기 때문임.
	 void control(HttpServletRequest req, HttpServletResponse resp);

}
