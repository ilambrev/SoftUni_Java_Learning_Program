function towns(input) {

    let townsList = [];

    for (let line of input) {

        let [town, latitude, longitude] = line.split(' | ');

        let townObj = {
            town: town,
            latitude: Number(latitude).toFixed(2),
            longitude: Number(longitude).toFixed(2)
        }

        townsList.push(townObj);

    }

    townsList.forEach(town => console.log(town));

}

// towns(['Sofia | 42.696552 | 23.32601', 'Beijing | 39.913818 | 116.363625']);
// towns(['Plovdiv | 136.45 | 812.575']);