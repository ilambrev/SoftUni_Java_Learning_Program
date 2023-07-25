window.addEventListener("load", solve);

function solve() {
    let taskTitleInput = document.querySelector('#task-title');
    let taskCategoryInput = document.querySelector('#task-category');
    let taskContentTextArea = document.querySelector('#task-content');
    let publishButton = document.querySelector('#publish-btn');
    let reviewList = document.querySelector('#review-list');

    publishButton.addEventListener('click', () => {
        let taskTitle = taskTitleInput.value;
        let taskCategory = taskCategoryInput.value;
        let taskContent = taskContentTextArea.value;

        if (taskTitle === '' || taskCategory === '' || taskContent === '') {
            return;
        }

        addTask(taskTitle, taskCategory, taskContent);

        let editButtons = Array.from(document.querySelectorAll('.edit'));

        editButtons.forEach(b => {
            b.addEventListener('click', (e) => {

                taskTitleInput.value = e.currentTarget.parentElement.querySelector('h4').textContent;
                taskCategoryInput.value = e.currentTarget.parentElement.querySelector('p:nth-of-type(1)').textContent.split(': ')[1];
                taskContentTextArea.value = e.currentTarget.parentElement.querySelector('p:nth-of-type(2)').textContent.split(': ')[1];;

                e.currentTarget.parentElement.remove();
            });
        });

        let postButtons = Array.from(document.querySelectorAll('.post'));

        postButtons.forEach(b => {
            b.addEventListener('click', (e) => {

                let post = e.currentTarget.parentElement;
                let clonedPost = post.cloneNode(true);

                clonedPost.querySelector('.edit').remove();
                clonedPost.querySelector('.post').remove();

                document.querySelector('#published-list').appendChild(clonedPost);

                e.currentTarget.parentElement.remove();
            })
        });
    });

    function addTask(taskTitle, taskCategory, taskContent) {
        let postLi = document.createElement('li');
        postLi.classList.add('rpost');

        let article = document.createElement('article');

        let title = document.createElement('h4');
        title.textContent = taskTitle;

        let category = document.createElement('p');
        category.textContent = `Category: ${taskCategory}`;

        let content = document.createElement('p');
        content.textContent = `Content: ${taskContent}`;

        article.appendChild(title);
        article.appendChild(category);
        article.appendChild(content);

        let editButton = document.createElement('button');
        editButton.classList.add('action-btn', 'edit');
        editButton.textContent = 'Edit';

        let postButton = document.createElement('button');
        postButton.classList.add('action-btn', 'post');
        postButton.textContent = 'Post';

        postLi.appendChild(article);
        postLi.appendChild(editButton);
        postLi.appendChild(postButton);

        reviewList.appendChild(postLi);

        taskTitleInput.value = '';
        taskCategoryInput.value = '';
        taskContentTextArea.value = '';
    }

}