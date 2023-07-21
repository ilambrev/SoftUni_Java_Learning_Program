function solve() {
    let sections = Array.from(document.querySelectorAll('section'));
    let answers = Array.from(document.querySelectorAll('.answer-wrap'));
    let result = document.querySelector('#results h1');

    let rightAnswers = {
        'Question #1: Which event occurs when the user clicks on an HTML element?': 'onclick',
        'Question #2: Which function converting JSON to string?': 'JSON.stringify()',
        'Question #3: What is DOM?': 'A programming API for HTML and XML documents'
    }

    let rightAnswersCounter = 0;
    let currentSection = 0;

    answers.forEach(answer => {

        answer.addEventListener('click', (e) => {
            let question = e.currentTarget.parentElement.parentElement.parentElement.querySelector('h2').textContent;
            let answer = e.currentTarget.querySelector('p').textContent;

            console.log(question);

            if (answer === rightAnswers[question]) {
                rightAnswersCounter++;
            }

            e.currentTarget.parentElement.parentElement.parentElement.style.display = 'none';
            currentSection++;

            if (currentSection < 3) {
                sections[currentSection].style.display = 'block';
            } else {
                document.querySelector('#results').style.display = 'block';

                if (rightAnswersCounter === 3) {
                    result.textContent = 'You are recognized as top JavaScript fan!';
                } else {
                    result.textContent = `You have ${rightAnswersCounter} right answers`;
                }
            }
            console.log(currentSection, rightAnswersCounter);
        });

    });

}