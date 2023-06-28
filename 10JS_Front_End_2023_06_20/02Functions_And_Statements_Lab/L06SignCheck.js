function signCheck(firstNum, secondNum, thirdNum) {

    let negativeNums = 0

    for (let i = 0; i < 3; i++) {

        if (arguments[i] < 0) {

            negativeNums++;

        }

    }

    console.log(negativeNums % 2 === 0 ? 'Positive' : 'Negative');

}

// signCheck(5, 12, -15);
// signCheck(-6, -12, 14);
// signCheck(-1, -2, -3);