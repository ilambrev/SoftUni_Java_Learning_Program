function solve() {

  document.querySelector('#exercise button').addEventListener('click', () => {
    let input = JSON.parse(document.querySelector('#exercise textarea').value);

    document.querySelector('#exercise textarea').value = '';

    document.querySelector('input[type="checkbox"]').disabled = false;

    input.forEach(furniture => {

      let tr = document.createElement('tr');

      let imageTd = document.createElement('td');
      let image = document.createElement('img');
      image.src = furniture.img;
      imageTd.appendChild(image);

      let nameTd = document.createElement('td');
      let nameText = document.createElement('p');
      nameText.textContent = furniture.name;
      nameTd.appendChild(nameText);

      let priceTd = document.createElement('td');
      let priceText = document.createElement('p');
      priceText.textContent = furniture.price;
      priceTd.appendChild(priceText);

      let factorTd = document.createElement('td');
      let factorText = document.createElement('p');
      factorText.textContent = furniture.decFactor;
      factorTd.appendChild(factorText);

      let checkboxTd = document.createElement('td');
      let checkbox = document.createElement('input');
      checkbox.type = 'checkbox';
      checkboxTd.appendChild(checkbox);

      tr.appendChild(imageTd);
      tr.appendChild(nameTd);
      tr.appendChild(priceTd);
      tr.appendChild(factorTd);
      tr.appendChild(checkboxTd);

      document.querySelector('tbody').appendChild(tr);

    });
  });

  document.querySelectorAll('#exercise button')[1].addEventListener('click', () => {
    let checkedItems = Array.from(document.querySelectorAll('tbody tr')).filter(tr => tr.querySelector('input[type="checkbox"]').checked === true);

    let result = 'Bought furniture: ' + checkedItems.map(item => item.querySelector('td:nth-child(2) p').textContent).join(', ');

    let totalCost = checkedItems.reduce((acc, curr) => acc + Number(curr.querySelector('td:nth-child(3) p').textContent), 0);

    result += '\nTotal price: ' + totalCost.toFixed(2);

    let averageDecorationFactor = checkedItems.reduce((acc, curr) => acc + Number(curr.querySelector('td:nth-child(4) p').textContent), 0);

    if (checkedItems.length > 0) {
      averageDecorationFactor = averageDecorationFactor / checkedItems.length;
    }

    result += '\nAverage decoration factor: ' + averageDecorationFactor;

    document.querySelectorAll('#exercise textarea')[1].value = result;
  });

}