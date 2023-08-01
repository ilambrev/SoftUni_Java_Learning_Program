function thePianist(input) {

    let piecesNumber = Number(input[0]);
    let piecesData = input.slice(1, piecesNumber + 1);
    let commandsData = input.slice(piecesNumber + 1);
    let command = commandsData.shift();

    let pieces = [];

    for (let line of piecesData) {
        let [piece, composer, key] = line.split('|');

        pieces.push({ piece, composer, key });
    }

    while (command !== 'Stop') {
        let [commandName, piece, ...others] = command.split('|');

        switch (commandName) {
            case 'Add':

                if (pieces.filter(p => p.piece === piece).length === 0) {
                    let composer = others[0];
                    let key = others[1];

                    pieces.push({ piece, composer, key });
                    console.log(`${piece} by ${composer} in ${key} added to the collection!`);
                } else {
                    console.log(`${piece} is already in the collection!`);
                }

                break;
            case 'Remove':

                if (pieces.filter(p => p.piece === piece).length > 0) {
                    let index = pieces.map(p => p.piece).indexOf(piece);

                    pieces.splice(index, 1);

                    console.log(`Successfully removed ${piece}!`);
                } else {
                    console.log(`Invalid operation! ${piece} does not exist in the collection.`);
                }

                break;
            case 'ChangeKey':

                let newKey = others[0];

                if (pieces.filter(p => p.piece === piece).length > 0) {
                    let index = pieces.map(p => p.piece).indexOf(piece);

                    pieces[index].key = newKey;

                    console.log(`Changed the key of ${piece} to ${newKey}!`);
                } else {
                    console.log(`Invalid operation! ${piece} does not exist in the collection.`);
                }

                break;
        }


        command = commandsData.shift();
    }

    pieces.forEach(p => console.log(`${p.piece} -> Composer: ${p.composer}, Key: ${p.key}`));

}

/*
thePianist([
    '3',
    'Fur Elise|Beethoven|A Minor',
    'Moonlight Sonata|Beethoven|C# Minor',
    'Clair de Lune|Debussy|C# Minor',
    'Add|Sonata No.2|Chopin|B Minor',
    'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
    'Add|Fur Elise|Beethoven|C# Minor',
    'Remove|Clair de Lune',
    'ChangeKey|Moonlight Sonata|C# Major',
    'Stop'
]);
thePianist([
    '4',
    'Eine kleine Nachtmusik|Mozart|G Major',
    'La Campanella|Liszt|G# Minor',
    'The Marriage of Figaro|Mozart|G Major',
    'Hungarian Dance No.5|Brahms|G Minor',
    'Add|Spring|Vivaldi|E Major',
    'Remove|The Marriage of Figaro',
    'Remove|Turkish March',
    'ChangeKey|Spring|C Major',
    'Add|Nocturne|Chopin|C# Minor',
    'Stop'
]);
*/