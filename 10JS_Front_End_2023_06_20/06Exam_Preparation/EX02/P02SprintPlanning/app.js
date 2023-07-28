window.addEventListener('load', solve);

function solve() {

    let createTaskButton = document.querySelector('#create-task-btn');
    let deleteTaskButton = document.querySelector('#delete-task-btn');
    let tasksSection = document.querySelector('#tasks-section');
    let pointsParahraph = tasksSection.querySelector('p:nth-of-type(1)');
    let createTaskForm = document.querySelector('#create-task-form');
    let tasks = {};
    let taskNumber = 0;

    let inputFields = {
        titleInput: document.querySelector('#title'),
        descriptionInput: document.querySelector('#description'),
        labelSelect: document.querySelector('#label'),
        estimationPointsInput: document.querySelector('#points'),
        assigneeInput: document.querySelector('#assignee'),
        taskIdInput: document.querySelector('#task-id')
    }

    let labels = {
        'Feature': { class: 'feature', symbol: '&#8865;' },
        'Low Priority Bug': { class: 'low-priority', symbol: '&#9737;' },
        'High Priority Bug': { class: 'high-priority', symbol: '&#9888;' }
    }

    createTaskButton.addEventListener('click', addTask);
    deleteTaskButton.addEventListener('click', deleteTask);

    function addTask() {
        let title = inputFields.titleInput.value;
        let description = inputFields.descriptionInput.value;
        let label = inputFields.labelSelect.value;
        let estimationPoints = Number(inputFields.estimationPointsInput.value);
        let assignee = inputFields.assigneeInput.value;

        if (title === '' || description === '' || estimationPoints < 0 || assignee === '') {
            return;
        }

        taskNumber++;
        let articleId = `task-${taskNumber}`;
        let newTask = { title, description, label, estimationPoints, assignee };
        tasks[articleId] = newTask;

        let article = document.createElement('article');
        article.setAttribute('id', articleId);
        article.classList.add('task-card');

        let featureDiv = document.createElement('div');
        featureDiv.classList.add('task-card-label', `${labels[label].class}`);
        featureDiv.innerHTML = `${label} ${labels[label].symbol}`;

        let taskTitleHeading = document.createElement('h3');
        taskTitleHeading.classList.add('task-card-title');
        taskTitleHeading.textContent = title;

        let descriptionParagraph = document.createElement('p');
        descriptionParagraph.classList.add('task-card-description');
        descriptionParagraph.textContent = description;

        let pointsDiv = document.createElement('div');
        pointsDiv.classList.add('task-card-points');
        pointsDiv.textContent = `Estimated at ${estimationPoints} pts`;

        let assigneeDiv = document.createElement('div');
        assigneeDiv.classList.add('task-card-assignee');
        assigneeDiv.textContent = `Assigned to: ${assignee}`;

        let actionsDiv = document.createElement('div');
        actionsDiv.classList.add('task-card-actions');

        let deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', loadConfirmDelete);

        actionsDiv.appendChild(deleteButton);

        article.appendChild(featureDiv);
        article.appendChild(taskTitleHeading);
        article.appendChild(descriptionParagraph);
        article.appendChild(pointsDiv);
        article.appendChild(assigneeDiv);
        article.appendChild(actionsDiv);

        tasksSection.appendChild(article);

        createTaskForm.reset();

        pointsParahraph.textContent = `Total Points ${totalPointView()}pts`;
    }

    function totalPointView() {
        return Object.values(tasks).map(t => t.estimationPoints).reduce((acc, curr) => acc + curr, 0);
    }

    function loadConfirmDelete(e) {
        let taskId = e.currentTarget.parentElement.parentElement.getAttribute('id');

        inputFields.titleInput.value = tasks[taskId].title;
        inputFields.descriptionInput.value = tasks[taskId].description;
        inputFields.labelSelect.value = tasks[taskId].label;
        inputFields.estimationPointsInput.value = tasks[taskId].estimationPoints;
        inputFields.assigneeInput.value = tasks[taskId].assignee;

        createTaskButton.disabled = true;
        deleteTaskButton.disabled = false;

        Object.values(inputFields).forEach(f => f.disabled = true);

        inputFields.taskIdInput.value = taskId;

    }

    function deleteTask() {
        let taskId = inputFields.taskIdInput.value;

        inputFields.taskIdInput.value = '';
        document.querySelector(`#${taskId}`).remove();
        Object.values(inputFields).forEach(f => f.disabled = false);
        createTaskForm.reset();
        delete tasks[taskId];

        createTaskButton.disabled = false;
        deleteTaskButton.disabled = true;

        pointsParahraph.textContent = `Total Points ${totalPointView()}pts`;
    }

}