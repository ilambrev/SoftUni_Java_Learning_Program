function formatGrade(grade) {

    let message = '';

    if (grade < 3.00) {
        message = 'Fail';
    } else if (grade >= 3.00 && grade < 3.50) {
        message = 'Poor';
    } else if (grade >= 3.50 && grade < 4.50) {
        message = 'Good';
    } else if (grade >= 4.50 && grade < 5.50) {
        message = 'Very good';
    } else {
        message = 'Excellent';
    }

    message += grade < 3.00 ? ' (2)' : ` (${grade.toFixed(2)})`;

    console.log(message);

}

// formatGrade(3.33);
// formatGrade(4.50);
// formatGrade(2.99);