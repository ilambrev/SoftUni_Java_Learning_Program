function generateReport() {
    let columnsNames = Array.from(document.querySelectorAll('table thead tr th'));
    let rowsData = Array.from(document.querySelectorAll('table tbody tr'));

    let output = [];

    for (let i = 0; i < rowsData.length; i++) {

        let newObject = {};

        for (let j = 0; j < columnsNames.length; j++) {

            if (columnsNames[j].querySelector('input').checked) {

                let cells = Array.from(rowsData[i].querySelectorAll('td'));

                newObject[columnsNames[j].textContent.toLowerCase().trim()] = cells[j].textContent;

            }

        }

        output.push(newObject);
    }

    document.querySelector('#output').value = JSON.stringify(output);
}