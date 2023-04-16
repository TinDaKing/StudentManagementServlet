
const myForm = document.getElementById("form-edit");
const myBtn = document.getElementById("button-edit");

myBtn.addEventListener('click', () => {
	if (myForm.classList.contains('hidden')) {
		myForm.classList.remove('hidden');
		myBtn.textContent = 'Minimize';
	} else {
		myForm.classList.add('hidden');
		myBtn.textContent = 'Change data';
	}
});
