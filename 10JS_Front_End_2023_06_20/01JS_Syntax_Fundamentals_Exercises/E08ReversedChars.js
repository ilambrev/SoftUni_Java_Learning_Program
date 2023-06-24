function reversedChars(firstChar, secondChar, thirdChar) {

    let resultString = firstChar + secondChar + thirdChar;
    console.log([...resultString].reverse().join(' '));

}

// reversedChars('A','B','C');
// reversedChars('1','L','&');