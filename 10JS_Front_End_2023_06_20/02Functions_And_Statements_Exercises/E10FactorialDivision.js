function factorialDivision(firstNum, secondNum) {

    let factorial = (num => {

        let result = 1;

        for (let i = num; i >= 1; i--) {

            result *= i;

        }

        return result;

    });

    console.log((factorial(firstNum) / factorial(secondNum)).toFixed(2));

}

// factorialDivision(5, 2);
// factorialDivision(6, 2);