function search() {
   let towns = Array.from(document.querySelectorAll('#towns li'));
   let textToSearch = document.querySelector('#searchText');

   let matches = 0;

   towns.forEach(t => {
      if (t.style.fontWeight === 'bold') {
         t.style.fontWeight = 'normal';
      }

      if (t.style.textDecoration === 'underline') {
         t.style.textDecoration = 'none';
      }

      if (t.textContent.includes(textToSearch.value)) {
         t.style.fontWeight = 'bold';
         t.style.textDecoration = 'underline';
         matches++;
      }
   });

   document.querySelector('#result').textContent = `${matches} matches found`;
}