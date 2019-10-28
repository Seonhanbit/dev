<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.2.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js">    </script>
    <script>
        $.ajax({
            // POST 전송을 위한 헤더 선언
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            "url": "http://localhost:9090/controller/api/restboard",
            "method": "post",
            "data": '{ "num": "ajax2131231", "title": "ajaxTitle", "content": "ajaxContent", "id":"idaf"}',
            "dataType": "json",
            "contentType": "application/json, charset=utf-8",
            "success": function (data, status, xhr) {
                $(data).each(function (index, item) {
                    console.log("num=" + item.num + ", title=" + item.title + ", content=" + item.content + ", id=" + item.id);
                });
            },
            "error": function (jqXHR, textStatus, errorThrown) {
                alert("에러가 발생하였습니다.");
                console.log(jqXHR);
                console.log(errorThrown);
            }
        });
    </script>
</head>
<body>
	<center>${message }</center>
	<h2>
		<a href="boardinsertpage">보드 입력</a>
	</h2>
	<h2>
		<a href="">보드 출력</a>
	</h2>
	<h2>
		<a href="boardlist">보드 리스트</a>
	</h2>
</body>
</html>