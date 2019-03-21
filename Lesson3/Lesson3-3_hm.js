// 0 / 전체합 1부터 배열 마지막 직전 요소까지 루틴돌면서 더하고 빼고

function solution(A) {
    let right = A.reduce((total, curr) => {
        total += curr;
        return total;
    });
    let left = 0;
    let ans = 2001;

    for(let i=0; i<A.length-1; i++) {
        left += A[i];
        right -= A[i];

        let temp = Math.abs(left-right);
        console.log(temp);
        if(temp<ans) {
            ans = temp;
        }
    }

    return ans;
}

console.log(solution([3,1,2,4,3]));
