// function solution(A) {
//     // write your code in JavaScript (Node.js 8.9.4)
//     let ans = 0;
//     let temp = new Map();
//     A.forEach((item)=>{
//         if(temp.has(item)){
//             temp.set(item, temp.get(item)+1);
//         }
//         else{
//             temp.set(item, 1);
//         }
//     })
//
//     for(let [key,value] of temp){
//         if(value == 1) {
//             ans = key;
//         }
//     }
//
//     return ans;
// }

const {performance} = require('perf_hooks');

function solution(A) {
    // write your code in JavaScript (Node.js 8.9.4)
    let mp = new Map();
    for(let i=0; i<A.length; i++) {
        if(mp.has(A[i]))
            mp.delete(A[i]);
        else
            mp.set(A[i],0);
    }

    return mp.keys().next().value
}

let time = performance.now();
console.log(solution([11,3,7,3,11]));
console.log(performance.now() - time);
