function attachEvents() {
    let loadPostsButton = document.querySelector('#btnLoadPosts');
    let viewPostsButton = document.querySelector('#btnViewPost');
    let postsList = document.querySelector('#posts');
    let postComments = document.querySelector('#post-comments');
    let posts = [];

    loadPostsButton.addEventListener('click', () => {

        fetch('http://localhost:3030/jsonstore/blog/posts')
            .then((res) => res.text())
            .then((body) => {

                posts = Object.values(JSON.parse(body));

                posts.forEach(post => {
                    let value = post.id;
                    let text = post.title;

                    let option = document.createElement('option');
                    option.value = value;
                    option.textContent = text;

                    postsList.appendChild(option);
                });
            });
    });

    viewPostsButton.addEventListener('click', () => {

        fetch('http://localhost:3030/jsonstore/blog/comments')
            .then((res) => res.text())
            .then((body) => {

                let comments = Object.values(JSON.parse(body)).filter(p => p.postId === postsList.value);

                let commentsList = Array.from(postComments.querySelectorAll('li'));

                commentsList.forEach(comment => comment.remove());

                document.querySelector('#post-title').textContent = postsList.options[postsList.selectedIndex].text;
                document.querySelector('#post-body').textContent = posts.filter(post => post.id === postsList.value).map(post => post.body)[0];

                comments.forEach(comment => {
                    let commentLi = document.createElement('li');
                    commentLi.textContent = comment.text;

                    postComments.appendChild(commentLi);
                });
            });
    });

}

attachEvents();