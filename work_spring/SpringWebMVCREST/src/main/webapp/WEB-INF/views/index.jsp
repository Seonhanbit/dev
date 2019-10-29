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
    $(document).ready(function() {
		$.ajax({
			url : "./api/restboard",
			type : "get",
			dataType : "json",
			success : function(data) {
				var tableData = "";
				tableData += '<tr>';
				tableData += '<th>번호</th>';
				tableData += '<th>제목</th>';
				tableData += '<th>내용</th>';
				tableData += '</tr>';
				$.each(data, function() {
					tableData += '<tr>';
					tableData += '<td>' + this.num + '</td>';
					tableData += '<td>' + this.title + '</td>';
					tableData += '<td>' + this.content + '</td>';
					tableData += '</tr>';
				});
				$("#view").append(tableData);
			},
			error : function() {
				alert("fail");
			}
		});
	});
    
    
    //혜선이 코드
    function action(action,method){
    	//받아오는 변수
    	var in_num = $("#in_num").val();
    	var in_title = $("#in_title").val();
    	var in_content = $("#in_content").val();
    	var in_id = $("#in_id").val();    	
    	
    	var url="http://localhost:9090/controller/api/restboard"
    	
    	if(action=='sch'||action=='del'){
    		url +='/'+in_num;
    	}
    	//json타입으로 바꿔주기
    	var sendData = '{"num":' + in_num+', "title :"'+in_title +', "content :"'+in_content +', "id :"'+in_id+'}'
    	if(method=='get'){
    		sendData='';
    	}
    	$.ajax({
            // POST 전송을 위한 헤더 선언
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: url,
            method: method,
            data : sendData,
            dataType: "json",
            contentType: "application/json, charset=utf-8",
            success: function (data) {
                $('#resultView').children('tr').remove();
                $.each(list, function( index, item ) {
                	$('#resultView').append("<tr> <td>"+item.num+"</td> <td>"+item.title+"</td> <td>"+item.content+"</td> <td>"+item.id+"</tr>");
                 });
              
             },
             error: function (jqXHR, textStatus, errorThrown) {
                 alert("에러가 발생하였습니다.");
                 console.log(jqXHR);
                 console.log(errorThrown);
             }
    	});
    }
    
    
    
/*     function searchAll() {
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
	} */
	
    </script>
</head>
<body>
	<center>${message }</center>
	<h1>ajax 보드리스트</h1>
	<table id="view" border="1"></table>
	<input type="button" onclick="location.href='/controller'" value="메인" />
	<br>
	
	
<!-- 	  <section>
        <div>
            <table>
                <tr></tr>
                <tr>
                    <td id="in_num"></td>
                    <td id="in_title"></td>
                    <td id="in_content"></td>
                    <td id="in_id"></td>
                </tr>
            </table>
        </div>
    </section> -->
    
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