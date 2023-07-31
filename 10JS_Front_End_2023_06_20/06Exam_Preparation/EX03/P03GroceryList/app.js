function solve() {
    const ENDPOINT_URL = 'http://localhost:3030/jsonstore/grocery';

    let addProductButton = document.querySelector('#add-product');
    let updateProductButton = document.querySelector('#update-product');
    let loadProductsButton = document.querySelector('#load-product');

    let table = document.querySelector('#table .tbl-header table');
    let tableData = document.querySelector('#tbody');
    let addProductsForm = document.querySelector('#addForm form');
    let productNameInput = document.querySelector('#product');
    let productCountInput = document.querySelector('#count');
    let productPriceInput = document.querySelector('#price');

    let editedProductId = '';

    addProductButton.addEventListener('click', addProduct);
    updateProductButton.addEventListener('click', saveUpdatedProduct);
    loadProductsButton.addEventListener('click', (e) => {
        e.preventDefault();
        loadAllProducts();
    });

    async function loadAllProducts() {

        tableData.innerHTML = '';

        await fetch(ENDPOINT_URL)
            .then(res => res.text())
            .then(body => {

                let products = Object.values(JSON.parse(body));

                products.forEach(p => {

                    let name = p.product;
                    let count = Number(p.count);
                    let price = Number(p.price);
                    let id = p._id;

                    let rowElement = document.createElement('tr');
                    rowElement.setAttribute('data-id', id);

                    let nameCellElement = document.createElement('td');
                    nameCellElement.classList.add('name');
                    nameCellElement.textContent = name;

                    let countCellElement = document.createElement('td');
                    countCellElement.classList.add('count-product');
                    countCellElement.textContent = count;

                    let priceCellElement = document.createElement('td');
                    priceCellElement.classList.add('product-price');
                    priceCellElement.textContent = price;

                    let buttonsCellElement = document.createElement('td');
                    buttonsCellElement.classList.add('btn');

                    let updateButton = document.createElement('button');
                    updateButton.classList.add('update');
                    updateButton.textContent = 'Update';
                    updateButton.addEventListener('click', updateProduct);

                    let deleteButton = document.createElement('button');
                    deleteButton.classList.add('delete');
                    deleteButton.textContent = 'Delete';
                    deleteButton.addEventListener('click', deleteProduct);

                    buttonsCellElement.appendChild(updateButton);
                    buttonsCellElement.appendChild(deleteButton);

                    rowElement.appendChild(nameCellElement);
                    rowElement.appendChild(countCellElement);
                    rowElement.appendChild(priceCellElement);
                    rowElement.appendChild(buttonsCellElement);

                    tableData.appendChild(rowElement);

                })

                table.appendChild(tableData);

            });
    }

    async function addProduct(e) {
        e.preventDefault();

        let product = productNameInput.value;
        let count = productCountInput.value;
        let price = productPriceInput.value;

        if (product === '' || count === '' || price === '') {
            return;
        }

        await fetch(ENDPOINT_URL, {
            method: 'POST',
            body: JSON.stringify({ product, count, price }),
        });

        await loadAllProducts();

        addProductsForm.reset();
    }

    async function deleteProduct(e) {

        let id = e.currentTarget.parentElement.parentElement.getAttribute('data-id');

        await fetch(`${ENDPOINT_URL}/${id}`, {
            method: 'DELETE',
        });

        loadAllProducts();

    }

    function updateProduct(e) {

        editedProductId = e.currentTarget.parentElement.parentElement.getAttribute('data-id');

        let tableRow = e.currentTarget.parentElement.parentElement;

        productNameInput.value = tableRow.querySelector('td:nth-of-type(1)').textContent;
        productCountInput.value = tableRow.querySelector('td:nth-of-type(2)').textContent;
        productPriceInput.value = tableRow.querySelector('td:nth-of-type(3)').textContent;

        addProductButton.disabled = true;
        updateProductButton.disabled = false;

    }

    async function saveUpdatedProduct(e) {
        e.preventDefault();

        let product = productNameInput.value;
        let count = productCountInput.value;
        let price = productPriceInput.value;

        if (product === '' || count === '' || price === '') {
            return;
        }

        await fetch(`${ENDPOINT_URL}/${editedProductId}`, {
            method: 'PATCH',
            body: JSON.stringify({ product, count, price}),
        });

        loadAllProducts();

        addProductButton.disabled = false;
        updateProductButton.disabled = true;

    }

}

solve();