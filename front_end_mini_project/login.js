/*var count = 0;
var imgchange = document.getElementById("imgBox");
setInterval(function () {
  count++;
  imgchange.src = "phoneimg" + count + ".PNG";
  if (count >= 4) {
    count = 0;
  }
}, 3000);*/
const imageUrls = [
  "phoneimg1.PNG",
  "phoneimg2.PNG",
  "phoneimg3.PNG",
  "phoneimg4.PNG",

  // ... 추가 이미지 URL들
];

// 이미지를 담을 컨테이너 요소
const imageContainer = document.getElementById("imageContainer");

// 이미지 요소 생성 및 초기화
imageUrls.forEach((imageUrl, index) => {
  const img = new Image();
  img.src = imageUrl;
  img.classList.add("fade-in-out");
  img.addEventListener("load", () => {
    // 첫 번째 이미지는 보이게 함
    if (index === 0) {
      img.style.opacity = 1;
    }
    imageContainer.appendChild(img);
  });
});

let currentImageIndex = 0;

function showNextImage() {
  const images = document.querySelectorAll(".fade-in-out");

  // 현재 이미지를 투명하게 만듦
  images[currentImageIndex].style.opacity = 0;

  // 다음 이미지를 나타나게 함
  currentImageIndex = (currentImageIndex + 1) % images.length;
  images[currentImageIndex].style.opacity = 1;
}

// 일정 시간 간격으로 다음 이미지를 보여줌 (예: 3초 후)
setInterval(showNextImage, 3000);
