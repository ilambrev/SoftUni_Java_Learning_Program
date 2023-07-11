function softUniStudents(input) {

    let courses = {};

    for (let line of input) {

        if (line.includes(':')) {

            let [courseName, capacity] = line.split(': ');
            capacity = Number(capacity);

            if (courses.hasOwnProperty(courseName)) {

                courses[courseName].capacity += capacity;

            } else {

                let newCourse = {
                    name: courseName,
                    capacity: capacity,
                    students: []
                }

                courses[courseName] = newCourse;

            }

        } else {

            let [userData, other] = line.split(' with email ');
            let [userName, creditsCount] = userData.split('[');
            creditsCount = Number(creditsCount.substring(0, creditsCount.length - 1));
            let [email, courseName] = other.split(' joins ');

            if (courses.hasOwnProperty(courseName) && ((courses[courseName].capacity - courses[courseName].students.length) > 0)) {

                let newStudent = {
                    username: userName,
                    email: email,
                    credits: creditsCount
                }

                courses[courseName].students.push(newStudent);

            }

        }

    }

    let sortedCourses = Object.entries(courses).sort((e1, e2) => e2[1].students.length - e1[1].students.length);

    sortedCourses.forEach(e => e[1].students.sort((s1, s2) => s2.credits - s1.credits));

    for (let [name, data] of sortedCourses) {

        console.log(`${name}: ${data.capacity - data.students.length} places left`);
        data.students.forEach(s => console.log(`--- ${s.credits}: ${s.username}, ${s.email}`));

    }

}

/*
softUniStudents([
    'JavaBasics: 2',
    'user1[25] with email user1@user.com joins C#Basics',
    'C#Advanced: 3',
    'JSCore: 4',
    'user2[30] with email user2@user.com joins C#Basics',
    'user13[50] with email user13@user.com joins JSCore',
    'user1[25] with email user1@user.com joins JSCore',
    'user8[18] with email user8@user.com joins C#Advanced',
    'user6[85] with email user6@user.com joins JSCore',
    'JSCore: 2',
    'user11[3] with email user11@user.com joins JavaBasics',
    'user45[105] with email user45@user.com joins JSCore',
    'user007[20] with email user007@user.com joins JSCore',
    'user700[29] with email user700@user.com joins JSCore',
    'user900[88] with email user900@user.com joins JSCore'
]);
softUniStudents([
    'JavaBasics: 15',
    'user1[26] with email user1@user.com joins JavaBasics',
    'user2[36] with email user11@user.com joins JavaBasics',
    'JavaBasics: 5',
    'C#Advanced: 5',
    'user1[26] with email user1@user.com joins C#Advanced',
    'user2[36] with email user11@user.com joins C#Advanced',
    'user3[6] with email user3@user.com joins C#Advanced',
    'C#Advanced: 1',
    'JSCore: 8',
    'user23[62] with email user23@user.com joins JSCore'
]);
*/