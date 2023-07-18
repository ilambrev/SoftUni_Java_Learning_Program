function solve() {
  let textToModify = document.querySelector('#text');
  let namingConvention = document.querySelector('#naming-convention');

  let words = textToModify.value.toLowerCase().split(' ');
  let result = '';

  if (namingConvention.value === 'Camel Case') {
    result = words[0] + words.slice(1).map(w => w[0].toUpperCase() + w.slice(1)).join('');
  } else if (namingConvention.value === 'Pascal Case') {
    result = words.map(w => w[0].toUpperCase() + w.slice(1)).join('');
  } else {
    result = 'Error!';
  }

  document.querySelector('#result').textContent = result;
  textToModify.value = '';
  namingConvention.value = '';

}