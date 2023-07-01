function pointsValidation(coordinates) {

    let [x1, y1, x2, y2] = coordinates;
    let result = true;
    let distance = ((x1, y1, x2, y2) => Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));

    result = Number.isInteger(distance(x1, y1, 0, 0));

    console.log(`{${x1}, ${y1}} to {0, 0} is ${result ? 'valid' : 'invalid'}`);

    result = Number.isInteger(distance(x2, y2, 0, 0));

    console.log(`{${x2}, ${y2}} to {0, 0} is ${result ? 'valid' : 'invalid'}`);

    result = Number.isInteger(distance(x1, y1, x2, y2));

    console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${result ? 'valid' : 'invalid'}`);

}

// pointsValidation([3, 0, 0, 4]);
// pointsValidation([2, 1, 1, 1]);