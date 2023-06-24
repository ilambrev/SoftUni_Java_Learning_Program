function cookingByNumbers(number, firstOp, secondOp, thirdOp, fourthOp, fifthOp) {

    let result = number;
    let operations = [firstOp, secondOp, thirdOp, fourthOp, fifthOp];

    for (let i = 0; i < operations.length; i++) {

        let operation = operations[i];

        switch (operation) {
            case 'chop':
                result /= 2;
                break;
            case 'dice':
                result = Math.sqrt(result);
                break;
            case 'spice':
                result += 1;
                break;
            case 'bake':
                result *= 3;
                break;
            case 'fillet':
                result = result - result * 20 / 100;
                break;
        }

        console.log(result);

    }

}

// cookingByNumbers('32', 'chop', 'chop', 'chop', 'chop', 'chop');
// cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet');