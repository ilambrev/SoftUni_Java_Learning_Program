function carWash(commands) {

    let percentageOfCleaning = 0;

    for (let command of commands) {

        switch (command) {
            case 'soap':
                percentageOfCleaning = percentageOfCleaning + 10 > 100 ? 100 : percentageOfCleaning + 10;
                break;
            case 'water':
                percentageOfCleaning = percentageOfCleaning * 1.20 > 100 ? 100 : percentageOfCleaning * 1.20;
                break;
            case 'vacuum cleaner':
                percentageOfCleaning = percentageOfCleaning * 1.25 > 100 ? 100 : percentageOfCleaning * 1.25;
                break;
            case 'mud':
                percentageOfCleaning = percentageOfCleaning - (percentageOfCleaning * 0.10);
                break;

        }

    }

    console.log(`The car is ${percentageOfCleaning.toFixed(2)}% clean.`);

}

// carWash(['soap', 'soap', 'vacuum cleaner', 'mud', 'soap', 'water']);
// carWash(["soap", "water", "mud", "mud", "water", "mud", "vacuum cleaner"]);