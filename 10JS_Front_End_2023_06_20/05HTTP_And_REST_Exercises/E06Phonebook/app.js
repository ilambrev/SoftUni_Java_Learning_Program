function attachEvents() {
    let loadButton = document.querySelector('#btnLoad');
    let createButton = document.querySelector('#btnCreate');
    let personInputField = document.querySelector('#person');
    let phoneInputField = document.querySelector('#phone');
    let phonebook = document.querySelector('#phonebook');

    function loadPhonebook() {
        
        phonebook.innerHTML = '';

        fetch('http://localhost:3030/jsonstore/phonebook')
            .then((res) => res.text())
            .then((body) => {

                let records = Object.values(JSON.parse(body));

                records.forEach(r => {

                    let person = r.person;
                    let phone = r.phone;
                    let id = r._id;

                    let personLi = document.createElement('li');
                    personLi.textContent = `${person}: ${phone}`;
                    personLi.id = id;

                    let deleteButton = document.createElement('button');
                    deleteButton.textContent = 'Delete';
                    deleteButton.classList.add('btnDelete');

                    personLi.appendChild(deleteButton);

                    phonebook.appendChild(personLi);

                });

                deleteRecord(Array.from(document.querySelectorAll('.btnDelete')));

            });
    }

    function deleteRecord(deleteButtons) {

        deleteButtons.forEach(b => {
            b.addEventListener('click', (e) => {

                let id = e.currentTarget.parentElement.id;

                fetch(`http://localhost:3030/jsonstore/phonebook/${id}`, {
                    method: 'delete',
                });

                document.getElementById(`${id}`).remove();

            });
        });

    }

    loadButton.addEventListener('click', loadPhonebook);

    createButton.addEventListener('click', () => {

        let person = personInputField.value;
        let phone = phoneInputField.value;

        let newContact = {
            person: person,
            phone: phone
        }

        fetch('http://localhost:3030/jsonstore/phonebook', {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(newContact)
        });

        personInputField.value = '';
        phoneInputField.value = '';

    });
}

attachEvents();