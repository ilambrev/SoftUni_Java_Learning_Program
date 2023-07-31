window.addEventListener('load', solve);

function solve() {
    let allHitsContainer = document.querySelector('#all-hits .all-hits-container');
    let savedHitsContainer = document.querySelector('#saved-hits .saved-container');
    let addSongFormElement = document.querySelector('#append-song form');
    let genreInputElement = document.querySelector('#genre');
    let nameInputElement = document.querySelector('#name');
    let authorInputElement = document.querySelector('#author');
    let dateInputElement = document.querySelector('#date');
    let addButton = document.querySelector('#add-btn');
    let totalLikesElement = document.querySelector('#total-likes .likes p');

    let likesNumber = 0;

    addButton.addEventListener('click', addSong);

    function addSong(e) {
        e.preventDefault();

        let genre = genreInputElement.value;
        let name = nameInputElement.value;
        let author = authorInputElement.value;
        let date = dateInputElement.value;

        if (genre === '' || name === '' || author === '' || date === '') {
            return;
        }

        let newSongDivElement = document.createElement('div');
        newSongDivElement.classList.add('hits-info');

        let imageElement = document.createElement('img');
        imageElement.setAttribute('src', './static/img/img.png');

        let genreHeading = document.createElement('h2');
        genreHeading.textContent = `Genre: ${genre}`;

        let nameHeading = document.createElement('h2');
        nameHeading.textContent = `Name: ${name}`;

        let authorHeading = document.createElement('h2');
        authorHeading.textContent = `Author: ${author}`;

        let dateHeading = document.createElement('h3');
        dateHeading.textContent = `Date: ${date}`;

        let saveButton = document.createElement('button');
        saveButton.classList.add('save-btn');
        saveButton.textContent = 'Save song';
        saveButton.addEventListener('click', saveSong);

        let likeButton = document.createElement('button');
        likeButton.classList.add('like-btn');
        likeButton.textContent = 'Like song';
        likeButton.addEventListener('click', likeSong);

        let deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-btn');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', deleteSong);

        newSongDivElement.appendChild(imageElement);
        newSongDivElement.appendChild(genreHeading);
        newSongDivElement.appendChild(nameHeading);
        newSongDivElement.appendChild(authorHeading);
        newSongDivElement.appendChild(dateHeading);
        newSongDivElement.appendChild(saveButton);
        newSongDivElement.appendChild(likeButton);
        newSongDivElement.appendChild(deleteButton);

        allHitsContainer.appendChild(newSongDivElement);

        addSongFormElement.reset();
    }

    function saveSong(e) {
        let songContainer = e.currentTarget.parentElement;
        let saveButton = songContainer.querySelector('.save-btn');
        let likeButton = songContainer.querySelector('.like-btn');

        saveButton.remove();
        likeButton.remove();

        savedHitsContainer.appendChild(songContainer);

    }

    function likeSong(e) {
        likesNumber++;

        totalLikesElement.textContent = `Total Likes: ${likesNumber}`;

        let likeButton = e.currentTarget.parentElement.querySelector('.like-btn');
        likeButton.disabled = true;

    }

    function deleteSong(e) {
        let songContainer = e.currentTarget.parentElement;

        songContainer.remove();

    }

}