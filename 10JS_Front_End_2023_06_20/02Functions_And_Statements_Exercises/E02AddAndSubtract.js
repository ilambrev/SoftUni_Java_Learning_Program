function addAndSubtract(firstNum, secondNum, thirdNum) {

    let sum = ((num1, num2) => num1 + num2);

    let subtract = ((num1, num2, num3) => sum(num1, num2) - num3);

    console.log(subtract(firstNum, secondNum, thirdNum));

}

// addAndSubtract(23, 6, 10);
// addAndSubtract(1, 17, 30);
// addAndSubtract(42, 58, 100);