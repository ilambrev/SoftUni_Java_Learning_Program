function monthPrinter(number) {

    let output = '';

    switch (number) {
        case 1:
            output = 'January';
            break;
        case 2:
            output = 'February';
            break;
        case 3:
            output = 'March';
            break;
        case 4:
            output = 'April';
            break;
        case 5:
            output = 'May';
            break;
        case 6:
            output = 'June';
            break;
        case 7:
            output = 'July';
            break;
        case 8:
            output = 'August';
            break;
        case 9:
            output = 'September';
            break;
        case 10:
            output = 'October';
            break;
        case 11:
            output = 'November';
            break;
        case 12:
            output = 'December';
            break;
        default:
            output = 'Error!';
            break;
    }

    console.log(output);

}

// monthPrinter(2);
// monthPrinter(13);