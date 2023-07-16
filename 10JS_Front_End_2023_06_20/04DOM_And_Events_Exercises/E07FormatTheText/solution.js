function solve() {
  let sentences = document.querySelector('#input').value.split('.').filter(s => s.length >= 1);

  for (let i = 0; i < sentences.length; i += 3) {

    let numberOfSentences = sentences.length >= i + 3 ? 3 : sentences.length - i;

    let paragraphContent = sentences.slice(i, i + numberOfSentences + 1).join('. ') + '.';

    let newParagraph = document.createElement('p');
    newParagraph.textContent = paragraphContent;

    document.querySelector('#output').appendChild(newParagraph);

  }

}