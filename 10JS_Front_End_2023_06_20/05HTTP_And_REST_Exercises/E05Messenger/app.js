function attachEvents() {
    let sendButton = document.querySelector('#submit');
    let refreshButton = document.querySelector('#refresh');
    let messagesArea = document.querySelector('#messages');
    let nameField = document.querySelector('#controls input[name="author"]');
    let messageField = document.querySelector('#controls input[name="content"]');

    sendButton.addEventListener('click', () => {

        let authorName = nameField.value;
        let msgText = messageField.value;

        let newPost = {
            author: authorName,
            content: msgText
        }

        fetch('http://localhost:3030/jsonstore/messenger', {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(newPost),
        });

    });

    refreshButton.addEventListener('click', () => {

        fetch('http://localhost:3030/jsonstore/messenger')
            .then((res) => res.text())
            .then((body) => {

                let posts = Object.values(JSON.parse(body));

                messagesArea.textContent = posts.map(post => `${post.author}: ${post.content}`).join('\n');
            });
    });
}

attachEvents();