function addItem() {
    let text = document.querySelector('#newItemText').value;

    if (text !== '') {
        let newLiElement = document.createElement('li');
        newLiElement.textContent = text;

        let deleteButton = document.createElement('a');
        deleteButton.href = '#';
        deleteButton.textContent = '[Delete]';
        deleteButton.addEventListener('click', (e) => {
            e.target.parentElement.remove();
        })

        newLiElement.appendChild(deleteButton);
        document.querySelector('#items').appendChild(newLiElement);
        document.querySelector('#newItemText').value = '';
    }
}