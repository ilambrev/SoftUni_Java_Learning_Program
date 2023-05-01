function cappyJuice(input) {

    let juices = new Map();
    let bottlesOfJuice = new Map();

    for (let line of input) {

        let [juice, quantity] = line.split(' => ');
        quantity = Number(quantity);

        juices.has(juice) ? juices.set(juice, juices.get(juice) + quantity) : juices.set(juice, quantity);

        let bottles = Math.floor(juices.get(juice) / 1000);
        let quantityForBottles = bottles * 1000;

        if (bottles > 0) {

            bottlesOfJuice.has(juice) ? bottlesOfJuice.set(juice, bottlesOfJuice.get(juice) + bottles) : bottlesOfJuice.set(juice, bottles);
            juices.set(juice, juices.get(juice) - quantityForBottles);

        }

    }

    bottlesOfJuice.forEach((value, key) => console.log(`${key} => ${value}`));

}

// cappyJuice(['Orange => 2000', 'Peach => 1432', 'Banana => 450', 'Peach => 600', 'Strawberry => 549']);
// cappyJuice(['Kiwi => 234', 'Pear => 2345', 'Watermelon => 3456', 'Kiwi => 4567', 'Pear => 5678', 'Watermelon => 6789']);