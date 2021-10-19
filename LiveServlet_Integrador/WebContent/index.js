let studentModal = document.querySelector('#my-modal');
let newStudent = document.querySelector('#new-student');
let searchModal = document.querySelector('#search-modal');
newStudent.addEventListener('click', () =>{
	studentModal.style = 'display:block;'
});

let saveStudent = document.querySelector('#save');
saveStudent.addEventListener('click', () => {
	studentModal.style = 'display:hidden;'
});

let searchEstudent = document.querySelector('#search-student');
searchEstudent.addEventListener('click', () => {
	console.log('HOLA');
	searchModal.style = 'display:block;'
})