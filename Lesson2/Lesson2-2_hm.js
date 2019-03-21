function solution(A, K) {
    let len = A.length;
    console.log(len);
    let ans = 0;

    if(K > 0) {
        let cnt = K%len;
        ans = lotateR(A,cnt);
    }
    else {
        let cnt = K%len;
        ans = lotateL(A,cnt);
    }

    return ans;
}

function lotateR(A,N) {
    for(let i=0; i<N; i++) {
        let temp = A.pop();
        A.unshift(temp);
    }
    return A;
}

function lotateL(A,N) {
    for(let i=0; i<N; i++) {
        let temp = A.shift();
        A.push(temp);
    }
    return A;
}

let A = [3,8,9,7,6];
let K = 3;

console.log(solution(A,K));
