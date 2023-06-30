function passwordValidator(password) {

    let validateLength = (password => password.length >= 6 && password.length <= 10);

    let validateCharacters = (password => {

        for (let char of password) {

            let value = char.charCodeAt(0);

            if (value < 48 || (value > 57 && value < 65) || (value > 90 && value < 97) || value > 122) {

                return false;

            }

        }

        return true;

    });

    let validateNumberOfDigits = (password => {

        let digitsNumber = 0;

        for (let char of password) {

            let value = char.charCodeAt(0);

            if (value >= 48 && value <= 57) {

                digitsNumber++;

            }

        }

        return digitsNumber >= 2;

    });

    let isValid = true;

    if (!validateLength(password)) {

        console.log('Password must be between 6 and 10 characters');

        isValid = false;

    }

    if (!validateCharacters(password)) {

        console.log('Password must consist only of letters and digits');

        isValid = false;

    }

    if (!validateNumberOfDigits(password)) {

        console.log('Password must have at least 2 digits');

        isValid = false;

    }

    if (isValid) {

        console.log('Password is valid');

    }

}

// passwordValidator('logIn');
// passwordValidator('MyPass123');
// passwordValidator('Pa$s$s');