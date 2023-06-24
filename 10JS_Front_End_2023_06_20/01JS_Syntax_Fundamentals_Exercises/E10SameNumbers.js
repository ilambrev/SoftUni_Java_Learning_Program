function sameNumbers(number) {

    let isNumberContainsSameDigits = (number => {

        let areDigitsSame = true;
        let lastDigit = number % 10;

        number = Math.floor(number / 10);

        while (number > 0) {

            let digit = number % 10;

            if (digit !== lastDigit) {

                areDigitsSame = false;
                break;

            }

            number = Math.floor(number / 10);

        }

        return areDigitsSame;

    })

    let sumOfDigits = (number => {

        let sum = 0;

        while (number > 0) {

            sum += number % 10;
            number = Math.floor(number / 10);

        }

        return sum;

    })

    console.log(isNumberContainsSameDigits(number));
    console.log(sumOfDigits(number));

}

// sameNumbers(2222222);
// sameNumbers(1234);