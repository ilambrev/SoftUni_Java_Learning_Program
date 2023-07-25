function horseRacing(input) {

    let horsesPositions = input[0].split('|');
    let commands = input.slice(1);
    let index = 0;
    let command = commands[index];

    while (command !== 'Finish') {

        let [commandName, ...commandContent] = command.split(' ');

        switch (commandName) {
            case 'Retake':
                let overtakingHorse = commandContent[0];
                let overtakenHorse = commandContent[1];
                let overtakingHorseIndex = horsesPositions.indexOf(overtakingHorse);
                let overtakenHorseIndex = horsesPositions.indexOf(overtakenHorse);

                if (overtakingHorseIndex < overtakenHorseIndex) {

                    horsesPositions[overtakenHorseIndex] = overtakingHorse;
                    horsesPositions[overtakingHorseIndex] = overtakenHorse;
                    console.log(`${overtakingHorse} retakes ${overtakenHorse}.`);
                }

                break;
            case 'Trouble':
                let troubledHorse = commandContent[0];
                let troubledHorseIndex = horsesPositions.indexOf(troubledHorse);

                if (troubledHorseIndex > 0) {

                    horsesPositions[troubledHorseIndex] = horsesPositions[troubledHorseIndex - 1];
                    horsesPositions[troubledHorseIndex - 1] = troubledHorse;

                    console.log(`Trouble for ${troubledHorse} - drops one position.`);
                }

                break;
            case 'Rage':
                let horseName = commandContent[0];
                let horseIndex = horsesPositions.indexOf(horseName);

                if (horsesPositions.length - 1 - horseIndex === 1) {
                    horsesPositions.splice(horseIndex, 1);
                    horsesPositions.push(horseName);
                } else if (horsesPositions.length - 1 - horseIndex > 1) {
                    horsesPositions.splice(horseIndex, 1);
                    horsesPositions.splice(horseIndex + 2, 0, horseName);
                }

                console.log(`${horseName} rages 2 positions ahead.`);

                break;
            case 'Miracle':
                horsesPositions.push(horsesPositions[0]);
                horsesPositions.shift();

                console.log(`What a miracle - ${horsesPositions[horsesPositions.length - 1]} becomes first.`);

                break;
        }

        index++;
        command = commands[index];
    }

    console.log(horsesPositions.join('->'));
    console.log(`The winner is: ${horsesPositions[horsesPositions.length - 1]}`);

}

/*
horseRacing([
    'Bella|Alexia|Sugar',
    'Retake Alexia Sugar',
    'Rage Bella',
    'Trouble Bella',
    'Finish'
]);
horseRacing([
    'Onyx|Domino|Sugar|Fiona',
    'Trouble Onyx',
    'Retake Onyx Sugar',
    'Rage Domino',
    'Miracle',
    'Finish'
]);
horseRacing([
    'Fancy|Lilly',
    'Retake Lilly Fancy',
    'Trouble Lilly',
    'Trouble Lilly',
    'Finish',
    'Rage Lilly'
]);
*/