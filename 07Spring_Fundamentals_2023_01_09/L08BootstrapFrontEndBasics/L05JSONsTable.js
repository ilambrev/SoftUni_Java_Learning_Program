function JSONsTable(input) {

    let employees = [];

    for (let line of input) {

        let employee = JSON.parse(line);

        employees.push(employee);

    }

    let output = '<table>\n';

    for (let employee of employees) {
        output += '    <tr>\n';
        output += `        <td>${employee.name}</td>\n`;
        output += `        <td>${employee.position}</td>\n`;
        output += `        <td>${employee.salary}</td>\n`;
        output += '    </tr>\n';
    }

    output += '</table>';

    console.log(output);

}

// JSONsTable(['{"name":"Pesho","position":"Promenliva","salary":100000}',
//     '{"name":"Teo","position":"Lecturer","salary":1000}',
//     '{"name":"Georgi","position":"Lecturer","salary":1000}']
// );