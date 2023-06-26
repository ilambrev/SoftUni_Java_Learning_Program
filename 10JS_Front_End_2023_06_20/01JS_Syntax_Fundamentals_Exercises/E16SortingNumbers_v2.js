function sortingNumbers(numbers) {

    let sortedNumbers = numbers.sort((n1, n2) => n1 - n2);
    let resultArr = [];

    for (let i = 0; i < sortedNumbers.length; i++) {

        if (i % 2 === 0) {

            resultArr.push(sortedNumbers[i / 2]);

        } else {

            resultArr.push(sortedNumbers[sortedNumbers.length - ((i + 1) / 2)]);

        }

    }

    return resultArr;

}

// console.log(sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));