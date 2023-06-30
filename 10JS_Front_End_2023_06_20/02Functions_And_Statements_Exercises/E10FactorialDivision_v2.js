function factorialDivision(firstNum, secondNum) {

    let factorial = (num => {

        if (num == 0) {

            return 1;

        }

        return num * factorial(num - 1);

    });

    console.log((factorial(firstNum) / factorial(secondNum)).toFixed(2));

}

// factorialDivision(5, 2);
// factorialDivision(6, 2);