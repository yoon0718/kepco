// if / else if / else
const job = "programmer";

if (job === "programmer") {
  console.log("Welcome, Programmer!");
} else if (job === "designer") {
  console.log("Good!");
} else {
  console.log("Unknown");
}

//현재 시간에 따라 아침 / 점심 / 저녁 출력
const date = new Date();
let hour = date.getHours();
let min = date.getMinutes();
let sec = date.getSeconds();

console.log("현재시각 : " + hour + "시 " + min + "분 " + sec + "초");

if (hour < 12) {
  console.log("아침");
} else if (hour < 18) {
  console.log("점심");
} else {
  console.log("저녁");
}

//현재 시간에 따라 배경이미지 변경

console.log("현재시각 : " + hour + "시 " + min + "분 " + sec + "초");

if (hour < 12) {
  document.body.style.backgroundImage = "url(../../images/dog.jpg)";
} else if (hour < 18) {
  document.body.style.backgroundImage = "url(../../images/box.png)";
} else {
  document.body.style.backgroundImage = "url(../../images/bicycle.png)";
}
// switch
const browser = "Chrome";
switch (browser) {
  case "IE":
    console.log("go away!");
    break;
  case "Chrome":
  case "Firefox":
    console.log("love you!");
    break;
  default:
    console.log("same all!");
}
// 입력된 숫자 홀/짝 구분하기
let input = Number(prompt("숫자를 입력해주세요", "숫자"));
switch (input % 2) {
  case 0:
    alert("짝수입니다.");
    break;
  case 1:
    alert("홀수입니다.");
    break;
  default:
    alert("숫자만 입력해주세요.");
}
//클라이언트의 웹브라우저 종류 구분하기
function getClient() {
  const userAgent = navigator.userAgent;

  let os = "";

  if (userAgent.indexOf("Android") > -1) {
    os = "AndroidPhone";
  } else if (userAgent.indexOf("iPhone") > -1) {
    os = "iPhone";
  } else if (userAgent.indexOf("iPad") > -1) {
    os = "iPad";
  } else if (userAgent.indexOf("Chrome") > -1) {
    os = "Chrome";
  } else {
    os = "ETC";
  }

  return os;
}
const client = getClient();
switch (client) {
  case "AndroidPhone":
    console.log("AndroidPhone");
    break;
  case "iPhone":
    console.log("iPhone");
    break;
  case "iPad":
    console.log("iPad");
    break;
  case "Chrome":
    console.log("Chrome");
    break;
  default:
    console.log("etc");
}
