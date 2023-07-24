function attachEvents() {
  let submitButton = document.querySelector('#submit');
  let table = document.querySelector('#results tbody');
  let firstNameInput = document.querySelector('input[name="firstName"]');
  let lastNameInput = document.querySelector('input[name="lastName"]');
  let facultyNumberInput = document.querySelector('input[name="facultyNumber"]');
  let gradeInput = document.querySelector('input[name="grade"]');

  fetch('http://localhost:3030/jsonstore/collections/students')
    .then((res) => res.text())
    .then((body) => {

      let students = Object.values(JSON.parse(body));

      students.forEach(s => {

        let firstName = s.firstName;
        let lastName = s.lastName;
        let facultyNumber = s.facultyNumber;
        let grade = Number(s.grade);

        let studentTr = document.createElement('tr');

        let firstNameTd = document.createElement('td');
        firstNameTd.textContent = firstName;

        let lastNameTd = document.createElement('td');
        lastNameTd.textContent = lastName;

        let facultyNumberTd = document.createElement('td');
        facultyNumberTd.textContent = facultyNumber;

        let gradeTd = document.createElement('td');
        gradeTd.textContent = grade.toFixed(2);

        studentTr.appendChild(firstNameTd);
        studentTr.appendChild(lastNameTd);
        studentTr.appendChild(facultyNumberTd);
        studentTr.appendChild(gradeTd);

        table.appendChild(studentTr);

      });
    });

  submitButton.addEventListener('click', () => {

    let studentFirstName = firstNameInput.value;
    let studentLastName = lastNameInput.value;
    let studentFacultyNumber = facultyNumberInput.value;
    let studentGrade = gradeInput.value;

    if (studentFirstName !== '' && studentLastName !== '' && studentFacultyNumber !== '' && studentGrade !== '') {

      let newStudent = {
        firstName: studentFirstName,
        lastName: studentLastName,
        facultyNumber: studentFacultyNumber,
        grade: studentGrade
      }

      fetch('http://localhost:3030/jsonstore/collections/students', {
        method: 'post',
        headers: { 'Content-type': 'application/json' },
        body: JSON.stringify(newStudent),
      });
    }
  });
}

attachEvents();