function attachEvents() {
    const booksTable = document.querySelector('table>tbody');
    const loadBooksButton = document.querySelector('#loadBooks');
    const submitButton = document.querySelector('body>form>button');
    const form = document.querySelector('body>form');
    const titleInput = document.querySelector('#title');
    const authorInput = document.querySelector('#author');
    const isbnInput = document.querySelector('#isbn');

    let saveButton = document.createElement('button');
    saveButton.textContent = 'Save';
    saveButton.id = 'saveBtn';
    saveButton.style.display = 'none';

    form.appendChild(saveButton);

    booksTable.innerHTML = '';

    form.reset();

    function loadBooks() {

        booksTable.innerHTML = '';
        form.reset();

        fetch('http://localhost:8080/api/books')
            .then((res) => res.text())
            .then((body) => {

                let books = Object.entries(JSON.parse(body));

                books.forEach(b => {

                    let id = b[1].id;
                    let title = b[1].title;
                    let isbn = b[1].isbn;
                    let author = b[1].author;

                    let bookTr = document.createElement('tr');
                    bookTr.setAttribute('data-book-id', id);

                    let titleTd = document.createElement('td');
                    titleTd.textContent = title;

                    let authorTd = document.createElement('td');
                    authorTd.textContent = author

                    let isbnTd = document.createElement('td');
                    isbnTd.textContent = isbn;

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
                    bookTr.appendChild(isbnTd);
                    bookTr.appendChild(actionTd);

                    booksTable.appendChild(bookTr);
                });

                deleteBook(Array.from(document.querySelectorAll('.deleteBook')));
                editBook(Array.from(document.querySelectorAll('.editBook')));
            });

    }

    function deleteBook(deleteButtons) {

        deleteButtons.forEach(b => {
            b.addEventListener('click', async (e) => {

                let id = e.currentTarget.parentElement.parentElement.getAttribute('data-book-id');

                await fetch(`http://localhost:8080/api/books/${id}`, {
                    method: 'DELETE',
                });

                document.querySelector(`[data-book-id="${id}"]`).remove();

                loadBooks();

            });
        });

    }

    async function editBook(editButtons) {

        editButtons.forEach(b => {
            b.addEventListener('click', (e) => {
                e.preventDefault();

                form.querySelector('h3').textContent = 'Edit FORM';
                form.method = 'PATCH';
                submitButton.style.display = 'none';
                saveButton.style.display = 'block';

                const tableCells = Array.from(e.currentTarget.parentElement.parentElement.querySelectorAll('td'));

                let id = e.currentTarget.parentElement.parentElement.getAttribute('data-book-id');

                titleInput.value = tableCells[0].textContent;
                authorInput.value = tableCells[1].textContent;
                isbnInput.value = tableCells[2].textContent;

                saveButton.addEventListener('click', async (e) => {
                    e.preventDefault();

                    let title = titleInput.value;
                    let author = authorInput.value;
                    let isbn = isbnInput.value;

                    await fetch(`http://localhost:8080/api/books/${id}`, {
                        method: 'PATCH',
                        headers: { 'Content-type': 'application/json' },
                        body: JSON.stringify({ title, author, isbn }),
                    })

                    form.reset();

                    form.querySelector('h3').textContent = 'FORM';
                    form.method = 'POST';
                    submitButton.style.display = 'block';
                    saveButton.style.display = 'none';

                    loadBooks();

                })
            });
        });

    }

    loadBooksButton.addEventListener('click', loadBooks);

    submitButton.addEventListener('click', async (e) => {
        e.preventDefault();

        let title = titleInput.value;
        let isbn = isbnInput.value;
        let author = authorInput.value;

        if (title !== '' && isbn !== '' && author !== '') {

            await fetch('http://localhost:8080/api/books', {
                method: 'POST',
                headers: { 'Content-type': 'application/json' },
                body: JSON.stringify({ title, isbn, author }),
            });
        }

        form.reset();
        
    });

}

attachEvents();