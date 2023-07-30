function solution() {
    const LIST_ENDPOINT_URL = 'http://localhost:3030/jsonstore/advanced/articles/list';
    const DETAILS_ENDPOINT_URL = 'http://localhost:3030/jsonstore/advanced/articles/details';

    let mainSectionElement = document.querySelector('#main');

    fetch(LIST_ENDPOINT_URL)
        .then(res => res.json())
        .then(body => {

            let accordions = Object.values(body);

            accordions.forEach(a => {

                let title = a.title;
                let id = a._id;

                let accordionDivElement = document.createElement('div');
                accordionDivElement.classList.add('accordion');

                let headDivElement = document.createElement('div');
                headDivElement.classList.add('head');

                let titleSpanElement = document.createElement('span');
                titleSpanElement.textContent = title;

                let moreButton = document.createElement('button');
                moreButton.classList.add('button');
                moreButton.setAttribute('id', id);
                moreButton.textContent = 'More';
                moreButton.addEventListener('click', getAccordionContent);

                headDivElement.appendChild(titleSpanElement);
                headDivElement.appendChild(moreButton);

                accordionDivElement.appendChild(headDivElement);

                mainSectionElement.appendChild(accordionDivElement);
            });
        });

    async function getAccordionContent(e) {

        let button = e.currentTarget;

        if (button.textContent === 'More') {
            let id = e.currentTarget.id;
            let accordion = button.parentElement.parentElement;

            let content = await fetch(`${DETAILS_ENDPOINT_URL}/${id}`)
                .then(res => res.json())
                .then(body => body.content);

            let contentDivElement = document.createElement('div');
            contentDivElement.classList.add('extra');

            let contentParagraphElement = document.createElement('p');
            contentParagraphElement.textContent = content;

            contentDivElement.appendChild(contentParagraphElement);
            contentDivElement.style.display = 'block';

            accordion.appendChild(contentDivElement);

            button.textContent = 'Less';
        } else {
            button.parentElement.parentElement.querySelector('.extra').remove();
            button.textContent = 'More';
        }

    }
}

solution();