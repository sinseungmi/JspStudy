<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#fruit-title {
	text-align: center;
}
#fruit-container {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
	grid-column-gap: 5%;
	width: 600px;
	
	margin: auto;
}
#fruit-container > div {
	height: 200px;
	background-size: contain;
	background-repeat: no-repeat;
	background-position: center;
}
#pineapple{
	background-image: url('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MTRfNDkg%2FMDAxNjIzNjQ0MzUzMDE2.Gnu0d2-TskZFpH8-ZYYordCkGD8nu-zPhmH9m6Pt-Tcg._JSHIKPNhYhjjr2lz9SCT-rZZhXHDxjpRPE-aTNp2vAg.JPEG.sea_7852%2Fpineapple-with-slices-isolated-white-surface-top-view.jpg&type=a340');
}
#orange {
	background-image: url('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAzMTJfMjU0%2FMDAxNjE1NTQzMzIzMjk1.UY5E-o1RAndcQEXk5RfH7HEthJGx2pMaLb2r3pSLSdIg.Tiwgjuq4yCTpdQmvt-Vbrrx72ld8_tGnppEAye7K2xog.JPEG.loclbro%2Ffhzjfqmfhdhfpswl5.jpg&type=a340');
}
#mango {
	background-image: url('https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MTRfNDIg%2FMDAxNjE4MzU5ODAwNzYy.3J7HB_iFxmQlnzUZj4JsvFT3u_srrjMmjE5peGN-TZwg.fY9dgZpcRJx2A1Cpre11Zd5dMSNPtNwAByGidSs8mIQg.PNG.jangbonam%2F%25BE%25D6%25C7%25C3%25B8%25C1%25B0%25ED.PNG&type=l340_165');
}

</style>
</head>
<body>

<h3 id="fruit-title">과일을 골라보세요</h3>

<!-- 
data-* : 해당 속성에 저장한 값은 자바스크립트에서 꺼내기 위해 설정해놓는 속성값이다 
속성에 접근하는 방법은 data 속성의 data-부분을 뺀 뒷부분만 사용하며 - 뒤 첫번째 영단어는 대문자로 작성하여야 합니다.
-->
<div id="fruit-container">
	<div id="pineapple" class="fruit"
		data-fruit-name="pineapple" data-fruit-price="5000"></div>
	<div id="orange" class="fruit"
		data-fruit-name="orange" data-fruit-price="1000"></div>
	<div id="mango" class="fruit"
		data-fruit-name="mango" data-fruit-price="2500"></div>
</div>

<script src="./js/fruit.js"></script>
   
</body>
</html>















