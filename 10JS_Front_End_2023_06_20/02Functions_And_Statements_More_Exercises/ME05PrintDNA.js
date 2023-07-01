function printDNA(helixLength) {

    const sequence = 'ATCGTTAGGG';
    const template = ['**12**', '*1--2*', '1----2'];

    function getTemplateElementInStraightOrder(template, index) {
        return template[index];
    }

    function getTemplateElementInReverseOrder(template, index) {
        return template[template.length - 1 - index];
    }

    let templateCounter = 0;
    let reverseTemplate = false;
    let loopCounter = 0;


    for (let k = 0; k < Math.ceil(helixLength / (sequence.length / 2)); k++) {

        for (let i = 0; i < (helixLength > (sequence.length / 2) ? sequence.length / 2 : helixLength); i++) {

            if (loopCounter >= helixLength) {

                break;

            }

            if (templateCounter > 2) {

                templateCounter = 1;
                reverseTemplate = !reverseTemplate;

            }

            let s1 = sequence[i * 2];
            let s2 = sequence[i * 2 + 1];

            let currentTemplate = '';

            if (reverseTemplate) {

                currentTemplate = getTemplateElementInReverseOrder(template, templateCounter);

            } else {

                currentTemplate = getTemplateElementInStraightOrder(template, templateCounter);

            }

            currentTemplate = currentTemplate.replace('1', s1);
            currentTemplate = currentTemplate.replace('2', s2);

            console.log(currentTemplate);

            templateCounter++;
            loopCounter++;

        }

    }

}

// printDNA(4);
// printDNA(11);