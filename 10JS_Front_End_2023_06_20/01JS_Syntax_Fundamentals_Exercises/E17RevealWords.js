function revealWords(wordsString, textWithTemplates) {

    let words = wordsString.split(', ');
    let finalText = textWithTemplates.split(' ');

    for (let word of words) {

        let template = '*'.repeat(word.length);

        while (finalText.includes(template)) {

            let indexOfTemplate = finalText.indexOf(template);
            finalText[indexOfTemplate] = word;

        }

    }

    console.log(finalText.join(' '));

}

// revealWords('great', 'softuni is ***** place for learning new programming languages');
// revealWords('great, learning', 'softuni is ***** place for ******** new programming languages');