function listOfNames(names) {

    let sortedNames = names.sort((name1, name2) => name1.localeCompare(name2));

    for (let i = 1; i <= sortedNames.length; i++) {

        console.log(`${i}.${sortedNames[i - 1]}`);

    }

}

// listOfNames(["John", "Bob", "Christina", "Ema"]);