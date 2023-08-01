function attachEvents() {

    const ENDPOINT_URL = 'http://localhost:3030/jsonstore/tasks';

    let toDoListElement = document.querySelector('#todo-list');
    let inputForm = document.querySelector('#root form');
    let itemTitleInput = document.querySelector('#title');

    let addButton = document.querySelector('#add-button');
    let loadAllButton = document.querySelector('#load-button');


    addButton.addEventListener('click', addItem)
    loadAllButton.addEventListener('click', (e) => {
        e.preventDefault();
        loadAllItems();
    });

    async function loadAllItems() {

        toDoListElement.innerHTML = '';

        await fetch(ENDPOINT_URL)
            .then(res => res.json())
            .then(body => {

                let items = Object.values(body);

                items.forEach(item => {

                    let name = item.name;
                    let id = item._id;

                    let itemListItemElement = document.createElement('li');
                    itemListItemElement.setAttribute('data-item-id', id);

                    let itemSpanElement = document.createElement('span');
                    itemSpanElement.textContent = name;

                    let removeButton = document.createElement('button');
                    removeButton.textContent = 'Remove';
                    removeButton.addEventListener('click', removeItem);

                    let editButton = document.createElement('button');
                    editButton.textContent = 'Edit';
                    editButton.addEventListener('click', editItem);

                    itemListItemElement.appendChild(itemSpanElement);
                    itemListItemElement.appendChild(removeButton);
                    itemListItemElement.appendChild(editButton);

                    toDoListElement.appendChild(itemListItemElement);

                });
            });

    }

    async function addItem(e) {
        e.preventDefault();

        let name = itemTitleInput.value;

        if (name === '') {
            return;
        }

        await fetch(ENDPOINT_URL, {
            method: 'POST',
            body: JSON.stringify({ name }),
        });

        loadAllItems();

        inputForm.reset();

    }

    async function removeItem(e) {
        let id = e.currentTarget.parentElement.getAttribute('data-item-id');

        await fetch(`${ENDPOINT_URL}/${id}`, {
            method: 'DELETE',
        });

        loadAllItems();
    }

    function editItem(e) {

        let parentElement = e.currentTarget.parentElement;
        let spanElementTextContent = parentElement.querySelector('span').textContent;
        let removeButton = parentElement.querySelector('button:nth-of-type(1)');

        parentElement.innerHTML = '';

        let inputElement = document.createElement('input');
        inputElement.value = spanElementTextContent;

        let submitButton = document.createElement('button');
        submitButton.textContent = 'Submit';
        submitButton.addEventListener('click', modifyItemName);

        parentElement.appendChild(inputElement);
        parentElement.appendChild(removeButton);
        parentElement.appendChild(submitButton);

    }

    async function modifyItemName(e) {
        let name = e.currentTarget.parentElement.querySelector('input').value;

        if (name === '') {
            return;
        }

        let id = e.currentTarget.parentElement.getAttribute('data-item-id');

        await fetch(`${ENDPOINT_URL}/${id}`, {
            method: 'PATCH',
            body: JSON.stringify({ name }),
        });

        loadAllItems();

    }

}

attachEvents();