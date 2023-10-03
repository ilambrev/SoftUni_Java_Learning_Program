function argumentInfo(args) {

    let argTypeCounts = new Map();

    args.forEach(arg => {
        let type = typeof arg;
        console.log(`${type}: ${arg}`);
        argTypeCounts.has(type) ? argTypeCounts.set(type, argTypeCounts.get(type) + 1) : argTypeCounts.set(type, 1);
    });

    let sortedArgTypeCounts = new Map([...argTypeCounts.entries()].sort((a, b) => b[1] - a[1]));

    sortedArgTypeCounts.forEach((value, key) => console.log(`${key} = ${value}`));

}

// argumentInfo(['cat', 42, function () { console.log('Hello world!'); }]);
// argumentInfo([1, function () { console.log('Hello world!'); }, 'a', 2, 'b', 'c']);