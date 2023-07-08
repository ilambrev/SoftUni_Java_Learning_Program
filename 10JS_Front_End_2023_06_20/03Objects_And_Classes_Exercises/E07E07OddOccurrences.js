function oddOccurrences(input) {

    let words = input.split(' ').map(w => w.toLowerCase());
    let wordsOccurrence = [];

    for (let word of words) {

        let wordOccurrence = wordsOccurrence.filter(w => w.word === word);

        if (wordOccurrence.length > 0) {

            let index = wordsOccurrence.indexOf(wordOccurrence[0]);

            wordsOccurrence[index].numOfOccurrence += 1;

        } else {

            let newWord = {
                word: word,
                numOfOccurrence: 1
            }

            wordsOccurrence.push(newWord);

        }

    }

    console.log(wordsOccurrence
        .filter(w => w.numOfOccurrence % 2 !== 0)
        .map(w => w.word)
        .join(' '));

}

// oddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
// oddOccurrences('Cake IS SWEET is Soft CAKE sweet Food');