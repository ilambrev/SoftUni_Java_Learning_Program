function spiceMustFlow(startingYield) {

    let currentYield = startingYield;
    let totalAmountOfSpice = 0;
    let days = 0;

    while (currentYield >= 100) {

        days++;

        totalAmountOfSpice += currentYield;

        totalAmountOfSpice -= totalAmountOfSpice > 26 ? 26 : totalAmountOfSpice;

        currentYield -= 10;

    }

    totalAmountOfSpice -= totalAmountOfSpice > 26 ? 26 : totalAmountOfSpice;

    console.log(`${days}\n${totalAmountOfSpice}`);

}

// spiceMustFlow(111);
// spiceMustFlow(450);