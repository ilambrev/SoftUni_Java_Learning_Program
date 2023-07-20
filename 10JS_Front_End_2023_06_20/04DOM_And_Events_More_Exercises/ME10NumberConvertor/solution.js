function solve() {
    let toMenu = document.querySelector('#selectMenuTo');

    toMenu.querySelector('option').value = 'binary';
    toMenu.querySelector('option').textContent = 'Binary';

    let hexadecimalOption = document.createElement('option');
    hexadecimalOption.value = 'hexadecimal';
    hexadecimalOption.textContent = 'Hexadecimal';

    toMenu.appendChild(hexadecimalOption);

    let convertButton = document.querySelector('#container button');

    convertButton.addEventListener('click', () => {
        let decimal = Number(document.querySelector('#input').value);
        let result = '';

        if (toMenu.value === 'binary') {
            result = decimal.toString(2);
        } else if (toMenu.value === 'hexadecimal') {
            result = decimal.toString(16).toUpperCase();
        }

        document.querySelector('#result').value = result;
    });

}