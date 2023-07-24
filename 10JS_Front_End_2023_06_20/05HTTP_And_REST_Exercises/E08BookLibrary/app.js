function attachEvents() {
  let booksTable = document.querySelector('tbody');
  let loadBooksButton = document.querySelector('#loadBooks');
  let submitButton = document.querySelector('#form button');
  let titleInput = document.querySelector('#form input[name="title"]');
  let authorInput = document.querySelector('#form input[name="author"]');
  let form = document.querySelector('#form');

  let saveButton = document.createElement('button');
  saveButton.textContent = 'Save';
  saveButton.id = 'saveBtn';
  saveButton.style.display = 'none';

  form.appendChild(saveButton);

  booksTable.innerHTML = '';

  function loadBooks() {

    booksTable.innerHTML = '';

    fetch('http://localhost:3030/jsonstore/collections/books')
      .then((res) => res.text())
      .then((body) => {

        let books = Object.entries(JSON.parse(body));

        books.forEach(b => {

          let id = b[0];
          let author = b[1].author;
          let title = b[1].title;

          let bookTr = document.createElement('tr');
          bookTr.id = id;

          let titleTd = document.createElement('td');
          titleTd.textContent = title;

          let authorTd = document.createElement('td');
          authorTd.textContent = author

          let actionTd = document.createElement('td');

          let editButton = document.createElement('button');
          editButton.textContent = 'Edit';
          editButton.classList.add('editBook');

          let deleteButton = document.createElement('button');
          deleteButton.textContent = 'Delete';
          deleteButton.classList.add('deleteBook');

          actionTd.appendChild(editButton);
          actionTd.appendChild(deleteButton);

          bookTr.appendChild(titleTd);
          bookTr.appendChild(authorTd);
          bookTr.appendChild(actionTd);

          booksTable.appendChild(bookTr);
        });

        deleteBook(Array.from(document.querySelectorAll('.deleteBook')));
        editBook(Array.from(document.querySelectorAll('.editBook')));
      });

  }

  function deleteBook(deleteButtons) {

    deleteButtons.forEach(b => {
      b.addEventListener('click', (e) => {

        let id = e.currentTarget.parentElement.parentElement.id;

        fetch(`http://localhost:3030/jsonstore/collections/books/${id}`, {
          method: 'delete',
        });

        document.getElementById(`${id}`).remove();

      });
    });

  }

  function editBook(editButtons) {

    editButtons.forEach(b => {
      b.addEventListener('click', (e) => {

        form.querySelector('h3').textContent = 'Edit FORM';
        submitButton.style.display = 'none';
        saveButton.style.display = 'block';

        let id = e.currentTarget.parentElement.parentElement.id;

        titleInput.value = e.currentTarget.parentElement.parentElement.querySelector('td:nth-child(1)').textContent;
        authorInput.value = e.currentTarget.parentElement.parentElement.querySelector('td:nth-child(2').textContent;

        saveButton.addEventListener('click', () => {

          let editedBook = {
            author: authorInput.value,
            title: titleInput.value
          }

          fetch(`http://localhost:3030/jsonstore/collections/books/${id}`, {
            method: 'put',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(editedBook),
          })

          authorInput.value = '';
          titleInput.value = '';
          form.querySelector('h3').textContent = 'FORM';
          submitButton.style.display = 'block';
          saveButton.style.display = 'none';

        })
      });
    });

  }

  loadBooksButton.addEventListener('click', loadBooks);

  submitButton.addEventListener('click', () => {

    let title = titleInput.value;
    let author = authorInput.value;

    if (title !== '' && author !== '') {

      let newBook = {
        author: author,
        title: title
      }

      fetch('http://localhost:3030/jsonstore/collections/books', {
        method: 'post',
        headers: { 'Content-type': 'application/json' },
        body: JSON.stringify(newBook),
      });

      titleInput.value = '';
      authorInput.value = '';

    }
  });

}

attachEvents();