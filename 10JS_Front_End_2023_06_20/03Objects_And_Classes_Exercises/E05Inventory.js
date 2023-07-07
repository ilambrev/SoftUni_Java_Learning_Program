function inventory(input) {

    let heroes = [];

    for (let line of input) {

        let hero = {};

        let [heroName, heroLevel, itemsString] = line.split(' / ');

        hero['heroName'] = heroName;
        hero['heroLevel'] = Number(heroLevel);
        hero['items'] = itemsString === undefined ? [] : itemsString.split(', ');

        heroes.push(hero);

    }

    heroes.sort((hero1, hero2) => hero1.heroLevel - hero2.heroLevel)
        .forEach(hero => console.log(`Hero: ${hero.heroName}\nlevel => ${hero.heroLevel}\nitems => ${hero.items.join(', ')}`));

}

/*
inventory([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
]);
inventory([
    'Batman / 2 / Banana, Gun',
    'Superman / 18 / Sword',
    'Poppy / 28 / Sentinel, Antara'
]);
*/