const lotto = [1, 8, 16];
let cnt = 0;
let a = 1;
while (a) {
  const selected = [];

  while (selected.length < 3) {
    const num = parseInt(Math.random() * 45) + 1;
    if (selected.indexOf(num) == -1) {
      selected.push(num);
    }
  }
  selected.sort((a, b) => a - b);
  console.log(selected);
  if (lotto == selected.toString()) {
    console.log("맞히기 성공");
    cnt += cnt + 1;
    a = 0;
  } else {
    console.log("맞히기 실패");
    cnt += cnt + 1;
  }
}
