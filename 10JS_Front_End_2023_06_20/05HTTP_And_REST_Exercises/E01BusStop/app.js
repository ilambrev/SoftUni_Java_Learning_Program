function getInfo() {
    let stopId = Number(document.querySelector('#stopId').value);
    let stopName = document.querySelector('#stopName');
    let buses = Array.from(document.querySelectorAll('#buses li'));

    buses.forEach(b => b.remove());
    stopName.textContent = '';

    fetch(`http://localhost:3030/jsonstore/bus/businfo/${stopId}`)
        .then((res) => res.text())
        .then((body) => {
            let stop = JSON.parse(body);
            let name = stop.name;

            stopName.textContent = name;

            Object.entries(stop.buses).map(e => `Bus ${e[0]} arrives in ${e[1]} minutes`)
                .forEach(e => {
                    let li = document.createElement('li');
                    li.textContent = e.trim();

                    document.querySelector('#buses').appendChild(li);
                });

        })
        .catch((error) => stopName.textContent = 'Error');
}