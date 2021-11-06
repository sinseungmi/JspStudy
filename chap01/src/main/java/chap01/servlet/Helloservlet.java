package chap01.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * # �� ����Ʈ�� Ŭ���̾�Ʈ���� �������� ���� (JSP)
 * 
 * ȣ��Ʈ : �� �������� ������ �ִ� �� �������� ����
 * Ŭ���̾�Ʈ : �� ������ �����ϴ� �����
 * 
 * (1) Ŭ���̾�Ʈ�� ȣ��Ʈ���� �� �������� �����޶�� ��û�Ѵ�.
 *		��û�� �� ���ϴ� �������� �������� �� �ּ�(URL)�� ��� ������.
 * 
 * 		http://naver.com/news
 * 
 * 		htt:// - ��� ��� (http, https, ftp ...)
 * 		naver.com - �� ���� ��ǻ���� IP�ּ� (�Ǵ� ������)
 * 		/news - ����ڰ� �ش� �� �������� Ư���� ���ϴ� �ڿ�(�������� �Ǵ� �׸� ��...)
 * 
 * (2) ����� ��û�� Apache - Tomcat�� �����Ѵ�
 * 		Apache - Tomcat�� ��ϵǾ� �ִ� URL ���ε� �� ��ġ�ϴ� �ڿ��� ã�´�
 * 		
 * 		����� �� �ִ� �ڿ��� - .jsp, .java(Servlet), .html, 
 * 							��Ÿ �ڿ���(.js, .css, .jpg..)
 * 
 * 		��� ����� - @WebServlet ������̼�, webapp(WebContent) �ؿ� ���� �ֱ�..��
 * 
 * (3) ��ϵ� �ڿ��� �� ������� ��û�� ���� �ٸ� ������� ������ �������� ���� �� ����������Ѵ�
 * 
 * (4) Ŭ���̾�Ʈ�� ��û�� �ùٸ� ��û�̾��ٸ� (��Ĺ�� ��ϵ� �ڿ��� �´ٸ�)
 * 		�ش� �ڿ��� ����(servlet ���α׷� ����) �����Ѵ�. 
 * 		(�Ǵ� �̹� �ִ� �ڿ��� �״�� �����Ѵ�, ���� �� �������� �ƴ� �ڿ���)
 * 
 * (5) �� �������� ������ �ڿ��� ��û ���´� Ŭ���̾�Ʈ�� �� �������� �����Ѵ�
 * 		�� �������� ���� ���� ������ �ؼ��Ͽ� ����ڿ��� �����ش�.
 * */

/*
 * HttpServlet Ŭ�������� ����� ��û�� ó���ϴ� doGet/doPost �޼���� ��� 
 * HttpServletRequest�� HttpServletResponse ��ü�� �Ű������� ������ �ִ�.
 * HttpServletRequest�� HttpServletResponse ��ü�� �������� Ŭ���̾�Ʈ ���̸� �������ִ� �߿��� ��ü�� �̴�.
 * 
 * */


// �� ���������� �����Ϸ��� � URL�� �����ؾ��ϴ��� �����ϴ� ������̼� (/chap01/hello)
@WebServlet("/hello")
public class Helloservlet extends HttpServlet {
   //��û�� ������ ������ �����ϴ°� ������
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      // HttpServletRequest : ����ڰ� ���� ��� ��û ������ ���� �� �ִ� Ŭ����
      // HttpServletResponse: ���� ��û�� ���� �˸��� ������ ��Ƴ��� �� �ִ� Ŭ����
      
	  /*
	   * ���� ��Ʈ���� �ؽ�Ʈ�� ����ϴ� �͵� �����ϸ�, �� �۾��� �ϱ� ���ؼ� response.getWriter()�� ȣ���ؾ� �մϴ�.
	   * ��Ʈ������ ���̳ʸ� ����� ��Ʈ���� �ؽ�Ʈ ����� ��Ʈ���� �ֽ��ϴ�.
	   * ���� ���̳ʸ� ����� ��Ʈ���� InputStream(�Է�), OutputStrream(���)�̶�� ������ ������,
	   * �ؽ�Ʈ ����� ��Ʈ���� reader(�Է�), Writer(���)�� �����ϴ�.
	   * 
	   * 
	   * ����(mapping)�̶�?
	   * : Url��ΰ� �ʹ� ���, ���ȿ� ����Ǿ� �ִµ�, �̷��� ��θ� �����ϰ� ǥ���ϴ� �� �Դϴ�.
	   * 
	   * 
	   * * ������̼� : @ �� �Բ� ���� ���� ������̼��̶�� �մϴ�.
	   * @WebServlet("/���θ�")�� ���� java�ڵ忡 ���� �Է��Ͽ� ������ �� �ֽ��ϴ�.
	   * 
	   * 
	   * ��Ĺ�� ������̼��� Ȯ���Ͽ� "�ش� Servlet���� �����ϱ� ���ؼ��� URL�� /hello�� �����ϸ� �ȴ�"
	   * �� ������ �մϴ�
	   * 
	   * */ 
	   
	   
	  //resp��ü�� ����
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


