function sortArray(arr, orderType) {

    let sortedArr = arr.slice();

    switch (orderType) {
        case 'asc':
            sortedArr.sort((n1, n2) => n1 - n2);
            break;
        case 'desc':
            sortedArr.sort((n1, n2) => n2 - n1);
            break;
    }

    console.log(sortedArr);

}

// sortArray([14, 7, 17, 6, 8], 'asc');
// sortArray([14, 7, 17, 6, 8], 'desc');