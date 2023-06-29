function oddAndEvenSum(number) {

    let digitsOfNumber = number;
    let sumOfEvenNums = 0;
    let sumOfOddNums = 0;

    while (digitsOfNumber !== 0) {

        let currentDigit = digitsOfNumber % 10;

        currentDigit % 2 === 0 ? sumOfEvenNums += currentDigit : sumOfOddNums += currentDigit;

        digitsOfNumber = Math.floor(digitsOfNumber / 10);

    }

    console.log(`Odd sum = ${sumOfOddNums}, Even sum = ${sumOfEvenNums}`);

}

// oddAndEvenSum(1000435);
// oddAndEvenSum(3495892137259234);