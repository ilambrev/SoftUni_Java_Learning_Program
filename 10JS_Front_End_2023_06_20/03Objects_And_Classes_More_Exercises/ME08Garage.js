function garage(input) {

    let garages = {};

    function stringToObject(str) {

        let car = {};

        let carProperties = str.split(', ');

        for (let property of carProperties) {

            let [name, value] = property.split(': ');

            car[name] = value;

        }

        return car;

    }

    for (let line of input) {

        let [garageNumber, carData] = line.split(' - ');

        garageNumber = Number(garageNumber);

        if (!garages.hasOwnProperty(garageNumber)) {

            garages[garageNumber] = [];

        }

        garages[garageNumber].push(stringToObject(carData));

    }

    Object.entries(garages).forEach(e => {

        console.log(`Garage № ${e[0]}`);
        e[1].forEach(g => console.log('--- ' + Object.entries(g).map(e => e[0] + ' - ' + e[1]).join(', ')));

    });

}

/*
garage([
    '1 - color: blue, fuel type: diesel',
    '1 - color: red, manufacture: Audi',
    '2 - fuel type: petrol',
    '4 - color: dark blue, fuel type: diesel, manufacture: Fiat'
]);
garage([
    '1 - color: green, fuel type: petrol',
    '1 - color: dark red, manufacture: WV',
    '2 - fuel type: diesel',
    '3 - color: dark blue, fuel type: petrol'
]);
*/