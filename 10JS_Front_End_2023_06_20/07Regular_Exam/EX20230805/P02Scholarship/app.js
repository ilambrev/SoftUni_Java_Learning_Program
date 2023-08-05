window.addEventListener("load", solve);

function solve() {

  let studentInput = document.querySelector('#student');
  let universityInput = document.querySelector('#university');
  let scoreInput = document.querySelector('#score');

  let previewList = document.querySelector('#preview-list');
  let candidatesList = document.querySelector('#candidates-list');

  let nextButton = document.querySelector('#next-btn');

  nextButton.addEventListener('click', addStudentToPreview);




  function addStudentToPreview(e) {
    e.preventDefault();

    let student = studentInput.value;
    let university = universityInput.value;
    let score = scoreInput.value;

    if (student === '' || university === '' || score === '') {
      return;
    }

    let studentListItemElement = document.createElement('li');
    studentListItemElement.classList.add('application');

    let studentArticleElement = document.createElement('article');

    let studentHeadingElement = document.createElement('h4');
    studentHeadingElement.textContent = student;

    let universityParagraphElement = document.createElement('p');
    universityParagraphElement.textContent = `University: ${university}`;

    let scoreParagraphElement = document.createElement('p');
    scoreParagraphElement.textContent = `Score: ${score}`;

    studentArticleElement.appendChild(studentHeadingElement);
    studentArticleElement.appendChild(universityParagraphElement);
    studentArticleElement.appendChild(scoreParagraphElement);

    let editButton = document.createElement('button');
    editButton.classList.add('action-btn', 'edit');
    editButton.textContent = 'edit';
    editButton.addEventListener('click', editStudent);

    let applyButton = document.createElement('button');
    applyButton.classList.add('action-btn', 'apply');
    applyButton.textContent = 'apply';
    applyButton.addEventListener('click', applyForScholarship);


    studentListItemElement.appendChild(studentArticleElement);
    studentListItemElement.appendChild(editButton);
    studentListItemElement.appendChild(applyButton);

    previewList.appendChild(studentListItemElement);

    nextButton.disabled = true;

    studentInput.value = '';
    universityInput.value = '';
    scoreInput.value = '';

  }

  function editStudent(e) {

    let currentStudent = e.currentTarget.parentElement;

    studentInput.value = currentStudent.querySelector('h4').textContent;
    universityInput.value = currentStudent.querySelector('p:nth-of-type(1)').textContent.split(': ')[1];
    scoreInput.value = currentStudent.querySelector('p:nth-of-type(2)').textContent.split(': ')[1];

    currentStudent.remove();

    nextButton.disabled = false;

  }

  function applyForScholarship(e) {

    let currentStudent = e.currentTarget.parentElement;

    currentStudent.querySelector('.edit').remove();
    currentStudent.querySelector('.apply').remove();

    candidatesList.appendChild(currentStudent);

    nextButton.disabled = false;

  }

}