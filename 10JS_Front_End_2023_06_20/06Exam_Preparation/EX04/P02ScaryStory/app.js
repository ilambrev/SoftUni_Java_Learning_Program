window.addEventListener("load", solve);

function solve() {
  let firstNameInput = document.querySelector('#first-name');
  let lastNameInput = document.querySelector('#last-name');
  let ageInput = document.querySelector('#age');
  let storyTitleInput = document.querySelector('#story-title');
  let genreInput = document.querySelector('#genre');
  let yourStoryInput = document.querySelector('#story');

  let previewListElement = document.querySelector('#preview-list');
  let storyForm = document.querySelector('#main form');
  let mainDivElement = document.querySelector('#main');

  let publishButton = document.querySelector('#form-btn');

  publishButton.addEventListener('click', publishStory);

  function publishStory() {
    let firstName = firstNameInput.value;
    let lastName = lastNameInput.value;
    let age = ageInput.value;
    let storyTitle = storyTitleInput.value;
    let genre = genreInput.value;
    let yourStory = yourStoryInput.value;

    if (firstName === '' || lastName === '' || age === '' || storyTitle === '' || genre === '' || yourStory === '') {
      return;
    }

    let storyListItemElement = document.createElement('li');
    storyListItemElement.classList.add('story-info');

    let articleElement = document.createElement('article');

    let nameHeadingElement = document.createElement('h4');
    nameHeadingElement.textContent = `Name: ${firstName} ${lastName}`;

    let ageParagraphElement = document.createElement('p');
    ageParagraphElement.textContent = `Age: ${age}`;

    let titleParagraphElement = document.createElement('p');
    titleParagraphElement.textContent = `Title: ${storyTitle}`;

    let genreParagraphElement = document.createElement('p');
    genreParagraphElement.textContent = `Genre: ${genre}`;

    let yourStoryParagraphElement = document.createElement('p');
    yourStoryParagraphElement.textContent = yourStory;

    articleElement.appendChild(nameHeadingElement);
    articleElement.appendChild(ageParagraphElement);
    articleElement.appendChild(titleParagraphElement);
    articleElement.appendChild(genreParagraphElement);
    articleElement.appendChild(yourStoryParagraphElement);

    let saveButton = document.createElement('button');
    saveButton.classList.add('save-btn');
    saveButton.textContent = 'Save Story';
    saveButton.addEventListener('click', saveStory);

    let editButton = document.createElement('button');
    editButton.classList.add('edit-btn');
    editButton.textContent = 'Edit Story';
    editButton.addEventListener('click', editStory);

    let deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent = 'Delete Story';
    deleteButton.addEventListener('click', deleteStory);

    storyListItemElement.appendChild(articleElement);
    storyListItemElement.appendChild(saveButton);
    storyListItemElement.appendChild(editButton);
    storyListItemElement.appendChild(deleteButton);

    previewListElement.appendChild(storyListItemElement);

    storyForm.reset();

    publishButton.disabled = true;

  }

  function saveStory() {

    mainDivElement.innerHTML = '';

    let messageHeadingElement = document.createElement('h1');
    messageHeadingElement.textContent = 'Your scary story is saved!';

    mainDivElement.appendChild(messageHeadingElement);

  }

  function editStory(e) {

    let parentElement = e.currentTarget.parentElement;

    let saveButton = parentElement.querySelector('.save-btn');
    let editButton = parentElement.querySelector('.edit-btn');
    let deleteButton = parentElement.querySelector('.delete-btn');

    saveButton.disabled = true;
    editButton.disabled = true;
    deleteButton.disabled = true;
    publishButton.disabled = false;

    firstNameInput.value = parentElement.querySelector('h4').textContent.split(' ')[1];
    lastNameInput.value = parentElement.querySelector('h4').textContent.split(' ')[2];
    ageInput.value = parentElement.querySelector('p:nth-of-type(1)').textContent.split(' ')[1];
    storyTitleInput.value = parentElement.querySelector('p:nth-of-type(2)').textContent.split(': ')[1];
    genreInput.value = parentElement.querySelector('p:nth-of-type(3)').textContent.split(':')[1].trim();
    yourStoryInput.value = parentElement.querySelector('p:nth-of-type(4)').textContent;

    parentElement.remove();

  }

  function deleteStory(e) {

    let parentElement = e.currentTarget.parentElement;

    parentElement.remove();

    publishButton.disabled = false;

  }

}