const fruits = document.getElementsByClassName('fruit');
const pineapple = document.getElementById('pineapple');
const orange = document.getElementById('orange');
const mango = document.querySelector('#mango');

//자바스크립트로 GET방식 요청을 보내는 아주 기본적인 방법(form을 만들지 않고 보낼 수 있음)
//location.href는 말 그대로 새로운 페이지로 이동할 때 사용한다.
//즉, 현재 페이지에서 설정한 URL 페이지로 이동하게 된다.
function moveToController(fruitName) {
	location.href = '/chap02/fruit/controller?fruit=' + fruitName;
}                                    //원래는 form으로 input의 name 값을 줘야하지만 자바스크립트의 get방식은
                                     //location.href으로 url뒤에 name값을 미리 넣어준다! 

//어떤 데이터로 부터 배열을 생성합니다.
//문자열을 문자 단위로 쪼개어 배열로 만들거나, 아규먼트를 배열로 만들 수 있습니다.
Array.from(fruits).forEach((f) => {
	f.addEventListener('click', () => {
		moveToController(f.dataset.fruitName);
	});
	
});


/*
pineapple.addEventListener('click', () => {
	moveToController('pineapple');
});
orange.addEventListener('click', () => {
	moveToController('orange');
});
mango.addEventListener('click', () => {
	moveToController('mango');
});
          //fruit-price에서 -대신 p가 대문자로 변환된다.(자바에서 -는 빼기이기 때문)
console.log('pineapple element\'s의 이름 : ', pineapple.dataset.fruitName);
console.log('pineapple element\'s의 가격 : ', pineapple.dataset.fruitPrice);
*/
















