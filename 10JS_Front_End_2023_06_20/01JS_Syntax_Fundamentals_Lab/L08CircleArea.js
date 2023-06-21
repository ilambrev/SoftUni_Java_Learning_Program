function circleArea(input) {

    let typeOfInput = typeof input;

    console.log(typeOfInput === 'number' ?
        (Math.PI * Math.pow(Number(input), 2)).toFixed(2) :
        `We can not calculate the circle area, because we receive a ${typeOfInput}.`);

}

// circleArea(5);
// circleArea('name');