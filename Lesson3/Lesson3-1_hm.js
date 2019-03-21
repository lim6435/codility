'use strict'
const {performance} = require('perf_hooks');

function solution(X, Y, D) {
    if(X === Y)
        return 0;

    let ans_ = 1;
    let distance = Y - X;
    while(ans_*D < distance) {
        ans_++;
    }
    return ans_;
}

function solution2(X, Y, D) {
    if(X === Y)
        return 0;

    let distance = Y - X;
    let rm = distance % D;
    if(rm === 0)
        return distance/D;

    let ans = (distance - rm)/D;
    ans++;
    return ans;
}

let time = performance.now();
console.log(solution(3, 999111321, 7));
console.log(performance.now() - time);

let time_ = performance.now();
console.log(solution2(3, 999111321, 7));
console.log(performance.now() - time_);
