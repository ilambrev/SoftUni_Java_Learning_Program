function modernTimesOfHashTag(text) {

    let words = text.split(' ');

    for (let word of words) {

        if (word.startsWith('#') && word.length > 1) {

            let isWordSpecial = true;

            for (let i = 1; i < word.length; i++) {

                let symbolCode = word.charCodeAt(i);

                if (symbolCode < 65 || (symbolCode > 90 && symbolCode < 97) || symbolCode > 122) {

                    isWordSpecial = false;
                    break;

                }

            }

            if (isWordSpecial) {

                console.log(word.substring(1));

            }

        }

    }

}

// modernTimesOfHashTag('Nowadays everyone uses # to tag a #special word in #socialMedia');
// modernTimesOfHashTag('The symbol # is known #variously in English-speaking #regions as the #number sign');