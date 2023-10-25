let score = Number(prompt("점수를 입력해 주세요"));
let hasPortfolio = true;
let isPass = true;
if ((hasPortfolio === true || isPass === true) && score >= 60) {
  console.log("채용");
} else {
  console.log("탈락");
}
