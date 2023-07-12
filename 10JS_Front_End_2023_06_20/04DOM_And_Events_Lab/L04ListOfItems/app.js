function addItem() {
    let inputText = document.getElementById('newItemText').value;

    if (inputText !== '') {
        let newLi = document.createElement('li');

        newLi.textContent = inputText;

        document.getElementById('items').appendChild(newLi);
        document.getElementById('newItemText').value = '';
    }
}