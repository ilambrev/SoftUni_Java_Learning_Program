function solve() {
    let buttons = document.querySelectorAll('button');
    let quickCheckButton = buttons[0];
    let clearButton = buttons[1];
    let checkField = document.querySelector('#check p');
    let table = document.querySelector('table');
    let tableCellsInputs = Array.from(document.querySelectorAll('tbody tr td input'));

    quickCheckButton.addEventListener('click', () => {
        let rightCombinations = true;

        for (let i = 0; i < 3; i++) {

            let rowValues = tableCellsInputs[i * 3].value + tableCellsInputs[i * 3 + 1].value + tableCellsInputs[i * 3 + 2].value;
            let rowValuesAsString = rowValues.split('').map(v => Number(v)).sort((v1, v2) => v1 - v2).join('');

            if (rowValuesAsString !== '123') {
                rightCombinations = false;
                break;
            }

            let colValues = tableCellsInputs[i].value + tableCellsInputs[i + 3].value + tableCellsInputs[i + 6].value;
            let colValuesAsString = colValues.split('').map(v => Number(v)).sort((v1, v2) => v1 - v2).join('');

            if (colValuesAsString !== '123') {
                rightCombinations = false;
                break;
            }

        }

        if (rightCombinations) {
            checkField.style.color = 'green';
            checkField.textContent = 'You solve it! Congratulations!';
            table.style.border = '2px solid green';
        } else {
            checkField.style.color = 'red';
            checkField.textContent = 'NOP! You are not done yet...';
            table.style.border = '2px solid red';
        }

    });

    clearButton.addEventListener('click', () => {
        checkField.style.color = '';
        checkField.textContent = '';
        table.style.border = '';
        tableCellsInputs.forEach(cell => cell.value = '');
    });
}