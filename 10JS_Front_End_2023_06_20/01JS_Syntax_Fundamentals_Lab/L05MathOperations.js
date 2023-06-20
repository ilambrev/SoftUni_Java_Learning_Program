function mathOperations(firstNum, secondNum, operation) {

    let result = 0;

    if (operation === '+') {
        result = firstNum + secondNum;
    } else if (operation === '-') {
        result = firstNum - secondNum;
    } else if (operation === '*') {
        result = firstNum * secondNum;
    } else if (operation === '/') {
        result = firstNum / secondNum;
    } else if (operation === '%') {
        result = firstNum % secondNum;
    } else if (operation === '**') {
        result = firstNum ** secondNum;
    }


    console.log(result);

}

// mathOperations(5, 6, '+');
// mathOperations(3, 5.5, '*');