const map = ["가위", "바위", "보"];
const player = 0;
const com = parseInt(Math.random() * 3);
console.log(`player: ${map[player]}, com: ${map[com]}`);
let result = "";
if (com == 0) {
  result = "비김";
} else if (com == 1) {
  result = "com 승";
} else {
  result = "player 승";
}
console.log(`결과: ${result}`);
