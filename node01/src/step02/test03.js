// insert 실행
var mysql = require('mysql');    // mysql 연동 라이브러리 객체 준비

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'java76',
  password : '1111',
  database : 'java76db'
});

connection.connect();

// select 질의하기
connection.query(
    'insert into board(title, content, cre_dt) values(?,?,now())',
    ['족발이 먹고 싶어요','무슨족발이 맛있을까요'],   // in-param에 들어갈 값을 배열에 담는다.
    function(err, rows, fields) { // 서버에서 결과를 받았을 때 호출되는 함수
      if (err) throw err;

      console.log("입력 성공!!");
});

connection.end();
