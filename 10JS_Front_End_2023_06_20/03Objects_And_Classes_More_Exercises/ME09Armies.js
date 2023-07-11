function armies(input) {

    let leaders = {};

    for (let line of input) {

        if (line.includes('arrives')) {

            let leaderName = line.substring(0, line.indexOf('arrives')).trim();

            leaders[leaderName] = [];

        } else if (line.includes(':')) {

            let [leaderName, armyData] = line.split(': ');
            let [armyName, armyCount] = armyData.split(', ');

            armyCount = Number(armyCount);

            if (leaders.hasOwnProperty(leaderName)) {

                let newArmy = {
                    armyName: armyName,
                    armyCount: armyCount
                }

                leaders[leaderName].push(newArmy);

            }

        } else if (line.includes('+')) {

            let [armyName, armyCount] = line.split(' + ');

            armyCount = Number(armyCount);

            for (let value of Object.values(leaders)) {

                if (value.filter(a => a.armyName === armyName).length > 0) {

                    value.filter(a => a.armyName === armyName)[0].armyCount += armyCount;
                    break;

                }

            }

        } else if (line.includes('defeated')) {

            let leaderName = line.substring(0, line.indexOf('defeated')).trim();

            delete leaders[leaderName];

        }

    }

    let sortedLeaders = Object.entries(leaders)
        .sort((e1, e2) => e2[1].reduce((sum, current) => sum + current.armyCount, 0) - e1[1].reduce((sum, current) => sum + current.armyCount, 0));

    sortedLeaders.forEach(e => e[1].sort((a1, a2) => a2.armyCount - a1.armyCount));

    sortedLeaders.forEach(l => console.log(`${l[0]}: ${l[1].reduce((sum, current) => sum + current.armyCount, 0)}\n${l[1].map(a => '>>> ' + a.armyName + ' - ' + a.armyCount).join('\n')}`));

}

/*
armies([
    'Rick Burr arrives',
    'Fergus: Wexamp, 30245',
    'Rick Burr: Juard, 50000',
    'Findlay arrives',
    'Findlay: Britox, 34540',
    'Wexamp + 6000',
    'Juard + 1350',
    'Britox + 4500',
    'Porter arrives',
    'Porter: Legion, 55000',
    'Legion + 302',
    'Rick Burr defeated',
    'Porter: Retix, 3205'
]);
armies([
    'Rick Burr arrives',
    'Findlay arrives',
    'Rick Burr: Juard, 1500',
    'Wexamp arrives',
    'Findlay: Wexamp, 34540',
    'Wexamp + 340',
    'Wexamp: Britox, 1155',
    'Wexamp: Juard, 43423'
]);
*/