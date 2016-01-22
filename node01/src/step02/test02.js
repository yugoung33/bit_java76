// Database에 연결하기

// 1) 라이브러리 가져오기
// 프로젝트 폴더에서 다음 명령을 실행하여 nodejs 라이브러리를 가져온다.
// => npm install mysql
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
    'select bno, title from board',
    function(err, rows, fields) { // 서버에서 결과를 받았을 때 호출되는 함수
      if (err) throw err;
      
      for (var i = 0; i < rows.length; i++) {
        console.log(rows[i].bno, rows[i].title);
      }
});

connection.end();
