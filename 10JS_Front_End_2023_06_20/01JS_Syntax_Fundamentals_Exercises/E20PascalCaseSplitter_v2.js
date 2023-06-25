function pascalCaseSpliter(pascalCaseString) {

    const re = /[A-Z]{1}[a-z]*/g;
    let words = [...pascalCaseString.matchAll(re)];

    console.log(words.join(', '));

}

// pascalCaseSpliter('SplitMeIfYouCanHaHaYouCantOrYouCan');
// pascalCaseSpliter('HoldTheDoor');
// pascalCaseSpliter('ThisIsSoAnnoyingToDo');