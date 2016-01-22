// 게시물 변경 기능 추가
// + POST 요청 파라미터 값 추출하는 방법
var http = require('http');
var mysql = require('mysql');
var url = require('url');
var dateFormat = require('dateformat');
var qs = require('querystring');

var pool  = mysql.createPool({
  connectionLimit : 10,
  host     : 'localhost',
  user     : 'java76',
  password : '1111',
  database : 'java76db'
});

// 커넥션풀에 새 커넥션이 생성되면 connection 이벤트가 발생한다.
pool.on('connection', function() {
  console.log("커넥션 객체가 생성되었음.");
});

var handlerMap = {};

handlerMap["/board/list.do"] = function(request, response) {
  pool.query(
      'select bno, title, views, cre_dt from board', 
      function(err, rows, fields) { 
        if (err) throw err;
        response.writeHead(200, {
          'Content-Type' : 'text/html;charset=UTF-8' 
        });
        response.write("<!DOCTYPE html>\n");
        response.write("<html>\n");
        response.write("<head>\n");
        response.write("<meta charset=\"UTF-8\">\n");
        response.write("<title>게시판</title>\n");
        response.write("</head>\n");
        response.write("<body>\n");
        response.write("<h1>게시물 목록</h1>\n");
        
        response.write("<table>\n");
        response.write("<tr>\n");
        response.write("  <th>번호</th><th>제목</th><th>조회수</th><th>작성일</th>\n");
        response.write("</tr>\n");
        
        for (var i = 0; i < rows.length; i++) {
          response.write("<tr>\n");
          response.write("  <td>" + rows[i].bno + "</td>\n");
          response.write("  <td><a href='detail.do?no=" 
              + rows[i].bno + "'>" 
              + rows[i].title + "</a></td>\n");
          response.write("  <td>" + rows[i].views + "</td>\n");
          response.write("  <td>" + dateFormat(rows[i].cre_dt,"yyyy-mm-dd") + "</td>\n");
          response.write("</tr>\n");
        }
        
        response.write("</table>");
        response.write("</body>\n");
        response.write("</html>\n");
        response.end();
    });
};

handlerMap["/board/detail.do"] = function(request, response) {
  var urlInfo = url.parse(request.url, true);
  pool.query(
      'select bno, title, content, views, cre_dt from board where bno=?',
      [urlInfo.query.no], 
    function(err, rows, fields) { 
      if (err) throw err;
      response.writeHead(200, {
        'Content-Type' : 'text/html;charset=UTF-8' 
      });
      response.write("<!DOCTYPE html>\n");
      response.write("<html>\n");
      response.write("<head>\n");
      response.write("<meta charset=\"UTF-8\">\n");
      response.write("<title>게시판</title>\n");
      response.write("</head>\n");
      response.write("<body>\n");
      response.write("<h1>게시물 상세정보</h1>\n");
      response.write("<form action='update.do' method='post'>\n");
      response.write("<table border='1'>\n");
      response.write("<tr>\n");
      response.write("  <th>번호</th>\n");
      response.write("  <td><input type='text' name='no' value='"
          + rows[0].bno + "'></td>\n");
      response.write("</tr>\n");
      response.write("<tr>\n");
      response.write("  <th>제목</th>\n");
      response.write("  <td><input type='text' name='title' value='"
          + rows[0].title + "'></td>\n");
      response.write("</tr>\n");
      response.write("<tr>\n");
      response.write("  <th>내용</th>\n");
      response.write("  <td><textarea name='content' rows='5' cols='50'>" 
          + rows[0].content + "</textarea></td>\n");
      response.write("</tr>\n");
      response.write("<tr>\n");
      response.write("  <th>조회수</th>\n");
      response.write("  <td>" + rows[0].views + "</td>\n");
      response.write("</tr>\n");
      response.write("<tr>\n");
      response.write(" <th>등록일</th>\n");
      response.write("  <td>"
          + dateFormat(rows[0].cre_dt,"yyyy-mm-dd") + "</td>\n");
      response.write("</tr>\n");
      
      response.write("</table>\n");
      response.write("<p>" 
          + "<input type='submit' value='변경'>"
          + "<a href='delete.do?no="
          + rows[0].bno + "'>삭제</a></p>\n");
      response.write("</form>\n");
      response.write("</body>\n");
      response.write("</html>\n");
      response.end();   
    });
};

handlerMap["/board/delete.do"] = function(request, response) {
  var urlInfo = url.parse(request.url, true);
  pool.query(
      'delete from board where bno=?',
      [urlInfo.query.no], 
    function(err, rows, fields) { 
      if (err) throw err;
      response.writeHead(302, {
        'Location' : '/board/list.do' 
      });
        response.end();   
   });
};

handlerMap["/board/update.do"] = function(request, response) {
  var urlInfo = url.parse(request.url, true);
  
  var message = '';
  // "data" 이벤트 => POST 요청 시,
  //                message-body 영역의 데이터를 읽을 때 발생하는 이벤트
  request.on('data', function(data) {
    message += data;
  });
  
  // "end" 이벤트 => POST 요청 시,
  //               message-body 영역의 데이터를 모두 읽었을 때 발생하는 이벤트
  request.on('end', function() {
    var params = qs.parse(message);
    pool.query(
        'update board set title=?, content=? where bno=?',
        [params.title, params.content, params.no], 
      function(err, rows, fields) { 
        if (err) throw err;
        response.writeHead(302, {
          'Location' : '/board/list.do' 
        });
          response.end();   
      });
  });
};



// 지원되지 않는 URL 요청 처리 함수
function notSupport(request, response) {
  response.writeHead(200, {
    'Content-Type' : 'text/html;charset=UTF-8' 
  });
  var urlInfo = url.parse(request.url, true);
  response.write("<!DOCTYPE html>\n");
  response.write("<html>\n");
  response.write("<head>\n");
  response.write("<meta charset=\"UTF-8\">\n");
  response.write("<title>오류</title>\n");
  response.write("</head>\n");
  response.write("<body>\n");
  response.write("<h1>해당 URL을 지원하지 않습니다.</h1>\n");
  response.write("</body>\n");
  response.write("</html>\n");
  response.end();
}

var httpServer = http.createServer(function(request, response) {
  var urlInfo = url.parse(request.url);
  
  var handler = handlerMap[urlInfo.pathname];
  
  if (handler) {
    handler(request, response);
  } else {
    notSupport(request, response);
  }
});

// 3) HTTP 서버 가동
httpServer.listen(8989);
console.log("서버 실행 중...");






















