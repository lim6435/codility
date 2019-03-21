function solution(A) {

    let len = A.length;
    let arr = new Array(len+2);

    let temp = 0;
    for(let i=0; i<len; i++){
        arr[A[i]] = 1;
    }

    for(let j=0; j<arr.length; j++) {
        if(arr[j] === undefined) {
            temp = j;
        }
    }

    return temp;
}
