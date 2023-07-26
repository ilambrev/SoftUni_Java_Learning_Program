function attachEvents() {

    const ENDPOINT_URL = 'http://localhost:3030/jsonstore/tasks';
    let loadBoardButton = document.querySelector('#load-board-btn');
    let addTaskButton = document.querySelector('#create-task-btn');
    let addTaskForm = document.querySelector('#form-section form');
    let taskTitleInput = document.querySelector('#title');
    let taskDescriptionInput = document.querySelector('#description');
    let taskSections = Array.from(document.querySelectorAll('.task-list'));
    let taskSectionId = {
        'ToDo': document.querySelector('#todo-section .task-list'),
        'In Progress': document.querySelector('#in-progress-section .task-list'),
        'Code Review': document.querySelector('#code-review-section .task-list'),
        'Done': document.querySelector('#done-section .task-list')
    }
    let taskButtonLabels = {
        'ToDo': 'Move to In Progress',
        'In Progress': 'Move to Code Review',
        'Code Review': 'Move to Done',
        'Done': 'Close'
    }
    let taskMovingOrder = {
        'Move to In Progress': 'In Progress',
        'Move to Code Review': 'Code Review',
        'Move to Done': 'Done',
    }

    loadBoardButton.addEventListener('click', loadBoard);

    addTaskButton.addEventListener('click', addTask);


    function loadBoard() {

        taskSections.forEach(s => s.innerHTML = '');

        fetch(ENDPOINT_URL)
            .then(res => res.text())
            .then(body => {

                let tasks = JSON.parse(body);

                Object.keys(tasks).forEach(key => {

                    let title = tasks[key].title;
                    let description = tasks[key].description;
                    let status = tasks[key].status;
                    let id = tasks[key]._id;

                    let taskListItem = document.createElement('li');
                    taskListItem.classList.add('task');
                    taskListItem.setAttribute('id', id);

                    let taskHeading = document.createElement('h3');
                    taskHeading.textContent = title;

                    let taskParagraph = document.createElement('p');
                    taskParagraph.textContent = description;

                    let taskButton = document.createElement('button');
                    taskButton.textContent = taskButtonLabels[status];
                    if (taskButton.textContent === 'Close') {
                        taskButton.addEventListener('click', deleteTask);
                    } else {
                        taskButton.addEventListener('click', moveTask);
                    }

                    taskListItem.appendChild(taskHeading);
                    taskListItem.appendChild(taskParagraph);
                    taskListItem.appendChild(taskButton);

                    taskSectionId[status].appendChild(taskListItem);
                });
            });
    }

    function addTask() {
        let title = taskTitleInput.value;
        let description = taskDescriptionInput.value;
        let status = 'ToDo';

        if (title === '' || description === '') {
            return;
        }

        fetch(ENDPOINT_URL, {
            method: 'POST',
            body: JSON.stringify({ title: title, description: description, status: status })
        })
            .then(loadBoard);

        addTaskForm.reset();
    }

    function moveTask(e) {
        let id = e.currentTarget.parentElement.getAttribute('id');

        let status = taskMovingOrder[e.currentTarget.textContent];

        fetch(`${ENDPOINT_URL}/${id}`, {
            method: 'PATCH',
            body: JSON.stringify({ status: status })
        })
            .then(loadBoard);

    }

    function deleteTask(e) {

        let id = e.currentTarget.parentElement.getAttribute('id');

        fetch(`${ENDPOINT_URL}/${id}`, {
            method: 'DELETE',
        })
            .then(loadBoard);

    }

}

attachEvents();