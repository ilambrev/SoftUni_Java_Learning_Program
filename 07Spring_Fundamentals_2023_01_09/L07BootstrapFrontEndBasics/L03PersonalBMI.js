function personalBMI(name, age, weight, height) {

    let personalInfo = {
        age: age,
        weight: weight,
        height: height,
    }

    let BMI = Math.round(weight / Math.pow(height / 100, 2));

    let status = BMI < 18.5 ? 'underweight' : BMI < 25 ? 'normal' : BMI < 30 ? 'overweight' : 'obese';

    let patient = {
        name: name,
        personalInfo: personalInfo,
        BMI: BMI,
        status: status,
    }

    if (status === 'obese') {

        patient.recommendation = 'admission required';

    }

    console.log(patient);

}

// personalBMI("Peter", 29, 75, 182);
// personalBMI("Honey Boo Boo", 9, 57, 137);