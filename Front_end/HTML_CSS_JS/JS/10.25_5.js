//문자 연산자( + += )
console.log("my" + " cat");
console.log("1" + 2);
console.log(`string literals: 1 + 2 = ${1 + 2}`);
console.log(`string literals: 줄바꿈
     지원`);
//산술 연산자 ( + - * / % ** )
console.log(1 + 1); // 더하기
console.log(1 - 1); // 빼기
console.log(1 / 1); // 나누기
console.log(1 * 1); // 곱하기
console.log(5 % 2); // 나머지
console.log(2 ** 3); // 거듭제곱
//증가 연산자 (전위)
let counter = 2;
const preIncrement = ++counter;
// counter = counter + 1;
// preIncrement = counter;
console.log(`preIncrement: ${preIncrement}`);
console.log(`counter: ${counter}`);
//증가 연산자 (후위)
const postIncrement = counter++;
// postIncrement = counter;
// counter = counter + 1;
console.log(`postIncrement: ${postIncrement}`);
console.log(`counter: ${counter}`);
// 대입 연산자 ( = += -= *= /= %= **= )
let x = 3;
let y = 6;

x += y; // x = x + y;
console.log(`x: ${x}, y: ${y}`);

x -= y; // x = x - y;
console.log(`x: ${x}, y: ${y}`);

x *= y; // x = x * y;
console.log(`x: ${x}, y: ${y}`);

x /= y; // x = x / y;
console.log(`x: ${x}, y: ${y}`);
//논리 연산자 ( && || ! )
const value1 = false;
const value2 = 4 < 2;

// true를 찾으면 true 반환하며 종료
console.log(`or: ${value1 || value2 || check()}`);

// false를 찾으면 false 반환하며 종료
console.log(`and: ${value1 && value2 && check()}`);

function check() {
  for (let i = 0; i < 10; i++) {
    console.log("pass");
  }
  return true;
}

console.log(!value1);

//비교 연산자 ( == === != !== > < >= <= )
console.log(`10 < 6 -> ${10 < 6}`);
console.log(`10 <= 6 -> ${10 <= 6}`);
console.log(`10 > 6 -> ${10 > 6}`);
console.log(`10 >= 6 -> ${10 >= 6}`);
const stringFive = "5";
const numberFive = 5;

// 느슨한 비교 (자료형 자동 변환)
console.log(stringFive == numberFive);
console.log(stringFive != numberFive);

// 엄격한 비교
console.log(stringFive === numberFive);
console.log(stringFive !== numberFive);

const dev1 = { name: "dev" };
const dev2 = { name: "dev" };
const dev3 = dev1;

console.log(dev1 == dev2);
console.log(dev1 === dev2);
console.log(dev1 === dev3);

//삼항 연산자 ( ? : )
let user_id = "script";
console.log(user_id === "script" ? "yes" : "no");

let score = 70;
console.log(score >= 60 ? (score >= 90 ? "perfect" : "good") : "bad");
