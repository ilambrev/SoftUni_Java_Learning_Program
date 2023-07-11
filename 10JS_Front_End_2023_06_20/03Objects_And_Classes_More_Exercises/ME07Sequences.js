function sequences(input) {

    let uniqueSequences = [];

    for (let line of input) {

        let arr = line.substring(1, line.length - 1)
            .split(', ')
            .map(a => Number(a))
            .sort((a, b) => b - a);

        if (uniqueSequences.filter(a => a.toString() === arr.toString()).length === 0) {

            uniqueSequences.push(arr);

        }

    }

    uniqueSequences.sort((s1, s2) => s1.length - s2.length).forEach(s => console.log('[' + s.join(', ') + ']'));

}

/*
sequences([
    "[-3, -2, -1, 0, 1, 2, 3, 4]",
    "[10, 1, -17, 0, 2, 13]",
    "[4, -3, 3, -2, 2, -1, 1, 0]"]
);
sequences([
    "[7.14, 7.180, 7.339, 80.099]",
    "[7.339, 80.0990, 7.140000, 7.18]",
    "[7.339, 7.180, 7.14, 80.099]"]
);
*/