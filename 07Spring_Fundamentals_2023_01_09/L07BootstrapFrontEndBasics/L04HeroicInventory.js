function heroicInventory(input) {

    let heroes = [];

    for (let line of input) {

        let heroData = line.split(' / ');
        let name = heroData[0];
        let level = Number(heroData[1]);

        let hero = {
            name: name,
            level: level,
        }

        if (heroData.length > 2) {

            let items = heroData[2].split(', ');

            hero.items = items;

        }

        heroes.push(hero);

    }

    console.log(JSON.stringify(heroes));

}

// heroicInventory(['Isacc / 25 / Apple, GravityGun',
//     'Derek / 12 / BarrelVest, DestructionSword',
//     'Hes / 1 / Desolator, Sentinel, Antara'
// ]);
// heroicInventory(['Jake / 1000 / Gauss, HolidayGrenade']);