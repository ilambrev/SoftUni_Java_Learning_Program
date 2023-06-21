function largestNumber(firstNum, secondNum, thirdNum) {

    let result = secondNum > firstNum ? (secondNum > thirdNum ? secondNum : thirdNum) : (thirdNum > firstNum ? thirdNum : firstNum);

    console.log(`The largest number is ${result}.`);

}

// largestNumber(5, -3, 16);
// largestNumber(-3, -5, -22.5);