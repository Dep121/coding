function minWindow(s, t) {
    let i=0, j=0;
    const count = {};
    const windowCount = {};
    let l=0, r=0;
    let have=0, need=t.length;
    let result = Number.MAX_SAFE_INTEGER;

    for (let x=0; x<t.length; ++x) {
        if (count[t[x]]) {
            count[t[x]]++;
        } else {
            count[t[x]] = 1;
        }
    }

    while (j < s.length) {
        if (windowCount[s[j]]) {
            windowCount[s[j]]++;
        } else {
            windowCount[s[j]] = 1;
        }

        if (count[s[j]] && windowCount[s[j]] <= count[s[j]]) {
            have++;
            console.log("have++", have, need)
        }

        while (have === need) {
            // update the result
            console.log("have === need")
            if (result > j-i+1) {
                result = j-i+1;
                l = i;
                r = j;
            }

            // move the left pointer to right
            windowCount[s[i]]--;
            if (count[s[i]] && windowCount[s[i]] < count[s[i]]) {
                have--;
            }
            i++;
        }
        j++;
    }

    if (result !== Number.MAX_SAFE_INTEGER) {
        return s.slice(l, r+1);
    } else {
        return "";
    }
};

// const result = minWindow("ADOBECODEBANC", "ABC");
const result = minWindow("aa", "aa");

console.log(`result: `, result);