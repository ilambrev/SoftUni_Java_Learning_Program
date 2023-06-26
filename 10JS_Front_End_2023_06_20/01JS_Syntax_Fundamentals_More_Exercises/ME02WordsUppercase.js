function wordsUppercase(inputString) {

    let words = inputString.toUpperCase().match(/\w+/g);

    if (words !== null) {

        console.log(words.join(', '));

    }

}

// wordsUppercase('Hi, how are you?');
// wordsUppercase('hello');