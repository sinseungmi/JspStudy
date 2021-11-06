const addForm = document.querySelector('#addForm');
const status = document.querySelector('#status');

const continueBtn = document.querySelector('#continueBtn');
const completeBtn = document.querySelector('#completeBtn');


continueBtn.addEventListener('click', (e) => {
	status.setAttribute('value', 'M');
	addForm.submit();
});

completeBtn.addEventListener('click', (e) => {
	status.setAttribute('value', 'R');
	addForm.submit();
});