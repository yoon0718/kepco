var count = 0;
var imgchange = document.getElementById("imgBox");
setInterval(function () {
  count++;
  imgchange.src = "phoneimg" + count + ".PNG";
  imgchange.style.transition = "all 1s";
  if (count >= 4) {
    count = 0;
  }
}, 3000);
