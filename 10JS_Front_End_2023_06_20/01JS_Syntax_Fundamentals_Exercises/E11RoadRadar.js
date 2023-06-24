function roadRadar(speed, area) {

    const motorwaySpeedLimit = 130;
    const interstateSpeedLimit = 90;
    const citySpeedLimit = 50;
    const residentialSpeedLimit = 20;
    let speedOverLimit = 0;
    let speedLimit = 0;

    switch (area) {
        case 'motorway':
            speedOverLimit = Math.max(speed - motorwaySpeedLimit, 0);
            speedLimit = motorwaySpeedLimit;
            break;
        case 'interstate':
            speedOverLimit = Math.max(speed - interstateSpeedLimit, 0);
            speedLimit = interstateSpeedLimit;
            break;
        case 'city':
            speedOverLimit = Math.max(speed - citySpeedLimit, 0);
            speedLimit = citySpeedLimit;
            break;
        case 'residential':
            speedOverLimit = Math.max(speed - residentialSpeedLimit, 0);
            speedLimit = residentialSpeedLimit;
            break;
    }

    if (speedOverLimit === 0) {

        console.log(`Driving ${speed} km/h in a ${speedLimit} zone`);

    } else {

        let status = speedOverLimit <= 20 ? 'speeding' : (speedOverLimit <= 40 ? 'excessive speeding' : 'reckless driving');

        console.log(`The speed is ${speedOverLimit} km/h faster than the allowed speed of ${speedLimit} - ${status}`);

    }

}

// roadRadar(40, 'city');
// roadRadar(21, 'residential');
// roadRadar(120, 'interstate');