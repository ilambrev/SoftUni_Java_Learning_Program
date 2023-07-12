function deleteByEmail() {
    let inputEmail = document.querySelector('input[name="email"]').value;
    let tdWithEmails = Array.from(document.querySelectorAll('#customers td:nth-child(even)'));

    let result = 'Deleted';

    if (tdWithEmails.filter(td => td.textContent === inputEmail).length > 0) {
        let row = tdWithEmails.filter(td => td.textContent === inputEmail)[0].parentNode;
        row.parentNode.removeChild(row);
    } else {
        result = 'Not found.';
    }
    document.querySelector('#result').textContent = result;
    document.querySelector('input[name="email"]').value = '';
}