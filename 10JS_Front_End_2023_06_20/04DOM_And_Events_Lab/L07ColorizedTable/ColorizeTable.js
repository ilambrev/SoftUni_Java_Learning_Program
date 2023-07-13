function colorize() {
    let evenRows = Array.from(document.querySelectorAll('table tr:nth-child(even)'));

    evenRows.forEach(r => r.style.background = ('Teal'));
}