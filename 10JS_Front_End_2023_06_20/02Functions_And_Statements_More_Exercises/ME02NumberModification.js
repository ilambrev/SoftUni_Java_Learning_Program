function numberModification(number) {

    let modifiedNum = number;
    let numberOfDigits = (number + '').length;

    let calcSumOfDigits = (num => {

        let sumOfDigits = 0;

        while (num != 0) {

            let currentDigit = num % 10;

            sumOfDigits += currentDigit;

            num = Math.floor(num / 10);

        }

        return sumOfDigits;

    });

    let sumOfDigits = calcSumOfDigits(number);

    while ((sumOfDigits / numberOfDigits) <= 5) {

        modifiedNum = Number(modifiedNum + '' + 9);
        sumOfDigits += 9;
        numberOfDigits++;

    }

    console.log(modifiedNum);

}

// numberModification(101);
// numberModification(5835);