function login(inputString) {

    let username = inputString[0];
    let passwords = inputString.slice(1);

    for (let i = 0; i < passwords.length; i++) {

        if (username.split('').reverse().join('') === passwords[i]) {

            console.log(`User ${username} logged in.`);
            break;

        }

        if (i === 3) {

            console.log(`User ${username} blocked!`);
            break;

        } else {

            console.log('Incorrect password. Try again.');

        }

    }

}

// login(['Acer', 'login', 'go', 'let me in', 'recA']);
// login(['momo', 'omom']);
// login(['sunny', 'rainy', 'cloudy', 'sunny', 'not sunny']);