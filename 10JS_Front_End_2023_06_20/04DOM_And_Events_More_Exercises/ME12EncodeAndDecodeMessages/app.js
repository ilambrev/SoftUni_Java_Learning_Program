function encodeAndDecodeMessages() {
    let buttons = document.querySelectorAll('#main button');
    let textAreas = document.querySelectorAll('#main textarea');
    let encodeButton = buttons[0];
    let decodeButton = buttons[1];
    let encodeTextArea = textAreas[0];
    let decodeTextArea = textAreas[1];

    encodeButton.addEventListener('click', () => {
        let textToEncode = encodeTextArea.value;

        let encodedText = textToEncode.split('').map(s => String.fromCharCode(s.charCodeAt(0) + 1)).join('');

        decodeTextArea.value = encodedText;

        encodeTextArea.value = '';

    });

    decodeButton.addEventListener('click', () => {
        let textToDecode = decodeTextArea.value;

        let decodedText = textToDecode.split('').map(s => String.fromCharCode(s.charCodeAt(0) - 1)).join('');

        decodeTextArea.value = decodedText;

    });
}