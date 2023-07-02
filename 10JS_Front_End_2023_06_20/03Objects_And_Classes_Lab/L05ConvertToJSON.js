function convertToJSON(name, lastName, hairColor) {

    let person = {
        name: name,
        lastName: lastName,
        hairColor: hairColor
    }

    let jsonString = JSON.stringify(person);

    console.log(jsonString);

}

// convertToJSON('George', 'Jones', 'Brown');
// convertToJSON('Peter', 'Smith', 'Blond');