function smallestOfThreeNumbers(firstNum, secondNum, thirdNum) {

    console.log(secondNum < firstNum ? thirdNum < secondNum ? thirdNum : secondNum : firstNum < thirdNum ? firstNum : thirdNum);

}

// smallestOfThreeNumbers(2, 5, 3);
// smallestOfThreeNumbers(600, 342, 123);
// smallestOfThreeNumbers(25, 21, 4);
// smallestOfThreeNumbers(2, 2, 2);