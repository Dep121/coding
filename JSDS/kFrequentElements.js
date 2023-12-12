function topKFrequent(nums, k) {
    // count the frequency
    let count = {};
    for (let i = 0; i<nums.length; ++i){
        if (count[nums[i]]) {
            count[nums[i]]++;
        } else {
            count[nums[i]] = 1;
        }
    }
    // create freq array with number
    let freq = new Array(nums.length + 1).fill().map(u => []);

    let ks = Object.keys(count);

    for (let i=0; i<ks.length; ++i) {
        if (freq[count[ks[i]]].length > 0) {
            freq[count[ks[i]]].push(ks[i]);
        } else {
            freq[count[ks[i]]] = [ks[i]];
        }
    }

    let res = [];
    let i = nums.length;

    while (k) {
        while (freq[i].length > 0 && k) {
            res.push(freq[i].pop());
            k--;
        }
        i--;
    }
    return res;
};

let nums = [1,1,1,2,2,3], k = 2
let ans = topKFrequent(nums, k)
