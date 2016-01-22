// 특정 URL 요청 처리하기
var http = require('http');

var httpServer = http.createServer(function(request, response) {
	
	response.writeHead(200, { // 응답헤더
		'Content-Type' : 'text/html;charset=UTF-8' 
	});
	
	// favicon.ico 요청에 대해서는 처리를 하지 않는다.
	if (request.url != '/hello') {
		response.write("<!DOCTYPE html>\n");
		response.write("<html>\n");
		response.write("<head>\n");
		response.write("<meta charset=\"UTF-8\">\n");
		response.write("<title>오류</title>\n");
		response.write("</head>\n");
		response.write("<body>\n");
		response.write("<p>잘못된 URL입니다.</p>\n");
		response.write("</body>\n");
		response.write("</html>\n");
		response.end();
		return;
	}	
	
	response.write("<!DOCTYPE html>\n");
	response.write("<html>\n");
	response.write("<head>\n");
	response.write("<meta charset=\"UTF-8\">\n");
	response.write("<title>테스트</title>\n");
	response.write("</head>\n");
	response.write("<body>\n");
	response.write("<h1>nodejs 테스트</h1>\n");
	response.write("<p>안녕하세요!</p>\n");
	response.write("</body>\n");
	response.write("</html>\n");
	
	response.end();
});

httpServer.listen(8989);
console.log("서버 실행중...");