
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
	searchModal.style = 'display:block;';
})
console.log(searchEstudent);

let buttonSearch = document.querySelector('#search');

buttonSearch.addEventListener('click', () => {
	let legajoNro = document.querySelector('#libreta').value;
	window.location.href = "http://localhost:8080/LiveServlet_Integrador/rest/estudiantes/libreta/" + legajoNro
})

let StudentByGender = document.querySelector('#search-student-genero');
let modalGender = document.querySelector('#search-genero');
StudentByGender.addEventListener('click', () =>{ 
	modalGender.style = 'display:block;';
})

let buttonSearchGender = document.querySelector('#search-by-genero');
buttonSearchGender.addEventListener('click', () => {
	let genero = document.querySelector('input[name="genero"]:checked').value;
	window.location.href = "http://localhost:8080/LiveServlet_Integrador/rest/estudiantes/genero/" + genero
})

let modalCarrera = document.querySelector('#search-carrera');
let carreraByCity = document.querySelector('#carrera-city');
carreraByCity.addEventListener('click', () => {
	modalCarrera.style = 'display:block;';
})


let buttonCarreraSearch = document.querySelector('#carrera-search');
buttonCarreraSearch.addEventListener('click', () => {
	let idCarrera = document.querySelector('#carrera').value;
	let city = document.querySelector('#ciudad').value;
	
	
	window.location.href = "http://localhost:8080/LiveServlet_Integrador/rest/estudiantes/" + idCarrera +"/" + city
})


let matriculaModal = document.querySelector('#new-matricula');
matriculaModal.addEventListener('click', ()=>{
	let modalShowMatricula = document.querySelector('#my-modal-matricula');
	modalShowMatricula.style = 'display:block;';
});
