function revealWords(wordsString, textWithTemplates) {

    let words = wordsString.split(', ').sort((w1, w2) => w2.length - w1.length);
    let finalText = textWithTemplates;

    for (let word of words) {

        let template = '*'.repeat(word.length);

        while (finalText.includes(template)) {

            finalText = finalText.replace(template, word);

        }

    }

    console.log(finalText);

}

// revealWords('great', 'softuni is ***** place for learning new programming languages');
// revealWords('great, learning', 'softuni is ***** place for ******** new programming languages');