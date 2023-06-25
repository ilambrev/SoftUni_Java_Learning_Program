function arrayRotation(numbers, rotations) {

    let realRotations = rotations > numbers.length ? rotations % numbers.length : rotations;
    let resultArr = numbers.slice();

    for (let i = 1; i <= realRotations; i++) {

        resultArr.push(resultArr[0]);
        resultArr.shift();

    }

    console.log(resultArr.join(' '));

}

// arrayRotation([51, 47, 32, 61, 21], 2);
// arrayRotation([32, 21, 61, 1], 4);
// arrayRotation([2, 4, 15, 31], 5);