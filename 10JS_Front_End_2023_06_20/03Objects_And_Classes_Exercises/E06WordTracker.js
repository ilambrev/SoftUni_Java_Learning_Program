function wordTracker(input) {

    let wordsOccurrence = {};

    let words = input[0].split(' ');
    let sentenceWords = input.slice(1);

    for (let word of words) {

        wordsOccurrence[word] = sentenceWords.filter(w => w === word).length;

    }

    Object.entries(wordsOccurrence)
        .sort(([word1, count1], [word2, count2]) => count2 - count1)
        .forEach(w => console.log(`${w[0]} - ${w[1]}`));

}

/*
wordTracker([
    'this sentence',
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
]);
wordTracker([
    'is the',
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence'
]);
*/