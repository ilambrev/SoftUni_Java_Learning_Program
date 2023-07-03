function songs(inputArr) {

    let songsList = [];

    class Song {
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    for (let i = 1; i <= inputArr[0]; i++) {

        let [typeList, name, time] = inputArr[i].split('_');

        songsList.push(new Song(typeList, name, time));

    }

    if (inputArr[inputArr.length - 1] === 'all') {

        songsList.forEach(song => console.log(song.name));

    } else {

        songsList.filter(song => song.typeList === inputArr[inputArr.length - 1])
            .forEach(song => console.log(song.name));

    }

}

/*
songs([
    3,
    'favourite_DownTown_3:14',
    'favourite_Kiss_4:16',
    'favourite_Smooth Criminal_4:01',
    'favourite'
]);
songs([
    4,
    'favourite_DownTown_3:14',
    'listenLater_Andalouse_3:24',
    'favourite_In To The Night_3:58',
    'favourite_Live It Up_3:48',
    'listenLater'
]);
songs([
    2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all'
]);
*/