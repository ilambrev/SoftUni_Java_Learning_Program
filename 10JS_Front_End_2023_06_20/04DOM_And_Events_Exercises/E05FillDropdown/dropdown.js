function addItem() {
    let text = document.querySelector('#newItemText').value;
    let value = document.querySelector('#newItemValue').value;

    let newElement = document.createElement('option');
    newElement.textContent = text;
    newElement.value = value;

    document.querySelector('#menu').appendChild(newElement);
    document.querySelector('#newItemText').value = '';
    document.querySelector('#newItemValue').value = '';
}