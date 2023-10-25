let num = 12345;
let answer;
num1 = parseInt(num / 10000);
num2 = parseInt((num - 10000 * num1) / 1000);
num3 = parseInt((num - 10000 * num1 - 1000 * num2) / 100);
num4 = parseInt((num - 10000 * num1 - 1000 * num2 - 100 * num3) / 10);
num5 = parseInt(
  (num - 10000 * num1 - 1000 * num2 - 100 * num3 - 10 * num4) / 1
);
console.log(num1 + num2 + num3 + num4 + num5);
