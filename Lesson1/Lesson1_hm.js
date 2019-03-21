let N = 15;
let bs = N.toString(2);

let bs_iterator = bs[Symbol.iterator]();

let cnt = 0;

let answer_array = [];

for(let item of bs_iterator) {
    if(item === '1') {
        if( cnt!==0 ) {
            answer_array.push(cnt);
            cnt = 0;
        }
    }
    else {
        cnt++;
    }
}

if(answer_array.length === 0)
    console.log(0);
else {
    console.log(Math.max(...answer_array));
}
