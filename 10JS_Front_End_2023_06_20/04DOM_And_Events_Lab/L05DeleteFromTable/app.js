function deleteByEmail() {
    let inputEmail = document.querySelector('input[name="email"]').value;
    let tdWithEmails = Array.from(document.querySelectorAll('#customers td:nth-child(even)'));

    let result = 'Deleted';
    let emailsFound = tdWithEmails.filter(td => td.textContent === inputEmail);

    if (emailsFound.length > 0) {
        let row = emailsFound[0].parentNode;
        row.parentNode.removeChild(row);
    } else {
        result = 'Not found.';
    }
    document.querySelector('#result').textContent = result;
    document.querySelector('input[name="email"]').value = '';
}