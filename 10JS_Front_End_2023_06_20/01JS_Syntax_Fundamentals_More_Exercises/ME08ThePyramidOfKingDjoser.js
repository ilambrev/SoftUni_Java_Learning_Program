function thePyramidOfKingDjoser(pyramidBase, increment) {

    let stones = 0;
    let marble = 0;
    let lapisLazuli = 0;
    let gold = 0;
    let materialPerBlock = 1 * 1 * increment;
    let pyramidLayers = Math.ceil(pyramidBase / 2);
    let sideSize = pyramidBase;

    for (let i = 1; i < pyramidLayers; i++) {

        let outerBlocks = (4 * sideSize) - 4;
        let bulkBlocks = (sideSize * sideSize) - outerBlocks;

        if (i % 5 == 0) {

            lapisLazuli += outerBlocks * materialPerBlock;

        } else {

            marble += outerBlocks * materialPerBlock;

        }

        stones += bulkBlocks * materialPerBlock;

        sideSize -= 2;

    }

    gold += (sideSize * sideSize) * materialPerBlock;

    console.log(`Stone required: ${Math.ceil(stones)}`);
    console.log(`Marble required: ${Math.ceil(marble)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(lapisLazuli)}`);
    console.log(`Gold required: ${Math.ceil(gold)}`);
    console.log(`Final pyramid height: ${Math.floor(pyramidLayers * increment)}`);

}

// thePyramidOfKingDjoser(11, 1);
// thePyramidOfKingDjoser(11, 0.75);
// thePyramidOfKingDjoser(12, 1);
// thePyramidOfKingDjoser(23, 0.5);