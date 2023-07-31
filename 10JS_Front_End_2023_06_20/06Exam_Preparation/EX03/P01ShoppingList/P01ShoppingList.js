function shoppingList(input) {

    let listOfProducts = input[0].split('!');
    let listOfComands = input.slice(1);
    let commandData = listOfComands.shift();

    while (commandData !== 'Go Shopping!') {
        let [command, item, newItem] = commandData.split(' ');

        switch (command) {
            case 'Urgent':

                if (!listOfProducts.includes(item)) {
                    listOfProducts.unshift(item);
                }

                break;
            case 'Unnecessary':

                if (listOfProducts.includes(item)) {
                    listOfProducts.splice(listOfProducts.indexOf(item), 1);
                }

                break;
            case 'Correct':

                if (listOfProducts.includes(item)) {
                    listOfProducts[listOfProducts.indexOf(item)] = newItem;
                }

                break;
            case 'Rearrange':

                if (listOfProducts.includes(item)) {
                    listOfProducts.splice(listOfProducts.indexOf(item), 1);
                    listOfProducts.push(item);
                }

                break;
        }

        commandData = listOfComands.shift();
    }

    console.log(listOfProducts.join(', '));
}

/*
shoppingList([
    "Tomatoes!Potatoes!Bread",
    "Unnecessary Milk",
    "Urgent Tomatoes",
    "Go Shopping!"
]);
shoppingList([
    "Milk!Pepper!Salt!Water!Banana",
    "Urgent Salt",
    "Unnecessary Grapes",
    "Correct Pepper Onion",
    "Rearrange Grapes",
    "Correct Tomatoes Potatoes",
    "Go Shopping!"
]);
*/