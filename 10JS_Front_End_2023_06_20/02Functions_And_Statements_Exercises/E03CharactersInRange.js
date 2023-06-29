function charactersInRange(firstSymbol, secondSymbol) {

    let beginSymbol = Math.min(firstSymbol.charCodeAt(0), secondSymbol.charCodeAt(0)) + 1;
    let endSymbol = Math.max(firstSymbol.charCodeAt(0), secondSymbol.charCodeAt(0));
    let result = '';


    for (let i = beginSymbol; i < endSymbol; i++) {

        result += String.fromCharCode(i);

        if (i < endSymbol - 1) {

            result += ' ';

        }

    }

    console.log(result);

}

// charactersInRange('a', 'd');
// charactersInRange('#', ':');
// charactersInRange('C', '#');