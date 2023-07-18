function solve() {
   let products = Array.from(document.querySelectorAll('.product'));
   let checkoutButton = document.querySelector('.checkout');
   let textArea = document.querySelector('textarea');

   textArea.value = '';

   let productsNames = [];
   let totalSum = 0;

   products.forEach(p => {
      p.querySelector('.add-product').addEventListener('click', (e) => {
         let name = p.querySelector('.product-title').textContent;

         if (!productsNames.includes(name)) {
            productsNames.push(name);
         }

         let price = Number(p.querySelector('.product-line-price').textContent);
         totalSum += price;
         textArea.value += `Added ${name} for ${price.toFixed(2)} to the cart.\n`;
      });
   });

   checkoutButton.addEventListener('click', () => {
      document.querySelector('textarea').value += `You bought ${productsNames.join(', ')} for ${totalSum.toFixed(2)}.`;
      products.forEach(p => p.querySelector('.add-product').disabled = true);
      checkoutButton.disabled = true;
   });

}