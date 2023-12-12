let nums = [7, 4, 2, 9, 8];
// let sum = 16; --> true
let sum = 31;

let dp = [];
for (let i = 0; i<=sum; ++i) {
    dp[i] = [];
    for (let j = 0; j<=nums.length; ++j) {
        dp[i].push(undefined);
    }
}

function subsetSumRecu(nums, partialSum, size) {
    // base condition
    if (partialSum === 0) {
        return true;
    }

    if (size === 0) {
        return false;
    }

    // choice diagram
    if (nums[size - 1] <= partialSum) {
        return subsetSumRecu(nums, partialSum - nums[size - 1], size - 1)
        || subsetSumRecu(nums, partialSum, size - 1);
    } else {
        return subsetSumRecu(nums, partialSum, size - 1);
    }

}

function subsetSumMemoization(nums, partialSum, size) {
    // base condition
    if (partialSum === 0) {
        dp[partialSum][size] = true;
        return true;
    }

    if (size === 0) {
        dp[partialSum][size] = false;
        return false;
    }

    if (dp[partialSum][size] !== undefined) {
        return dp[partialSum][size];
    }

    // choice diagram
    if (nums[size - 1] <= partialSum) {
        dp[partialSum][size] = subsetSumMemoization(nums, partialSum - nums[size - 1], size - 1)
        || subsetSumMemoization(nums, partialSum, size - 1);
        return dp[partialSum][size];
    } else {
        dp[partialSum][size] = subsetSumMemoization(nums, partialSum, size - 1);
        return dp[partialSum][size];
    }
}

// console.log(dp);
let result = subsetSumMemoization(nums, sum, nums.length)
console.log(dp);
console.log(result);