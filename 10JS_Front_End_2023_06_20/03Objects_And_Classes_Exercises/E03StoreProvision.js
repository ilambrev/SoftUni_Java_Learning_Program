function storeProvision(storeProducts, newProducts) {

    let stock = {};

    for (let i = 0; i < storeProducts.length; i += 2) {

        let productName = storeProducts[i];
        let quantity = Number(storeProducts[i + 1]);

        stock[productName] = quantity;

    }

    for (let i = 0; i < newProducts.length; i += 2) {

        let productName = newProducts[i];
        let quantity = Number(newProducts[i + 1]);

        if (stock.hasOwnProperty(productName)) {

            stock[productName] += quantity;

        } else {

            stock[productName] = quantity;

        }

    }

    Object.entries(stock).forEach(entry => console.log(`${entry[0]} -> ${entry[1]}`));

}

/*
storeProvision(
    ['Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'],
    ['Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30']
);
storeProvision(
    ['Salt', '2', 'Fanta', '4', 'Apple', '14', 'Water', '4', 'Juice', '5'],
    ['Sugar', '44', 'Oil', '12', 'Apple', '7', 'Tomatoes', '7', 'Bananas', '30']
);
*/