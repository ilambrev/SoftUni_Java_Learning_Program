function censoredWords(text, censoredWord) {

    let censoredContent = '*'.repeat(censoredWord.length);

    let censoredText = text;

    while (censoredText.includes(censoredWord)) {

        censoredText = censoredText.replace(censoredWord, censoredContent);

    }

    console.log(censoredText);

}

// censoredWords('A small sentence with some words', 'small');
// censoredWords('Find the hidden word', 'hidden');