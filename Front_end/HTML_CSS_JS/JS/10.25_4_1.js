const count = 17; // integer
//number
const size = 17.1; // decimal number
console.log(`value: ${count}, type: ${typeof count}`);
console.log(`value: ${size}, type: ${typeof size}`);

const infinity = 1 / 0;
const negativeInfinity = -1 / 0;
const nan = "not a number" / 2;
console.log(infinity);
console.log(negativeInfinity);
console.log(nan);

let score = 90.5;
console.log(Number(score));
console.log(parseInt(score));

let height = "177.3";
console.log(Number(height));
console.log(parseInt(height));

let bool = true;
console.log(Number(bool));
console.log(parseInt(bool));
//string
const char = "c";
const username = "developer";

const greeting = "hello " + username;
console.log(`value: ${greeting}, type: ${typeof greeting}`);

const template = `hi ${username}!`; // template literals
console.log(`value: ${template}, type: ${typeof template}`);
//string(indexing / 함수)
const str = "JavaScript";
console.log(`str: ${str}`);
console.log(`str[0]: ${str[0]}`);
console.log(`str[str.length-1]: ${str[str.length - 1]}`);
console.log(`str.substring(0, 4): ${str.substring(0, 4)}`);
console.log(`str.slice(-6, str.length): ${str.slice(-6, str.length)}`);
console.log(`str.indexOf('S'): ${str.indexOf("S")}`);
console.log(`str.split('S'): ${str.split("S")}`);
//boolean
const canRead = true;
console.log(`value: ${canRead}, type: ${typeof canRead}`);

const test = 3 < 1;
console.log(`value: ${test}, type: ${typeof test}`);
//null / undefined
let nothing = null;
console.log(`value: ${nothing}, type: ${typeof nothing}`);

let x = undefined; // let x;
console.log(`value: ${x}, type: ${typeof x}`);
