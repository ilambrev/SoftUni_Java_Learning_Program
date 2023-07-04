function employees(input) {

    let employeesList = [];

    for (let line of input) {

        let employeeName = line;
        let personalNum = line.length;

        let employee = {
            employeeName: employeeName,
            personalNum: personalNum
        };

        employeesList.push(employee);

    }

    employeesList.forEach(emp => console.log(`Name: ${emp.employeeName} -- Personal Number: ${emp.personalNum}`));

}

/*
employees([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
]);
employees([
    'Samuel Jackson',
    'Will Smith',
    'Bruce Willis',
    'Tom Holland'
]);
*/