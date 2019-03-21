function solution(A) {
    // write your code in JavaScript (Node.js 8.9.4)
    let jumping = false; // 사이간격이 2이상인 것을 파악하는 변수
    let ans = 0;

    A.sort((a,b) => {return a-b});

    if(A[0] >= 2) // 정렬 후 첫 원소가 2이상일 경우 놓친 양수는 1
        return 1;

    for (let i=0; i<A.length; i++) {
        if (A[i+1] < 2) // 사이의 간격이 2이상인 것을 확인할때 자신의 바로 앞 원소가 2보다 작으면 반환할 양수가 없는 상황이므로 넘어간다.
            continue;
        if (Math.abs(A[i]-A[i+1]) >= 2) { // 바로 앞 원소가 2이상이고 차이가 2이상인 경우 for문을 종료한다.
            ans = A[i];
            jumping = true;
            break;
        }
    }

    if(!jumping) { // 연속된 수인 경우
        if(A[A.length -1] < 0) // 모두 연속된 음수일 경우 1을 반환
            return 1;
        return A[A.length -1] + 1; // 연속된 양수인 경우 마지막 원소의 +1 반환
    }

    if(ans < 0) // 불연속된 수이면서 전부 음수인 경우
        return 1;

    return ans + 1; // 불연속된 수이면서 양수가 포함된 경우

}

console.log(solution([-3, -1, 3]));
console.log(solution([1, 3, 6, 4, 1, 2]));
console.log(solution([-1,-3]));
console.log(solution([2]));
