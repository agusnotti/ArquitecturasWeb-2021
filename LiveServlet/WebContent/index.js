let studentModal = document.querySelector('#my-modal');
let newStudent = document.querySelector('#new-student');
newStudent.addEventListener('click', () =>{
	studentModal.style = 'display:block;'
});

let saveStudent = document.querySelector('#save');
saveStudent.addEventListener('click', () => {
	studentModal.style = 'display:hidden;'
});