// delete 실행
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
    'delete from board where title=?',
    ['족발 사듀세여'], 
    function(err, rows, fields) { // 서버에서 결과를 받았을 때 호출되는 함수
      if (err) throw err;

      console.log("삭제 성공!!");
});

connection.end();
