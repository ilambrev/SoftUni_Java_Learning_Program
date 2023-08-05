function motoGPRace(input) {

    let ridersNumber = Number(input[0]);
    let ridersDetails = input.slice(1, ridersNumber + 1);
    let commands = input.slice(ridersNumber + 1);

    let command = commands.shift();

    let raceParticipients = [];

    for (let riderDetails of ridersDetails) {

        let [riderName, fuelCapacity, position] = riderDetails.split('|');
        fuelCapacity = Number(fuelCapacity);
        position = Number(position);

        let rider = {
            name: riderName,
            fuel: fuelCapacity,
            position: position,
        }

        if (fuelCapacity <= 100) {
            raceParticipients.push(rider);
        }

    }

    while (command !== 'Finish') {

        let [commandName, rider, ...commandParams] = command.split(' - ');

        switch (commandName) {
            case 'StopForFuel':

                let minimumFuel = Number(commandParams[0]);
                let changedPosition = Number(commandParams[1]);

                let riderIndex = raceParticipients.map(p => p.name).indexOf(rider);

                if (raceParticipients[riderIndex].fuel < minimumFuel) {
                    raceParticipients[riderIndex].position = changedPosition;
                    console.log(`${rider} stopped to refuel but lost his position, now he is ${changedPosition}.`);
                } else {
                    console.log(`${rider} does not need to stop for fuel!`);
                }

                break;
            case 'Overtaking':

                let secondRider = commandParams[0];

                let firstRiderIndex = raceParticipients.map(p => p.name).indexOf(rider);
                let secondRiderIndex = raceParticipients.map(p => p.name).indexOf(secondRider);

                if (raceParticipients[firstRiderIndex].position < raceParticipients[secondRiderIndex].position) {

                    let firstRiderPosition = raceParticipients[firstRiderIndex].position;

                    raceParticipients[firstRiderIndex].position = raceParticipients[secondRiderIndex].position;
                    raceParticipients[secondRiderIndex].position = firstRiderPosition;

                    console.log(`${rider} overtook ${secondRider}!`);
                }

                break;
            case 'EngineFail':

                let lapsLeft = Number(commandParams[0]);

                let index = raceParticipients.map(p => p.name).indexOf(rider);
                raceParticipients.splice(index, 1);

                console.log(`${rider} is out of the race because of a technical issue, ${lapsLeft} laps before the finish.`);

                break;
        }

        command = commands.shift();
    }

    raceParticipients.forEach(p => console.log(`${p.name}\n  Final position: ${p.position}`));

}

/*
motoGPRace([
    "3",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|2",
    "Jorge Lorenzo|80|3",
    "StopForFuel - Valentino Rossi - 50 - 1",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"
])
motoGPRace([
    "4",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|3",
    "Jorge Lorenzo|80|4",
    "Johann Zarco|80|2",
    "StopForFuel - Johann Zarco - 90 - 5",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"
])
*/