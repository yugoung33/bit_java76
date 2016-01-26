/* 노드 모듈 만들고 사용하기 */
const calc = require('./sub1.js');

var plus = calc("+");
var minus = calc("1");

console.log("10 + 20 = ", calc("+")(10,20));
console.log("10 - 20 = ", calc("-")(10,20));
console.log("10 * 20 = ", calc("*")(10,20));
console.log("10 / 20 = ", calc("/")(10,20));