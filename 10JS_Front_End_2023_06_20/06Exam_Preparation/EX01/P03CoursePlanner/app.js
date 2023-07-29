function attachEvents() {
    const ENDPOINT_URL = 'http://localhost:3030/jsonstore/tasks';

    let list = document.querySelector('#list');
    let loadCoursesButton = document.querySelector('#load-course');
    let addCourseButton = document.querySelector('#add-course');
    let editCourseButton = document.querySelector('#edit-course');

    let courseForm = document.querySelector('#form form');
    let titleInput = document.querySelector('#course-name');
    let typeInput = document.querySelector('#course-type');
    let descriptionInput = document.querySelector('#description');
    let teacherInput = document.querySelector('#teacher-name');

    let editedCourseId = '';

    loadCoursesButton.addEventListener('click', loadCourses);
    addCourseButton.addEventListener('click', addCourse);
    editCourseButton.addEventListener('click', updateEditedCourse);

    async function loadCourses() {

        list.innerHTML = '';

        await fetch(ENDPOINT_URL)
            .then(res => res.text())
            .then(body => {

                let courses = Object.values(JSON.parse(body));

                courses.forEach(c => {
                    let title = c.title;
                    let type = c.type;
                    let description = c.description;
                    let teacher = c.teacher;
                    let id = c._id;

                    let container = document.createElement('div');
                    container.classList.add('container');
                    container.setAttribute('data-id', id);

                    let titleHeading = document.createElement('h2');
                    titleHeading.textContent = title;

                    let teacherHeading = document.createElement('h3');
                    teacherHeading.textContent = teacher;

                    let typeHeading = document.createElement('h3');
                    typeHeading.textContent = type;

                    let descriptionHeading = document.createElement('h4');
                    descriptionHeading.textContent = description;

                    let editButton = document.createElement('button');
                    editButton.classList.add('edit-btn');
                    editButton.textContent = 'Edit Course';
                    editButton.addEventListener('click', editCourse);

                    let finishCourseButton = document.createElement('button');
                    finishCourseButton.classList.add('finish-btn');
                    finishCourseButton.textContent = 'Finish Course';
                    finishCourseButton.addEventListener('click', finishCourse);

                    container.appendChild(titleHeading);
                    container.appendChild(teacherHeading);
                    container.appendChild(typeHeading);
                    container.appendChild(descriptionHeading);
                    container.appendChild(editButton);
                    container.appendChild(finishCourseButton);

                    list.appendChild(container);
                });

            });
    }

    async function addCourse(e) {
        e.preventDefault();

        let title = titleInput.value;
        let type = typeInput.value;
        let description = descriptionInput.value;
        let teacher = teacherInput.value;

        if (!['Long', 'Medium', 'Short'].includes(type)) {
            return;
        }

        if (title === '' || description === '' || teacher === '') {
            return;
        }

        await fetch(ENDPOINT_URL, {
            method: 'POST',
            body: JSON.stringify({ title, type, description, teacher })
        });

        loadCourses();

        courseForm.reset();
    }

    function editCourse(e) {
        let id = e.currentTarget.parentElement.getAttribute('data-id');
        let courseContainer = e.currentTarget.parentElement;

        editedCourseId = id;

        titleInput.value = courseContainer.querySelector('h2').textContent;
        teacherInput.value = courseContainer.querySelector('h3:nth-of-type(1)').textContent;
        typeInput.value = courseContainer.querySelector('h3:nth-of-type(2)').textContent;
        descriptionInput.value = courseContainer.querySelector('h4').textContent;

        courseContainer.remove();

        editCourseButton.disabled = false;
        addCourseButton.disabled = true;

    }

    async function updateEditedCourse(e) {
        e.preventDefault();

        let _id = editedCourseId;

        let title = titleInput.value;
        let type = typeInput.value;
        let description = descriptionInput.value;
        let teacher = teacherInput.value;

        if (!['Long', 'Medium', 'Short'].includes(type)) {
            return;
        }

        if (title === '' || description === '' || teacher === '') {
            return;
        }

        await fetch(`${ENDPOINT_URL}/${_id}`, {
            method: 'PUT',
            body: JSON.stringify({ title, type, description, teacher, _id })
        });

       loadCourses();

        courseForm.reset();

        editCourseButton.disabled = true;
        addCourseButton.disabled = false;

    }

    async function finishCourse(e) {
        let id = e.currentTarget.parentElement.getAttribute('data-id');

        await fetch(`${ENDPOINT_URL}/${id}`, {
            method: 'DELETE',
        });

        loadCourses();

    }
}

attachEvents();