function validate() {
    let r = /^[a-z]+@[a-z]+\.[a-z]+$/gm;
    let emailInput = document.querySelector('input[id="email"]');

    emailInput.addEventListener('change', (e) => {

        let email = emailInput.value;

        if (email.match(r)) {
            emailInput.classList.remove('error');
        } else {
            emailInput.classList.add('error');
        }

    });
}