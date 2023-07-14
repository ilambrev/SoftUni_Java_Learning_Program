function create(words) {
   words.forEach(w => {
      let newParagraph = document.createElement('p');
      newParagraph.textContent = w;
      newParagraph.style.display = 'none';

      let newElement = document.createElement('div');
      newElement.appendChild(newParagraph);

      newElement.addEventListener('click', (e) => {
         e.target.querySelector('p').style.display = 'block';
      })

      document.querySelector('#content').appendChild(newElement);
   });
}