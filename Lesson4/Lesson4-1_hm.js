function solution(A) {
    // write your code in JavaScript (Node.js 8.9.4)
    console.log(A.length-1);
    if(A.length === 1 || A.length === 2)
        return 0;
    let max = -1;
    let min = 10000001;
    for(let i=0; i<A.length; i++) {
        if(max < A[i])
            max = A[i];
        if(min > A[i])
            min = A[i];
    }
    console.log(max,min);
    return (max-min)%(A.length-1)===0? 1:0
}

function solution2(A) {
    // write your code in JavaScript (Node.js 8.9.4)
    
}

function solution3(A) {
    // write your code in JavaScript (Node.js 8.9.4)
    if(A.length === 1 && A[0] !== 1)
        return 0;

    A.sort((a,b) => { return a-b })

    if(A[0] !== 1)
        return 0;

    for(let i=0; i<A.length-1; i++) {
        if(A[i+1]-A[i] !== 1)
            return 0;
    }

    return 1;
}


console.log(solution3([2,1,3,4]));
console.log(solution3([1,3,4]));
console.log(solution3([1]));
