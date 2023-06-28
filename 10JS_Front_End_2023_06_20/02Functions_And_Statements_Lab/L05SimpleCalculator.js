function simpleCalculator(firstNum, secondNum, operation) {

    let operations = {
        'multiply': ((firstNum, secondNum) => firstNum * secondNum),
        'divide': ((firstNum, secondNum) => firstNum / secondNum),
        'add': ((firstNum, secondNum) => firstNum + secondNum),
        'subtract': ((firstNum, secondNum) => firstNum - secondNum),
    }

    console.log(operations[operation](firstNum, secondNum));

}

// simpleCalculator(5, 5, 'multiply');
// simpleCalculator(40, 8, 'divide');
// simpleCalculator(12, 19, 'add');
// simpleCalculator(50, 13, 'subtract');