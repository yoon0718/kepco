/* 기본 형태
function name(param1, param2) { 
  // body ... 
  return; 
}
*/
function printHello() {
  console.log("Hello");
}
printHello();

function log(message) {
  console.log(message);
}
log("Hello@");

// 기본 자료형 : 값 전달
function changeName(name) {
  name = "tom";
}
const name = "john";
changeName(name);
console.log(name);

//참조 자료형(객체) : 참조(주소) 전달
function changeNameByObject(obj) {
  obj.name = "tom";
}
const user = { name: "john" };
changeNameByObject(user);
console.log(user);

//참조 자료형 사용 오류
const data = [
  { name: "A", score: 77 },
  { name: "B", score: 88 },
  { name: "C", score: 66 },
  { name: "D", score: 55 },
];
function check1(data) {
  const result = [];
  const person = {};
  data.forEach((value) => {
    person["name"] = value.name;
    person["score"] = value.score;
    person["pass"] = value.score > 60 ? true : false;
    result.push(person);
  });
  return result;
}
console.log(check1(data));

//참조 자료형 사용 오류 해결
function check(data) {
  const result = [];

  for (let i = 0; i < data.length; i++) {
    const person = {};
    person["name"] = data[i].name;
    person["score"] = data[i].score;
    person["pass"] = data[i].score > 60 ? true : false;
    result.push(person);
  }
  // data.forEach((value) => {
  //   const person = {};
  //   person["name"] = value.name;
  //   person["score"] = value.score;
  //   person["pass"] = value.score > 60 ? true : false;
  //   result.push(person);
  // });

  return result;
}
console.log(check(data));

function check2(data) {
  const result = [];

  data.forEach((value) => {
    result.push({
      name: value.name,
      score: value.score,
      pass: value.score > 60 ? true : false,
    });
  });

  return result;
}
console.log(check2(data));

//가변인자(Rest Parameter)
function printAll(...args) {
  for (let i = 0; i < args.length; i++) {
    console.log(args[i]);
  }
  for (const arg of args) {
    console.log(arg);
  }
  args.forEach((arg) => console.log(arg));
}
printAll("java", "script", "html/css");

//변수의 유효 범위
let globalMessage = "global"; // global variable
function printMessage() {
  let message = "hello";
  console.log(message); // local variable
  console.log(globalMessage);
}
printMessage();
//console.log(message);

//결과 반환(return)
function sum(a, b) {
  return a + b;
}
const result = sum(1, 2); // 3
console.log(`sum: ${sum(1, 2)}`);

function nothing(a, b) {}
console.log(`result: ${nothing(1, 2)}`);
