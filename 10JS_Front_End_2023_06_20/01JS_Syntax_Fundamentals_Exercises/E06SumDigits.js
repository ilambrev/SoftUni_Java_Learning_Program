function sumDigits(input) {

    let number = input;
    let sumOfDigits = 0;

    while (number > 0) {

        let digit = number % 10;
        sumOfDigits += digit;
        number = Math.floor(number / 10);

    }

    console.log(sumOfDigits);

}

// sumDigits(245678);
// sumDigits(97561);
// sumDigits(543);