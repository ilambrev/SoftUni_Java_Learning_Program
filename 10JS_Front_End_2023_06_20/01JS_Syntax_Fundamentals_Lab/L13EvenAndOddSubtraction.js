function evenAndOddSubstraction(numbers) {

    let sumOfEvens = 0;
    let sumOfOdds = 0;

    for (const number of numbers) {

        number % 2 === 0 ? sumOfEvens += number : sumOfOdds += number;

    }

    console.log(sumOfEvens - sumOfOdds);

}

// evenAndOddSubstraction([1, 2, 3, 4, 5, 6]);
// evenAndOddSubstraction([3, 5, 7, 9]);
// evenAndOddSubstraction([2, 4, 6, 8, 10]);