function extractText() {
    let liElements = Array.from(document.querySelectorAll('#items > li'));

    document.querySelector('#result').textContent = liElements.map(e => e.textContent).join('\n');
}