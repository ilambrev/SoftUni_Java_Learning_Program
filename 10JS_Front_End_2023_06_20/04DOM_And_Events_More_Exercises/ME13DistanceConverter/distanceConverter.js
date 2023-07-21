function attachEventsListeners() {
    let convertButton = document.querySelector('#convert');

    let units = {
        km: 1000,
        m: 1,
        cm: 0.01,
        mm: 0.001,
        mi: 1609.34,
        yrd: 0.9144,
        ft: 0.3048,
        in: 0.0254
    };

    convertButton.addEventListener('click', () => {
        let inputDistance = Number(document.querySelector('#inputDistance').value);

        let inputDistanceUnitType = document.querySelector('#inputUnits').value;
        let outputDistanceUnitType = document.querySelector('#outputUnits').value;

        let result = (inputDistance * units[inputDistanceUnitType]) / units[outputDistanceUnitType];

        document.querySelector('#outputDistance').value = result;

    });
}