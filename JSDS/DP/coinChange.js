function minNumberOfCoins(coins, amount, len) {
    if (amount === 0) {
        return 0;
    }
    if (len === 0) {
        return Number.MAX_SAFE_INTEGER - 1;
    }

    if (amount >= coins[len-1]) {
        return Math.min(
            1 + minNumberOfCoins(coins, amount-coins[len-1], len),
            minNumberOfCoins(coins, amount, len-1)
        )
    } else {
        return minNumberOfCoins(coins, amount, len-1)
    }
}

function totalNumberOfWaysOfCoins(coins, amount, len) {
    if (amount === 0) {
        // if amount is finished then 1 number of exists
        return 1;
    }

    if (len === 0) {
        // if len becomes 0 then no coins exist and amount cannot be completed
        return 0;
    }

    if (amount >= coins[len - 1]){
        return totalNumberOfWaysOfCoins(coins, amount - coins[len - 1], len)
        + totalNumberOfWaysOfCoins(coins, amount, len - 1);
    } else {
        return totalNumberOfWaysOfCoins(coins, amount, len - 1);
    }
}

let coins = [1];
let amount = 0;

let result = minNumberOfCoins(coins, amount, coins.length);
if (result === Number.MAX_SAFE_INTEGER - 1) {
    console.log(-1);
} else {
    console.log(`minimum number of coins: `, result);
}

let dp = [];
for (let i = 0; i<=coins.length; ++i) {
    dp[i] = [];
    for (let j = 0; j<=amount; ++j) {
        dp[i].push(undefined);
    }
}
let totalWaysOfCoins = totalNumberOfWaysOfCoins(coins, amount, coins.length);
console.log(`number of ways coins: `, totalWaysOfCoins)
