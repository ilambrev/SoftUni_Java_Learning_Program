function vacation(groupSize, groupType, dayOfWeek) {

    let pricePerPerson = 0;
    let personsNumber = groupSize;
    let discount = 0;

    switch (groupType) {
        case 'Students':

            if (dayOfWeek === 'Friday') {
                pricePerPerson = 8.45;
            } else if (dayOfWeek == 'Saturday') {
                pricePerPerson = 9.80;
            } else if (dayOfWeek == 'Sunday') {
                pricePerPerson = 10.46;
            }

            discount = groupSize >= 30 ? 0.15 : 0;

            break;
        case 'Business':

            if (dayOfWeek === 'Friday') {
                pricePerPerson = 10.90;
            } else if (dayOfWeek == 'Saturday') {
                pricePerPerson = 15.60;
            } else if (dayOfWeek == 'Sunday') {
                pricePerPerson = 16.00;
            }

            personsNumber = groupSize >= 100 ? groupSize - 10 : groupSize;;

            break;
        case 'Regular':

            if (dayOfWeek === 'Friday') {
                pricePerPerson = 15.00;
            } else if (dayOfWeek == 'Saturday') {
                pricePerPerson = 20.00;
            } else if (dayOfWeek == 'Sunday') {
                pricePerPerson = 22.50;
            }

            discount = groupSize >= 10 && groupSize <= 20 ? 0.05 : 0;

            break;
    }

    let totalPrice = personsNumber * pricePerPerson;
    totalPrice -= totalPrice * discount;

    console.log(`Total price: ${totalPrice.toFixed(2)}`);

}

// vacation(30, "Students", "Sunday");
// vacation(40, "Regular", "Saturday");