function flightSchedule(input) {

    let flightsInSector = input[0].slice();
    let changedStatuses = input[1].slice();
    let statusToCheck = input[2][0];

    let schedule = {};

    for (let flight of flightsInSector) {

        let [name, ...rest] = flight.split(' ');
        let destination = rest.join(' ');

        let newFlight = {
            destination: destination,
            status: ''
        }

        schedule[name] = newFlight;

    }

    for (let flight of changedStatuses) {

        let [flightName, flightStatus] = flight.split(' ');

        if (schedule.hasOwnProperty(flightName)) {

            schedule[flightName].status = flightStatus;

        }

    }

    if (statusToCheck === 'Ready to fly') {

        Object.values(schedule)
            .filter(f => f.status.length === 0)
            .forEach(f => {
                f.status = 'Ready to fly';
                console.log(`{ Destination: '${f.destination}', Status: '${f.status}' }`);
            });

    } else {

        Object.values(schedule)
            .filter(f => f.status.length > 0)
            .forEach(f => console.log(`{ Destination: '${f.destination}', Status: '${f.status}' }`));

    }

}

/*
flightSchedule([
    ['WN269 Delaware',
        'FL2269 Oregon',
        'WN498 Las Vegas',
        'WN3145 Ohio',
        'WN612 Alabama',
        'WN4010 New York',
        'WN1173 California',
        'DL2120 Texas',
        'KL5744 Illinois',
        'WN678 Pennsylvania'],
    ['DL2120 Cancelled',
        'WN612 Cancelled',
        'WN1173 Cancelled',
        'SK430 Cancelled'],
    ['Cancelled']
]);
flightSchedule([
    ['WN269 Delaware',
        'FL2269 Oregon',
        'WN498 Las Vegas',
        'WN3145 Ohio',
        'WN612 Alabama',
        'WN4010 New York',
        'WN1173 California',
        'DL2120 Texas',
        'KL5744 Illinois',
        'WN678 Pennsylvania'],
    ['DL2120 Cancelled',
        'WN612 Cancelled',
        'WN1173 Cancelled',
        'SK330 Cancelled'],
    ['Ready to fly']
]);
*/