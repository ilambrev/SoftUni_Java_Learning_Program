function perfectNumber(number) {

    let sumOfDivisors = 0;

    for (let i = 1; i <= number; i++) {

        if (number % i == 0) {

            sumOfDivisors += i;

        }

    }

    if (number >= 0 && number == sumOfDivisors / 2) {

        console.log("We have a perfect number!");

    } else {

        console.log("It's not so perfect.");

    }

}

// perfectNumber(6);
// perfectNumber(28);
// perfectNumber(1236498);