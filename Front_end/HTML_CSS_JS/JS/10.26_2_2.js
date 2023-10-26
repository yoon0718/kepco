//익명, 변수 값 할당
const print = function () {
  // anonymous function
  console.log("print");
};
print();

const printAgain = print;
printAgain();

function sum(a, b) {
  return a + b;
}
const sumAgain = sum;
console.log(sumAgain(1, 3));

//함수를 인자로 사용하여 Callback 처리
function quiz(answer, printYes, printNo) {
  if (answer === "love you") {
    printYes();
  } else {
    printNo();
  }
}

const printYes = function () {
  console.log("yes!");
};

const printNo = function () {
  console.log("no!");
};

quiz("wrong", printYes, printNo);
quiz("love you", printYes, printNo);

//Callback 예시)
//일정시간 경과 후 동작
function callback1() {
  const label = document.querySelector(".label");
  label.innerHTML = "<h2>모습 변경</h2>";

  const figure = document.querySelector(".figure");
  figure.style.backgroundColor = "red";
  figure.style.borderRadius = "100px";
}

setTimeout(callback1, 2000);

//현재 위도/경도 확인하기
function callback(position) {
  const lat = position.coords.latitude;
  const lng = position.coords.longitude;

  const label = document.querySelector(".label");
  label.innerHTML += `<h2>위도: ${lat}</h2>`;
  label.innerHTML += `<h2>경도: ${lng}</h2>`;
}
navigator.geolocation.getCurrentPosition(callback);

//선언식 / 표현식
/*funcA();
funcB();

function funcA() {
    console.log('java');
};

const funcB = function() {
    console.log('script');
} 
실행오류남.
const funcA = function() {
    console.log('script');
};

function funcA() {
    console.log('java');
}

funcA(); 이것도 마찬가지*/
