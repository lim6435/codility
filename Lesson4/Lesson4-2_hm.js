function solution(X, A) {
    // write your code in JavaScript (Node.js 8.9.4)
    let num = X;
    let ch = new Array(num+1);

    for(let i=0; i<A.length; i++) {
        if(ch[A[i]] === undefined || ch[A[i]] > i)
            ch[A[i]] = i;
    }
    // console.log(ch.length,X);

    let ans = -1;

    for(let j=1; j<ch.length; j++) {
        // console.log(j + " " + ch[j]);
        if(ch[j] === undefined)
            return -1;
        if(ans < ch[j])
            ans = ch[j]
    }

    return ans;
}


console.log(solution(5, [1, 3, 1, 4, 2, 3, 5, 4]));
