<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
    function searchAll() {
    	alert("ffff");
    	$.ajax({
           	url: "http://localhost:9090/controller/api/restboard",
            method: "GET",
            dataType: "json",
            contentType: "application/json, charset=utf-8",
            success: function (data) {
               var list = data.json;
               $.each(list, function( index, value ) {
                   console.log( index + " : " + value.num ); //의 변수명을 써주면 된다.
                });
   
                alert("성공");
            	//$('#view').html($(data).filter('table'));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("에러가 발생하였습니다.");
                console.log(jqXHR);
                console.log(errorThrown);
            }
        });
	}
/*         $.ajax({
            // POST 전송을 위한 헤더 선언
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: "http://localhost:9090/controller/api/restboard",
            method: "post",
            data: '{ "num": "ajax2131231", "title": "ajaxTitle", "content": "ajaxContent", "id":"idaf"}',
            dataType: "json",
            contentType: "application/json, charset=utf-8",
            success: function (data, status, xhr) {
                $(data).each(function (index, item) {
                    console.log("num=" + item.num + ", title=" + item.title + ", content=" + item.content + ", id=" + item.id);
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("에러가 발생하였습니다.");
                console.log(jqXHR);
                console.log(errorThrown);
            }
        }); */
    </script>
</head>
<body>
	<center>${message }</center>
	<h2>
		<input type="button" value="ajax_보드 리스트 조회" onclick="searchAll()">
	</h2>
	<form id="view">
    <table border="1">
        <tr>
            <th>num</th>
            <th>title</th>
            <th>content</th>
            <th></th>
        </tr>
        <c:forEach items ="${list }" var = "b">
            <tr>
                <td>${b.num }</td>
                <td>${b.title }</td>
                <td>${b.content }</td>
                <td>${b.id }</td>
            </tr>
        </c:forEach>
    </table>
    </form>
    <table>
	
	<br>
	
	
	  <section>
        <div>
            <table>
                <tr></tr>
                <tr>
                    <td id="num"></td>
                    <td id="title"></td>
                    <td id="content"></td>
                    <td id="id"></td>
                </tr>
            </table>
        </div>
    </section>
    
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