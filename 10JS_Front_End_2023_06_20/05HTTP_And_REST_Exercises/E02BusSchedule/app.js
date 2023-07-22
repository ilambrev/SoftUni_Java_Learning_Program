function solve() {
    let message = document.querySelector('#info span');
    let departButton = document.querySelector('#depart');
    let arriveButton = document.querySelector('#arrive');
    let stopId = 'depot';
    let stopName = '';

    function depart() {


        fetch(`http://localhost:3030/jsonstore/bus/schedule/${stopId}`)
            .then((res) => res.text())
            .then((body) => {

                let stopInfo = JSON.parse(body);

                stopId = stopInfo.next;
                stopName = stopInfo.name;

                message.textContent = `Next stop ${stopName}`;
                departButton.disabled = true;
                arriveButton.disabled = false;

            })
            .catch((error) => {
                message.textContent = 'Error';
                departButton.disabled = true;
                arriveButton.disabled = true;
            });
    }

    async function arrive() {
        message.textContent = `Arriving at ${stopName}`;
        departButton.disabled = false;
        arriveButton.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();