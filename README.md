> # ✏JspStudy
>
> <br>
>
> **contextPath 설정** <br>
> - spring request mapping uri 시작점 <br>
> <c:set var="contextPath" value="${pageContext.request.contextPath }" />
> ## **<script>**
>
> HTML을 읽는 과정에 스크립트를 만나면 중단 시점이 생기고, 그 만큼 화면에 표시되는 것이 지연됨. 그리고 DOM 트리가 생성되기 전에 자바스크립트가 생성되지도 않은 DOM의 조작을 시도 할 수 있음. 보안을 위해서 JS파일을 바깥쪽으로 빼지만 일반적으로는 자바스크립트는 재사용이 안되기 때문에 **body태그 내 최하단에 위치**시킨다.
> ### a태그 or input type=”button”일 때 submit하는 법
>
> ```html
> <form action="action.jsp" id="frm">
>		<div><input type="button" onclick="document.getElementById('frm').submit();" 
>          value="전송">
>			<a href="#" onclick="document.getElementById('frm').submit();">
>			전송 </a>
>		</div>
>	</form>
> ```
>
> - form의 id를 가져와서 submit한다.
> ## iframe
>
> **다른 HTML 페이지를 현재 페이지에 포함**시키는 중첩된 브라우저로 iframe 요소를 이용하면 해당 웹 페이지 안에 어떠한 제한 없이 **다른 페이지를 불러와서 삽입** 할 수 있다.
> ### foreach **varStatus**속성
> 
> ```html
> <c:foreach> 태그 상태 속성 입니다.
> 
> 속성을 이용해서 제어하면 좀더 쉽게 제어할수있습니다.
> 
> <c:foreach items=”${items}” var=”item” varStatus=”status”>
> 
> ${status.current}<br/>      <!– 현재 아이템 –>
> 
> ${status.index}<br/>        <!– 0부터의 순서 –>
> 
> ${status.count}<br/>        <!– 1부터의 순서 –>
> 
> ${status.first}<br/>          <!– 현재 루프가 처음인지 반환 –>
> 
> ${status.last}<br/>           <!– 현재 루프가 마지막인지 반환 –> 
> 
> ${status.begin}<br/>        <!– 시작값 –>
> 
> ${status.end}<br/>           <!– 끝값 –>
> 
> ${status.step}<br/>          <!– 증가값 –>
> 
> < /c:forEach>
> 
> EX) items = [0,1,2,3,4,5]
> 
> <c:foreach items=”${items}” var=”item” varStatus=”status”>
> 
> ${status.current}<br/>      <!– 현재 아이템 –>
> 
> ${status.index}<br/>         0,1,2,3,4,5
> 
> ${status.count}<br/>        1,2,3,4,5,6
> 
> ${status.first}<br/>           index == 0일 때 true
> 
> ${status.last}<br/>           index == 5일 때 true
> 
> ${status.begin}<br/>        <!– 시작값 –>
> 
> ${status.end}<br/>          <!– 끝값 –>
> 
> ${status.step}<br/>         <!– 증가값 –>
> 
> < /c:forEach>
> 
> ```
