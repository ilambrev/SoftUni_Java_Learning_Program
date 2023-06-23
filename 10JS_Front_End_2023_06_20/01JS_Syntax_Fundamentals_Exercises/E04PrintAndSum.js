function printAndSum(startNum, endNum) {

    let numbers = '';
    let numbersSum = 0;

    for (let i = startNum; i <= endNum; i++) {

        numbers += i < endNum ? i + ' ' : i;
        numbersSum += i;

    }

    console.log(numbers);
    console.log(`Sum: ${numbersSum}`);

}

// printAndSum(5, 10);
// printAndSum(0, 26);
// printAndSum(50, 60);