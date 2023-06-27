function bitcoinMining(mineShift) {

    const bitcoinPrice = 11949.16;
    const goldPrice = 67.51;

    let money = 0;
    let dayOfFirstBitcoin = 0;
    let numberOfBitcoins = 0;

    for (let i = 0; i < mineShift.length; i++) {

        let collectedGold = (i + 1) % 3 === 0 ? mineShift[i] * 0.70 : mineShift[i];

        money += collectedGold * goldPrice;

        if (money >= bitcoinPrice) {

            let newBitcoins = Math.floor(money / bitcoinPrice);

            numberOfBitcoins += newBitcoins;

            money -= newBitcoins * bitcoinPrice;

            if (dayOfFirstBitcoin === 0) {

                dayOfFirstBitcoin = i + 1;

            }

        }

    }

    console.log(`Bought bitcoins: ${numberOfBitcoins}`);

    if (dayOfFirstBitcoin > 0) {

        console.log(`Day of the first purchased bitcoin: ${dayOfFirstBitcoin}`);

    }

    console.log(`Left money: ${money.toFixed(2)} lv.`);

}

// bitcoinMining([100, 200, 300]);
// bitcoinMining([50, 100]);
// bitcoinMining([3124.15, 504.212, 2511.124]);