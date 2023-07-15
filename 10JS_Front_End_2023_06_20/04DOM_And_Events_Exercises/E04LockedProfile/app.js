function lockedProfile() {
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
}