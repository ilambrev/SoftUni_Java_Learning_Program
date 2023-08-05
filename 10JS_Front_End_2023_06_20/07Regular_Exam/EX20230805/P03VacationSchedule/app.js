function vacationSchedule() {

    const VACATIONS_ENDPOINT_URL = 'http://localhost:3030/jsonstore/tasks';

    let nameInput = document.querySelector('#name');
    let daysInput = document.querySelector('#num-days');
    let dateInput = document.querySelector('#from-date');

    let vacationsListDivContainer = document.querySelector('#list');

    let loadVacationsButton = document.querySelector('#load-vacations');
    let addVacationButton = document.querySelector('#add-vacation');
    let editVacationButton = document.querySelector('#edit-vacation');

    let editedVacationId = '';


    loadVacationsButton.addEventListener('click', loadVacations);
    addVacationButton.addEventListener('click', addVacation);
    editVacationButton.addEventListener('click', updateVacationData);

    vacationsListDivContainer.innerHTML = '';


    async function loadVacations() {

        vacationsListDivContainer.innerHTML = '';

        let res = await fetch(VACATIONS_ENDPOINT_URL);
        let body = await res.json();

        let vacations = Object.values(body);

        vacations.forEach(v => {

            let name = v.name;
            let days = v.days;
            let date = v.date;
            let id = v._id;

            let vacationContainerDivElement = document.createElement('div');
            vacationContainerDivElement.classList.add('container');
            vacationContainerDivElement.setAttribute('data-id', `${id}`);

            let nameHeadingElement = document.createElement('h2');
            nameHeadingElement.textContent = name;

            let dateHeadingElement = document.createElement('h3');
            dateHeadingElement.textContent = date;

            let daysHeadingElement = document.createElement('h3');
            daysHeadingElement.textContent = days;

            let changeButton = document.createElement('button');
            changeButton.classList.add('change-btn');
            changeButton.textContent = 'Change';
            changeButton.addEventListener('click', changeVacation);

            let doneButton = document.createElement('button');
            doneButton.classList.add('done-btn');
            doneButton.textContent = 'Done';
            doneButton.addEventListener('click', markVacationAsDone);

            vacationContainerDivElement.appendChild(nameHeadingElement);
            vacationContainerDivElement.appendChild(dateHeadingElement);
            vacationContainerDivElement.appendChild(daysHeadingElement);
            vacationContainerDivElement.appendChild(changeButton);
            vacationContainerDivElement.appendChild(doneButton);

            vacationsListDivContainer.appendChild(vacationContainerDivElement);

            editVacationButton.disabled = true;

        });

    }

    async function addVacation(e) {
        e.preventDefault();

        let name = nameInput.value;
        let days = daysInput.value;
        let date = dateInput.value;

        await fetch(VACATIONS_ENDPOINT_URL, {
            method: 'POST',
            body: JSON.stringify({ name, days, date }),
        });

        loadVacations();

        nameInput.value = '';
        daysInput.value = '';
        dateInput.value = '';

    }

    function changeVacation(e) {

        let editedVacation = e.currentTarget.parentElement;
        let id = editedVacation.getAttribute('data-id');

        editedVacationId = id;

        nameInput.value = editedVacation.querySelector('h2').textContent;
        daysInput.value = editedVacation.querySelector('h3:nth-of-type(2)').textContent;
        dateInput.value = editedVacation.querySelector('h3:nth-of-type(1)').textContent;

        editedVacation.remove();

        addVacationButton.disabled = true;
        editVacationButton.disabled = false;

    }

    async function updateVacationData(e) {
        e.preventDefault();

        let name = nameInput.value;
        let days = daysInput.value;
        let date = dateInput.value;

        await fetch(`${VACATIONS_ENDPOINT_URL}/${editedVacationId}`, {
            method: 'PUT',
            body: JSON.stringify({ name, days, date, _id: editedVacationId }),
        });

        loadVacations();

        addVacationButton.disabled = false;
        editVacationButton.disabled = true;

        nameInput.value = '';
        daysInput.value = '';
        dateInput.value = '';

    }

    async function markVacationAsDone(e) {

        let id = e.currentTarget.parentElement.getAttribute('data-id');

        await fetch(`${VACATIONS_ENDPOINT_URL}/${id}`, {
            method: 'DELETE',
        });

        loadVacations();

    }

}

vacationSchedule();