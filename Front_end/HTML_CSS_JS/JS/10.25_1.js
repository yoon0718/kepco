function change() {
  var result = document.getElementById("demon");
  var first_val = document.getElementById("first").value;
  var first_val = parseInt(first_val);
  var second_val = document.getElementById("second").value;
  var second_val = parseInt(second_val);
  var result_val = first_val + second_val;

  result.innerHTML = result_val;
  console.log(result_val);
}
