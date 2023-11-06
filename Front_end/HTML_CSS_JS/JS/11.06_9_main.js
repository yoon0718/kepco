// 개별 import
// import { export이름1, export이름2 } from 'OOO.js';
// import { plus } from "../JS/11.06_9_module.js";
// 전체 import
// import * from 'OOO.js';
// import * as module from './05-15-module.js';
import { plus, minus, height, weight, Animal } from "../JS/11.06_9_module.js";

console.log(plus());
console.log(minus());

console.log(height);
console.log(weight);

const animal = new Animal("ShuShu");
console.log(animal.name);

// 별칭 사용
// import { export이름1 as 별칭1, export이름2 as 별칭2 }
// from 'OOO.js';

import {
  plus as p,
  minus as m,
  height as h,
  weight as w,
  Animal as A,
} from "../JS/11.06_9_module.js";

console.log(p());
console.log(m());

console.log(h);
console.log(w);

const animal1 = new A("ShuShu");
console.log(animal.name);
