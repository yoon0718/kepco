let food1 = prompt("첫번째 음식의 금액을 입력해주세요.");
let food2 = prompt("두번째 음식의 금액을 입력해주세요.");
let cnt = prompt("나누어 낼 인원 수를 입력해주세요.");

let price = parseInt(food1) + parseInt(food2); // 전체 금액
let nPrice = price / cnt; // 인원 수로 나눈 금액

console.log(`전체 금액: ${price}, 인원 수: ${cnt}`);
console.log(`1/n 금액: ${nPrice}`);
