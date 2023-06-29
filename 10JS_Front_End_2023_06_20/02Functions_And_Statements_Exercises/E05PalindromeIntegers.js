function palindromeIntegers(numbers) {

    let reverseNumber = (number => {

        let reversedNumber = '';

        while (number !== 0) {

            let lastDigit = number % 10;

            reversedNumber += lastDigit;

            number = Math.floor(number / 10);

        }

        return reversedNumber;

    });

    for (let num of numbers) {

        console.log(reverseNumber(num) == num ? 'true' : 'false');

    }

}

// palindromeIntegers([123, 323, 421, 121]);
// palindromeIntegers([32, 2, 232, 1010]);