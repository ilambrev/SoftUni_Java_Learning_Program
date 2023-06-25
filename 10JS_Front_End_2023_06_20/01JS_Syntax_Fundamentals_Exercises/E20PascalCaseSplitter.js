function pascalCaseSpliter(pascalCaseString) {

    let words = [];
    index = 0;

    while (index < pascalCaseString.length) {

        let word = '';

        for (let i = index; i < pascalCaseString.length; i++) {

            let char = pascalCaseString.charAt(i);

            if (i === index || (char.charCodeAt(0) > 96 && char.charCodeAt(0) < 123)) {

                word += char;

            } else {

                index = i;
                words.push(word);
                break;

            }

            if (i === pascalCaseString.length - 1) {

                words.push(word);
                index = pascalCaseString.length;

            }

        }

    }

    console.log(words.join(', '));

}

// pascalCaseSpliter('SplitMeIfYouCanHaHaYouCantOrYouCan');
// pascalCaseSpliter('HoldTheDoor');
// pascalCaseSpliter('ThisIsSoAnnoyingToDo');