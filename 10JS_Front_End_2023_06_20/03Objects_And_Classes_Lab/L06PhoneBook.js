function phoneBook(persons) {

    let phoneBookRecords = {};

    for (let personData of persons) {

        let [name, phone] = personData.split(' ');

        phoneBookRecords[name] = phone;

    }

    for (let [name, phone] of Object.entries(phoneBookRecords)) {
        console.log(`${name} -> ${phone}`);
    }
}

// phoneBook(['Tim 0834212554', 'Peter 0877547887', 'Bill 0896543112', 'Tim 0876566344']);
// phoneBook(['George 0552554', 'Peter 087587', 'George 0453112', 'Bill 0845344']);