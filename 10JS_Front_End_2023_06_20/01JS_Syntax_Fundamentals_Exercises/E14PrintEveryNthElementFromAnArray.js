function printEveryNthElementFromAnArray(arr, step) {

    let resultArr = [];

    for (let i = 0; i < arr.length; i += step) {

        resultArr.push(arr[i]);

    }

    return resultArr;

}

// console.log(printEveryNthElementFromAnArray(['5', '20', '31', '4', '20'], 2));
// console.log(printEveryNthElementFromAnArray(['dsa', 'asd', 'test', 'tset'], 2));
// console.log(printEveryNthElementFromAnArray(['1', '2', '3', '4', '5'], 6));