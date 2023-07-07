function movies(input) {

    let moviesList = [];

    function movieExists(name, moviesList) {
        return moviesList.filter(movie => movie.name === name).length > 0;
    }

    for (let line of input) {

        let words = line.split(' ');

        let movie = {};

        let name = '';
        let date = '';
        let director = '';

        if (words.includes('addMovie')) {

            name = words.slice(1).join(' ');

            if (!movieExists(name, moviesList)) {

                movie['name'] = name;
                moviesList.push(movie);

            }


        } else if (words.includes('directedBy')) {

            let index = words.indexOf('directedBy');

            name = words.slice(0, index).join(' ');
            director = words.slice(index + 1).join(' ');

            if (movieExists(name, moviesList)) {

                moviesList.filter(movie => movie.name === name)[0]['director'] = director;

            }

        } else if (words.includes('onDate')) {

            let index = words.indexOf('onDate');

            name = words.slice(0, index).join(' ');
            date = words.slice(index + 1).join(' ');

            if (movieExists(name, moviesList)) {

                moviesList.filter(movie => movie.name === name)[0]['date'] = date;

            }

        }

    }

    moviesList.filter(movie => Object.entries(movie).length === 3)
        .map(movie => JSON.stringify(movie))
        .forEach(movie => console.log(movie));

}

/*
movies([
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen'
]);
movies([
    'addMovie The Avengers',
    'addMovie Superman',
    'The Avengers directedBy Anthony Russo',
    'The Avengers onDate 30.07.2010',
    'Captain America onDate 30.07.2010',
    'Captain America directedBy Joe Russo'
]);
*/