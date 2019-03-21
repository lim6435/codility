// 생각한 로직
// MAIN : Map을 통해 더해야할 횟수를 카운트한다!
// BUT maxcount를 만났을 때 모든 값이 현재 최대값으로 변하기 때문에 최대값으로 업데이트하고 Map을 초기화한다.
// 최댓값을 업데이트하는 방식은 변수 get(maxcount를 만났을 때 치환되는 최댓값) 변수 max(maxcount를 만나지 않았을 경우 현재치환된 최댓값 get과 더 해질 횟수와 비교하는 변수)
// 를 이용한다.


// Arrays.fill 같은 방식 생각해보기
// 가독성과 퍼포먼스 사이 고민
function solution(N, A) {
    // write your code in JavaScript (Node.js 8.9.4)

    let map = new Map();
    let max = 0;
    let get = 0;
    let ans = new Array(N);

    for(let i=0; i<A.length; i++) {
        if(A[i] === N+1) {
            // console.log("clear");
            map.clear();
            get = max;

        }
        else {
            // console.log(map.get(A[i]) === undefined);
            map.set(A[i], map.get(A[i]) === undefined ? 1:map.get(A[i])+1);
            // console.log(map.get(A[i]));
            if(map.get(A[i]) + get >= max)
                max = map.get(A[i]) + get;
        }
    }

    for(let k=0; k<ans.length; k++){
        ans[k] = map.has(k+1) === true ? get+map.get(k+1):get;
    }

    // console.log(ans.toString());
    return ans;
}

solution(1, [2, 1, 1, 2, 1]);
