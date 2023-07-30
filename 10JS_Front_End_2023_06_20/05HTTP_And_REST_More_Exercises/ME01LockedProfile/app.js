function lockedProfile() {

    let mainElement = document.querySelector('#main');
    let profilesCounter = 0;

    mainElement.innerHTML = '';

    fetch('http://localhost:3030/jsonstore/advanced/profiles')
        .then(res => res.text())
        .then(body => {
            let profilesObjects = Object.values(JSON.parse(body));

            profilesObjects.forEach(p => {

                let username = p.username;
                let email = p.email;
                let age = p.age;
                let id = p._id;

                profilesCounter++;

                let profileDivElement = document.createElement('div');
                profileDivElement.classList.add('profile');

                let imgElement = document.createElement('img');
                imgElement.setAttribute('src', './iconProfile2.png');
                imgElement.classList.add('userIcon');

                let labelLockElement = document.createElement('label');
                labelLockElement.textContent = 'Lock';

                let inputLockElement = document.createElement('input');
                inputLockElement.setAttribute('type', 'radio');
                inputLockElement.setAttribute('name', `user${profilesCounter}Locked`);
                inputLockElement.setAttribute('value', 'lock');
                inputLockElement.setAttribute('checked', '');
                inputLockElement.checked = true;

                let labelUnlockElement = document.createElement('label');
                labelUnlockElement.textContent = 'Unlock';

                let inputUnlockElement = document.createElement('input');
                inputUnlockElement.setAttribute('type', 'radio');
                inputUnlockElement.setAttribute('name', `user${profilesCounter}Locked`);
                inputUnlockElement.setAttribute('value', 'unlock');

                let breakRowElement = document.createElement('br');

                let horizontalRuleElement = document.createElement('hr');

                let labelUsernameElement = document.createElement('label');
                labelUsernameElement.textContent = 'Username';

                let inputUsernameElement = document.createElement('input');
                inputUsernameElement.setAttribute('type', 'text');
                inputUsernameElement.setAttribute('name', `user${profilesCounter}Username`);
                inputUsernameElement.setAttribute('value', username);
                inputUsernameElement.disabled = true;
                inputUsernameElement.readOnly = true;

                let userDataDivElement = document.createElement('div');
                userDataDivElement.classList.add(`user${profilesCounter}HiddenFields`);
                userDataDivElement.style.display = 'none';

                let secondHorizontalRuleElement = document.createElement('hr');

                let labelEmailElement = document.createElement('label');
                labelEmailElement.textContent = 'Email:';

                let inputEmailElement = document.createElement('input');
                inputEmailElement.setAttribute('type', 'email');
                inputEmailElement.setAttribute('name', `user${profilesCounter}Email`);
                inputEmailElement.setAttribute('value', email);
                inputEmailElement.disabled = true;
                inputEmailElement.readOnly = true;

                let labelAgeElement = document.createElement('label');
                labelAgeElement.textContent = 'Age:';

                let inputAgeElement = document.createElement('input');
                inputAgeElement.setAttribute('type', 'email');
                inputAgeElement.setAttribute('name', `user${profilesCounter}Age`);
                inputAgeElement.setAttribute('value', age);
                inputAgeElement.disabled = true;
                inputAgeElement.readOnly = true;

                userDataDivElement.appendChild(secondHorizontalRuleElement);
                userDataDivElement.appendChild(labelEmailElement);
                userDataDivElement.appendChild(inputEmailElement);
                userDataDivElement.appendChild(labelAgeElement);
                userDataDivElement.appendChild(inputAgeElement);

                let buttonShowMoreElement = document.createElement('button');
                buttonShowMoreElement.textContent = 'Show more';

                profileDivElement.appendChild(imgElement);
                profileDivElement.appendChild(labelLockElement);
                profileDivElement.appendChild(inputLockElement);
                profileDivElement.appendChild(labelUnlockElement);
                profileDivElement.appendChild(inputUnlockElement);
                profileDivElement.appendChild(breakRowElement);
                profileDivElement.appendChild(horizontalRuleElement);
                profileDivElement.appendChild(labelUsernameElement);
                profileDivElement.appendChild(inputUsernameElement);
                profileDivElement.appendChild(userDataDivElement);
                profileDivElement.appendChild(buttonShowMoreElement);

                mainElement.appendChild(profileDivElement);
            });

            let profiles = Array.from(document.querySelectorAll('.profile'));

            profiles.forEach(profile => {
                let radioButtons = Array.from(profile.querySelectorAll('input[type="radio"]'));

                radioButtons.forEach(button => button.addEventListener('click', (e) => {

                    let button = e.target.parentElement.querySelector('button');

                    button.addEventListener('click', (e) => {
                        if (e.target.textContent === 'Show more') {
                            e.target.parentElement.querySelector('div').style.display = 'block';
                            e.target.textContent = 'Hide it';
                        } else {
                            e.target.parentElement.querySelector('div').style.display = 'none';
                            e.target.textContent = 'Show more';
                        }
                    });

                }));
            });

        });

}