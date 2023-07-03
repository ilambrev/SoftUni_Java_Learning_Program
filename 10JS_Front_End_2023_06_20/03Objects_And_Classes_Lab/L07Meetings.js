function meetings(inputArr) {

    let schedule = {};

    for (let element of inputArr) {

        let [day, personName] = element.split(' ');

        let message = '';

        if (day in schedule) {

            message = `Conflict on ${day}!`;

        } else {

            schedule[day] = personName;
            message = `Scheduled for ${day}`;

        }

        console.log(message);

    }

    for (let [day, personName] of Object.entries(schedule)) {

        console.log(`${day} -> ${personName}`);

    }

}

// meetings(['Monday Peter', 'Wednesday Bill', 'Monday Tim', 'Friday Tim']);
// meetings(['Friday Bob', 'Saturday Ted', 'Monday Bill', 'Monday John', 'Wednesday George']);