<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%--
     # jsp:useBean
     
     - 빈(Bean) 객체의 인스턴스를 생성하여 어트리뷰트에 등록한다
     - 생성한 인스턴스를 어느 어트리뷰트에 등록할지 설정할 수 있다
     
     # jsp:setProperty
     
     - 빈 객체의 필드를 채우는 기능을 하는 jsp태그
     - property 속성에 *를 설정하면 파라미터의 값을 이용해 자동으로 빈 객체의 필드를 채운다
     - 해당 빈 객체의 setter를 사용한다
     - name : 프로퍼티 값을 변경할 자바빈 객체의 이름. <jsp:useBean> 액션 태그의 id 속성에서 지정한 값을 사용
  
     ※ input 태그의 name값과 빈 클래스의 필드명을 일치시키면 자동으로 매핑해주는 경우가 많다
   --%>
   
<%--
	   ※ 아래 두 줄의 의미 (빈 객체 필드명과 똑같은 이름의 파라미터를 꺼내서 필드를 자동으로 채운다
	   
	   request.setAttribute("stu", new chap03.bean.Student());
	
	   Student stu = (Student) request.getAttribute("stu");
	   stu.setKor(request.getParameter("kor"));
	   stu.setEng(request.getParameter("eng"));
	   stu.setMath(request.getParameter("math"));
--%>

<jsp:useBean id="stu" class="chap03.bean.Student" scope="request"/>
<jsp:setProperty name="stu" property="*"/>

<p>
	${stu.name }, ${stu.kor }, ${stu.eng }, ${stu.math }
</p>
    
    
    
    
    
    