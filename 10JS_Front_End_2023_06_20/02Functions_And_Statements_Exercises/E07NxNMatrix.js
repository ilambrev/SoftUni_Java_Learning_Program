function nxnMatrix(size) {

    for (let i = 1; i <= size; i++) {

        let row = '';

        for (let j = 1; j <= size; j++) {

            row += size;

            if (j < size) {

                row += ' ';

            }

        }

        console.log(row);

    }

}

// nxnMatrix(3);
// nxnMatrix(7);
// nxnMatrix(2);