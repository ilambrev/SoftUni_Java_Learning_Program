function attachEvents() {
    let forecast = document.querySelector('#forecast');
    let getWeatherButton = document.querySelector('#submit');

    let weatherSymbols = {
        'Sunny': '&#x2600;',
        'Partly sunny': '&#x26C5;',
        'Overcast': '&#x2601;',
        'Rain': '&#x2614;',
        'Degrees': '&#176;'
    }

    getWeatherButton.addEventListener('click', () => {
        let inputLocation = document.querySelector('#location').value;

        fetch('http://localhost:3030/jsonstore/forecaster/locations')
            .then((res) => res.text())
            .then((body) => {

                let locations = JSON.parse(body);

                let locationCode = locations.filter(o => o.name === inputLocation).map(o => o.code)[0];

                fetch(`http://localhost:3030/jsonstore/forecaster/today/${locationCode}`)
                    .then((res) => res.text())
                    .then((body) => {

                        let locationInfo = JSON.parse(body);
                        let locationName = locationInfo.name;
                        let condition = locationInfo.forecast.condition;
                        let maxTemp = Number(locationInfo.forecast.high);
                        let minTemp = Number(locationInfo.forecast.low);

                        let divForecasts = document.createElement('div');
                        divForecasts.classList.add('forecasts');

                        let spanConditionSymbol = document.createElement('span');
                        spanConditionSymbol.classList.add('condition');
                        spanConditionSymbol.classList.add('symbol');
                        spanConditionSymbol.innerHTML = weatherSymbols[condition];

                        divForecasts.appendChild(spanConditionSymbol);

                        let spanCondition = document.createElement('span');
                        spanCondition.classList.add('condition');

                        let spanLocation = document.createElement('span');
                        spanLocation.classList.add('forecast-data');
                        spanLocation.textContent = locationName;

                        let spanTemperature = document.createElement('span');
                        spanTemperature.classList.add('forecast-data');
                        spanTemperature.innerHTML = minTemp + weatherSymbols['Degrees'] + '/' + maxTemp + weatherSymbols['Degrees'];

                        let spanConditionType = document.createElement('span');
                        spanConditionType.classList.add('forecast-data');
                        spanConditionType.textContent = condition;

                        spanCondition.appendChild(spanLocation);
                        spanCondition.appendChild(spanTemperature);
                        spanCondition.appendChild(spanConditionType);

                        divForecasts.appendChild(spanCondition);

                        document.querySelector('#current').appendChild(divForecasts);
                    })
                    .catch((error) => {
                        let errorDiv = document.createElement('div');
                        errorDiv.textContent = 'Error';

                        forecast.querySelector('#current').appendChild(errorDiv);
                    });

                fetch(`http://localhost:3030/jsonstore/forecaster/upcoming/${locationCode}`)
                    .then((res) => res.text())
                    .then((body) => {

                        let forecasts = JSON.parse(body).forecast;

                        let divForecastInfo = document.createElement('div');
                        divForecastInfo.classList.add('forecast-info');

                        forecasts.forEach(f => {

                            let condition = f.condition;
                            let maxTemp = Number(f.high);
                            let minTemp = Number(f.low);

                            let spanUpcoming = document.createElement('span');
                            spanUpcoming.classList.add('upcoming');

                            let spanUpcomingConditionSymbol = document.createElement('span');
                            spanUpcomingConditionSymbol.classList.add('symbol');
                            spanUpcomingConditionSymbol.innerHTML = weatherSymbols[condition];

                            let spanUpcomingTemperature = document.createElement('span');
                            spanUpcomingTemperature.classList.add('forecast-data');
                            spanUpcomingTemperature.innerHTML = minTemp + weatherSymbols['Degrees'] + '/' + maxTemp + weatherSymbols['Degrees'];

                            let spanCondition = document.createElement('span');
                            spanCondition.classList.add('forecast-data');
                            spanCondition.textContent = condition;

                            spanUpcoming.appendChild(spanUpcomingConditionSymbol);
                            spanUpcoming.appendChild(spanUpcomingTemperature);
                            spanUpcoming.appendChild(spanCondition);

                            divForecastInfo.appendChild(spanUpcoming);
                        });

                        document.querySelector('#upcoming').appendChild(divForecastInfo);
                    })
                    .catch((error) => {
                        let errorDiv = document.createElement('div');
                        errorDiv.textContent = 'Error';

                        forecast.querySelector('#upcoming').appendChild(errorDiv);
                    });
            })
            .catch((error) => {
                let errorDiv = document.createElement('div');
                errorDiv.textContent = 'Error';

                forecast.querySelector('#current').appendChild(errorDiv);
            });

        forecast.style.display = 'block';
    });

}

attachEvents();