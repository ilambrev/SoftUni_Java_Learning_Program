function stringSubstring(wordToFind, text) {

    let wordsInText = text.split(' ');
    let isWordFound = false;

    for (let word of wordsInText) {

        if (word.toLowerCase() === wordToFind.toLowerCase()) {

            isWordFound = true;
            break;

        }
    }

    if (isWordFound) {

        console.log(wordToFind);

    } else {

        console.log(`${wordToFind} not found!`)

    }

}

// stringSubstring('javascript', 'JavaScript is the best programming language');
// stringSubstring('python', 'JavaScript is the best programming language');