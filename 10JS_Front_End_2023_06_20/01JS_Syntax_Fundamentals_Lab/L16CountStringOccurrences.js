function countStringOccurrences(text, wordToFind) {

    let counter = 0;

    let wordsInText = text.split(' ');

    for (const word of wordsInText) {

        if (word === wordToFind) {

            counter++;

        }
    }

    console.log(counter);

}

// countStringOccurrences('This is a word and it also is a sentence', 'is');
// countStringOccurrences('softuni is great place for learning new programming languages', 'softuni');