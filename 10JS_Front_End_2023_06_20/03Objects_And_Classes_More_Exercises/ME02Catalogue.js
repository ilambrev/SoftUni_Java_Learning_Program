function catalogue(input) {

    let productsCatalogue = [];

    for (let line of input) {

        let [productName, productPrice] = line.split(' : ');

        productPrice = Number(productPrice);

        let product = {
            name: productName,
            price: productPrice
        }

        productsCatalogue.push(product);

    }

    productsCatalogue.sort((p1, p2) => p1.name.localeCompare(p2.name));

    let letter = '';

    for (let product of productsCatalogue) {

        let productFirstLetter = product.name[0];

        if (productFirstLetter !== letter) {

            letter = productFirstLetter;
            console.log(letter);

        }

        console.log(`  ${product.name}: ${product.price}`);

    }

}

/*
catalogue([
    'Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10'
]);

catalogue([
    'Omlet : 5.4',
    'Shirt : 15',
    'Cake : 59'
]);
*/