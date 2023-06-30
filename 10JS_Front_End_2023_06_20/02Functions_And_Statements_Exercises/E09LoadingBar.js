function loadingBar(loadPercentage) {

    let divisions = Math.round(loadPercentage / 10);

    let bar = '[' + '%'.repeat(divisions) + '.'.repeat(10 - divisions) + ']';

    if (divisions < 10) {

        console.log(`${loadPercentage}% ${bar}\nStill loading...`);

    } else {

        console.log(`100% Complete!\n${bar}`);

    }

}

// loadingBar(30);
// loadingBar(50);
// loadingBar(100);