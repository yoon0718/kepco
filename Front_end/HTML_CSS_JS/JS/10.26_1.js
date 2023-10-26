//while
let i = 3;
while (i > 0) {
  console.log(`while: ${i}`);
  i--;
}

do {
  console.log(`do while: ${i}`);
  i--;
} while (i > 0);

//1 에서 10 사이의 랜덤 숫자 맞추기
/*const input = parseInt(Math.random() * 10 + 1);
let isContinue = true;
while (isContinue) {
  let number = prompt("숫자를 입력하세요.");
  if (input == number) {
    alert("정답");
    isContinue = false;
  } else {
    if (input > number) {
      alert("입력된 숫자가 더 적음");
    } else {
      alert("입력된 숫자가 더 큼");
    }
  }
}*/
//for
let Z;
for (z = 3; z > 0; z--) {
  // for(begin; condition; step)
  console.log(`for: ${z}`);
}

for (let z = 3; z > 0; z = z - 2) {
  console.log(`inline variable for: ${z}`);
}

//for 중첩
for (let i = 0; i < 3; i++) {
  for (let j = 0; j < 3; j++) {
    console.log(`i: ${i}, j: ${j}`);
  }
}

//별 출력하기
let count = 5;
for (let i = 1; i <= count; i++) {
  let temp = "";

  for (let j = 1; j <= i; j++) {
    temp += "*";
  }

  console.log(temp);
}
//중복되지 않는 3개의 번호 추출
const selected = [];

while (selected.length < 3) {
  const num = parseInt(Math.random() * 45) + 1;
  if (selected.indexOf(num) == -1) {
    selected.push(num);
  }
}
console.log(selected.sort((a, b) => a - b));
//제시된 번호와 비교하기
const lotto = [1, 8, 16];
if (lotto == selected.toString()) {
  console.log("맞히기 성공");
} else {
  console.log("맞히기 실패");
  console.log(selected);
}
