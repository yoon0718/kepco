window.onload = function execute() {
  //arrow function 함수 단순화
  const simplePrint = function () {
    console.log("simplePrint!");
  };
  const simplePrint1 = () => console.log("simplePrint!");
  const simplePrint2 = () => {
    console.log("simplePrint!");
  };
  simplePrint();
  simplePrint1();
  simplePrint2();

  //파라미터가 1개인경우 () 생략 가능
  const minus = (a) => console.log(a);
  minus(1);

  //함수 내의 코드가 한줄이면 return 생략 가능
  const add = function (a, b) {
    return a + b;
  };

  //closure
  //지역 변수가 사라지지 않고 계속 기억되는 현상
  //호출 할 때마다 숫자를 증가시키는 함수
  function sequence() {
    let seq = 0;
    return function () {
      return ++seq;
    };
  }
  const seq = sequence();
  console.log(seq());
  console.log(seq());
  console.log(seq());

  //분류 항목과 데이터를 저장하는 템플릿 형태의 함수
  function foo(x) {
    return function (y) {
      console.log(`${x} : ${y}`);
    };
  }

  const bar1 = foo("과목");
  bar1("국어");
  bar1("영어");
  bar1("수학");

  const bar2 = foo("성적");
  bar2(100);
  bar2(90);
  bar2(80);

  function sequence1() {
    let seq = 0;
    return function () {
      seq++;
      return seq;
    };
  }
  const check = sequence1();
  window.addEventListener("blur", () => {
    const count = check();
    if (count > 5) {
      window.alert("시험 종료!");
      window.close();
    }
  });
};
