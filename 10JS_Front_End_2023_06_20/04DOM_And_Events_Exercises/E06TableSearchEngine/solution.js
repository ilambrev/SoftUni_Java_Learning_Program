function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      let wordToFind = document.querySelector('#searchField').value;

      if (wordToFind !== '') {
         let rows = Array.from(document.querySelectorAll('tbody tr'));

         rows.forEach(row => row.classList.remove('select'));

         rows.forEach(row => {

            let cells = Array.from(row.querySelectorAll('td'));

            for (let cell of cells) {
               if (cell.textContent.includes(wordToFind)) {
                  cell.parentElement.classList.add('select');
                  break;
               }
            }
         });

         document.querySelector('#searchField').value = '';
      }
   }
}