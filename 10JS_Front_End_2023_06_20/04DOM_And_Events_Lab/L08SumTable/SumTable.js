function sumTable() {
    let valuesCells = Array.from(document.querySelectorAll('body table:first-child td:nth-child(even)'));
    
    let sum = valuesCells.reduce((acc, curr) => {
        if (curr.id !== 'sum') {
            acc += Number(curr.textContent);
        }
        return acc;
    }, 0);

    document.querySelector(`#sum`).textContent = sum;
}