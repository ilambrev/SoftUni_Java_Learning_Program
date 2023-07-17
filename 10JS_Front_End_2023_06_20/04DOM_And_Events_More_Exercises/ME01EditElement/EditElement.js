function editElement(element, stringMatch, replacer) {
    let text = element.textContent;

    while (text.includes(stringMatch)) {
        text = text.replace(stringMatch, replacer);
    }

    element.textContent = text;
}