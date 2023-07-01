function radioCrystals(input) {

    const desiredFinalThickness = Number(input[0]);
    let crystalChunks = input.slice(1).map(c => Number(c));

    const cut = (chunk) => chunk / 4;
    const lap = (chunk) => chunk * 0.80;
    const grind = (chunk) => chunk - 20;
    const etch = (chunk) => chunk - 2;
    const xRay = (chunk) => chunk + 1;
    const transportingAndWashing = (chunk) => Math.floor(chunk);

    for (let chunk of crystalChunks) {

        console.log(`Processing chunk ${chunk} microns`);

        let operationCounter = 0;

        while (cut(chunk) >= desiredFinalThickness - 1) {

            operationCounter++;
            chunk = cut(chunk);

        }

        if (operationCounter > 0) {

            console.log(`Cut x${operationCounter}`);
            operationCounter = 0;

            chunk = transportingAndWashing(chunk);
            console.log(`Transporting and washing`);

            if (chunk === desiredFinalThickness) {

                console.log(`Finished crystal ${chunk} microns`);
                continue;

            }

        }

        while (lap(chunk) >= desiredFinalThickness - 1) {

            operationCounter++;
            chunk = lap(chunk);

        }

        if (operationCounter > 0) {

            console.log(`Lap x${operationCounter}`);
            operationCounter = 0;

            chunk = transportingAndWashing(chunk);
            console.log(`Transporting and washing`);

            if (chunk === desiredFinalThickness) {

                console.log(`Finished crystal ${chunk} microns`);
                continue;

            }

        }

        while (grind(chunk) >= desiredFinalThickness - 1) {

            operationCounter++;
            chunk = grind(chunk);

        }

        if (operationCounter > 0) {

            console.log(`Grind x${operationCounter}`);
            operationCounter = 0;

            chunk = transportingAndWashing(chunk);
            console.log(`Transporting and washing`);

            if (chunk === desiredFinalThickness) {

                console.log(`Finished crystal ${chunk} microns`);
                continue;

            }

        }

        while (etch(chunk) >= desiredFinalThickness - 1) {

            operationCounter++;
            chunk = etch(chunk);

        }

        if (operationCounter > 0) {

            console.log(`Etch x${operationCounter}`);
            operationCounter = 0;

            chunk = transportingAndWashing(chunk);
            console.log(`Transporting and washing`);

            if (chunk === desiredFinalThickness) {

                console.log(`Finished crystal ${chunk} microns`);
                continue;

            }

        }

        if (chunk === desiredFinalThickness - 1) {

            operationCounter++;
            chunk = xRay(chunk);
            console.log(`X-ray x${operationCounter}`);

            if (chunk === desiredFinalThickness) {

                console.log(`Finished crystal ${chunk} microns`);

            }

        }

    }

}

// radioCrystals([1375, 50000]);
// radioCrystals([1000, 4000, 8100]);