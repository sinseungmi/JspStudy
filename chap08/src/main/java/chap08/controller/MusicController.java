package chap08.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MusicController implements Controller{

	@Override
	public void control(HttpServletRequest req, HttpServletResponse resp) {
			
		//url '/music'���� ������ ���� ��� ó��.
		
		if (req.getMethod().equals("GET")) {
			
		}else if (req.getMethod().equals("POST")) {
			
		}
		
		//DB���� ���� �����͸� ��Ʈ����Ʈ�� �Ǿ� ���� �� �ִ�.
		req.setAttribute("music", "abc");
		req.setAttribute("artist", "������");
		req.setAttribute("title", "���ֵ� Ǫ����");
		
	}

}