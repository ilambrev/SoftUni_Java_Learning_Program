function attachEventsListeners() {
    let convertButtons = Array.from(document.querySelectorAll('input[value="Convert"]'));

    console.log(convertButtons);

    convertButtons.forEach(b => {
        b.addEventListener('click', (e) => {
            let unitsNumber = Number(e.currentTarget.parentElement.querySelector('input[type="text"]').value);
            let unitType = e.currentTarget.parentElement.querySelector('input[type="text"]').id;

            convertTimeUnits(unitType, unitsNumber);
        });
    });


    function convertTimeUnits(unitType, unitsNumber) {

        switch (unitType) {
            case 'days':
                document.querySelector('#hours').value = unitsNumber * 24;
                document.querySelector('#minutes').value = unitsNumber * 1440;
                document.querySelector('#seconds').value = unitsNumber * 86400;
                break;
            case 'hours':
                document.querySelector('#days').value = unitsNumber / 24;
                document.querySelector('#minutes').value = unitsNumber * 60;
                document.querySelector('#seconds').value = unitsNumber * 3600;
                break;
            case 'minutes':
                document.querySelector('#days').value = unitsNumber / 1440;
                document.querySelector('#hours').value = unitsNumber / 60;
                document.querySelector('#seconds').value = unitsNumber * 60;
                break;
            case 'seconds':
                document.querySelector('#days').value = unitsNumber / 86400;
                document.querySelector('#hours').value = unitsNumber / 3600;
                document.querySelector('#minutes').value = unitsNumber / 60;
                break;

        }

    }
}