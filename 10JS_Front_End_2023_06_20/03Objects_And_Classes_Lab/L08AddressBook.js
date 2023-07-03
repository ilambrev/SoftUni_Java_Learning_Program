function addressBook(inputArr) {

    let addressBookRecords = {};

    for (let element of inputArr) {

        let [name, address] = element.split(':');

        addressBookRecords[name] = address;

    }

    Object.entries(addressBookRecords)
        .sort(([name1, address1], [name2, address2]) => name1.localeCompare(name2))
        .forEach(([name, address]) => console.log(`${name} -> ${address}`));

}

/* 
addressBook([
    'Tim:Doe Crossing',
    'Bill:Nelson Place',
    'Peter:Carlyle Ave',
    'Bill:Ornery Rd'
]);

addressBook([
    'Bob:Huxley Rd',
    'John:Milwaukee Crossing',
    'Peter:Fordem Ave',
    'Bob:Redwing Ave',
    'George:Mesta Crossing',
    'Ted:Gateway Way',
    'Bill:Gateway Way',
    'John:Grover Rd',
    'Peter:Huxley Rd',
    'Jeff:Gateway Way',
    'Jeff:Huxley Rd'
]);
*/