function schoolRegister(input) {

    let register = [];

    for (let line of input) {

        let [nameData, gradeData, scoreData] = line.split(', ');
        let name = nameData.split(': ')[1];
        let grade = Number(gradeData.split(': ')[1]);
        let score = Number(scoreData.split(': ')[1]);

        let student = {
            name: name,
            grade: grade + 1,
            score: score
        }

        if (student.score >= 3) {

            register.push(student);

        }

    }

    register.sort((s1, s2) => s1.grade - s2.grade);

    let studentsGroupedByGrade = [];

    for (let i = 1; i <= 12; i++) {

        let gradeGroup = register.filter(s => s.grade === i);

        if (gradeGroup.length > 0) {

            studentsGroupedByGrade.push(gradeGroup);

        }

    }

    studentsGroupedByGrade.forEach(group => {

        console.log(`${group[0].grade} Grade`);
        console.log('List of students: ' + group.map(s => s.name).join(', '));
        console.log('Average annual score from last year: ' +
            (group.map(s => s.score).reduce((accumulator, currentValue) => accumulator + currentValue, 0) / group.length).toFixed(2));
        console.log('');

    });

}

/*
schoolRegister([
    "Student name: Mark, Grade: 8, Graduated with an average score: 4.75",
    "Student name: Ethan, Grade: 9, Graduated with an average score: 5.66",
    "Student name: George, Grade: 8, Graduated with an average score: 2.83",
    "Student name: Steven, Grade: 10, Graduated with an average score: 4.20",
    "Student name: Joey, Grade: 9, Graduated with an average score: 4.90",
    "Student name: Angus, Grade: 11, Graduated with an average score: 2.90",
    "Student name: Bob, Grade: 11, Graduated with an average score: 5.15",
    "Student name: Daryl, Grade: 8, Graduated with an average score: 5.95",
    "Student name: Bill, Grade: 9, Graduated with an average score: 6.00",
    "Student name: Philip, Grade: 10, Graduated with an average score: 5.05",
    "Student name: Peter, Grade: 11, Graduated with an average score: 4.88",
    "Student name: Gavin, Grade: 10, Graduated with an average score: 4.00"
]);
schoolRegister([
    'Student name: George, Grade: 5, Graduated with an average score: 2.75',
    'Student name: Alex, Grade: 9, Graduated with an average score: 3.66',
    'Student name: Peter, Grade: 8, Graduated with an average score: 2.83',
    'Student name: Boby, Grade: 5, Graduated with an average score: 4.20',
    'Student name: John, Grade: 9, Graduated with an average score: 2.90',
    'Student name: Steven, Grade: 2, Graduated with an average score: 4.90',
    'Student name: Darsy, Grade: 1, Graduated with an average score: 5.15'
]);
*/