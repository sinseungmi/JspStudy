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
