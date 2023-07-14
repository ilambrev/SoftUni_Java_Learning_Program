function subtract() {
    let firstNum = Number(document.querySelector('#firstNumber').value);
    let secondNum = Number(document.querySelector('#secondNumber').value);

    document.querySelector('#result').textContent = firstNum - secondNum;
}