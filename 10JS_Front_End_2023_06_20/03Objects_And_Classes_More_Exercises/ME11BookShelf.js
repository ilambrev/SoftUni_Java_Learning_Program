function bookShelf(input) {

    let shelves = {};

    for (let line of input) {

        if (line.includes('->')) {

            let [id, genre] = line.split(' -> ');

            id = Number(id);

            if (!shelves.hasOwnProperty(id)) {

                let newShelf = {
                    id: id,
                    genre: genre,
                    books: []
                }

                shelves[id] = newShelf;

            }

        } else {

            let [title, rest] = line.split(': ');
            let [author, genre] = rest.split(', ');

            if (Object.entries(shelves).filter(e => e[1].genre === genre).length > 0) {

                let selfId = Object.entries(shelves).filter(e => e[1].genre === genre)[0][0];

                let newBook = {
                    title: title,
                    author: author,
                    genre: genre
                }

                shelves[selfId].books.push(newBook);

            }

        }

    }

    let sortedShelves = Object.entries(shelves).sort((e1, e2) => e2[1].books.length - e1[1].books.length);

    sortedShelves.forEach(e => e[1].books.sort((b1, b2) => b1.title.localeCompare(b2.title)));

    sortedShelves.forEach(e => console.log(`${e[0]} ${e[1].genre}: ${e[1].books.length}\n${e[1].books.map(b => '--> ' + b.title + ': ' + b.author).join('\n')}`));

}

/*
bookShelf([
    '1 -> history',
    '1 -> action',
    'Death in Time: Criss Bell, mystery',
    '2 -> mystery',
    '3 -> sci-fi',
    'Child of Silver: Bruce Rich, mystery',
    'Hurting Secrets: Dustin Bolt, action',
    'Future of Dawn: Aiden Rose, sci-fi',
    'Lions and Rats: Gabe Roads, history',
    '2 -> romance',
    'Effect of the Void: Shay B, romance',
    'Losing Dreams: Gail Starr, sci-fi',
    'Name of Earth: Jo Bell, sci-fi',
    'Pilots of Stone: Brook Jay, history'
]);
bookShelf([
    '1 -> mystery',
    '2 -> sci-fi',
    'Child of Silver: Bruce Rich, mystery',
    'Lions and Rats: Gabe Roads, history',
    'Effect of the Void: Shay B, romance',
    'Losing Dreams: Gail Starr, sci-fi',
    'Name of Earth: Jo Bell, sci-fi'
]);
*/