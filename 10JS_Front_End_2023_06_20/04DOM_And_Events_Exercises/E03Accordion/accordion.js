function toggle() {

    let button = document.querySelector('#accordion > .head > .button');

    if (button.textContent === 'More') {
        document.querySelector('#extra').style.display = 'block';
        button.textContent = 'Less';
    } else {
        document.querySelector('#extra').style.display = 'none';
        button.textContent = 'More';
    }
}