<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listProduct</title>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
    function search() {
        location.href = "product.do?action=listProduct&"
                + document.getElementById("search_sel").value + "="
                + document.getElementById("search_text").value;
    }
    $(document).ready(function() {
        $('.al').hover(function() {
            $.ajax({
                url : "product.do?action=viewProduct&button=true&num=" + $(this).parents("td").prev().text(),
                dataType : "html",
                success : function(data) {
                    //var hhh = $(data).html('table');
                    $('#view').html(data);
                },
                error : function() {
                }
            });
        },function(){
            $('#view').html("");
        });
    });
</script>
</head>
<body>
    <table>
        <tr>
            <td colspan="2" style="text-align: right;"><select
                id="search_sel">
                    <c:if test="${empty param.name and empty param.price}">
                        <option value="name" selected>상품명</option>
                        <option value="price">가격(이하)</option>
                        <td><input type="text" id="search_text" value=""></td>
                    </c:if>
                    <c:if test="${not empty param.name and empty param.price}">
                        <option value="name" selected>상품명</option>
                        <option value="price">가격(이하)</option>
                        <td><input type="text" id="search_text" value="${param.name}"></td>
                    </c:if>
                    <c:if test="${empty param.name and not empty param.price}">
                        <option value="name">상품명</option>
                        <option value="price" selected>가격(이하)</option>
                        <td><input type="text" id="search_text"
                            value="${param.price}"></td>
                    </c:if>
            </select></td>
            <td><input type="button" value="검색" onclick="search()"></td>
        </tr>
        <tr>
            <td colspan="4" bgcolor="pink"></td>
        </tr>
        <tr>
            <td colspan="4" bgcolor="pink"></td>
        </tr>
        <tr>
            <td width="100">등록번호</td>
            <td width="200">상품명</td>
            <td width="200">상품가격</td>
            <td width="200">상품설명</td>
        </tr>
        <tr>
            <td colspan="4" bgcolor="pink"></td>
        </tr>
        <c:forEach items="${productList}" var="product">
            <c:if
                test="${(empty param.name and empty param.price) or (not empty param.name and fn:contains(fn:toLowerCase(product.name), fn:toLowerCase(param.name))) or (not empty param.price  and param.price ge product.price)}">
                <tr>
                    <td>${product.num}</td>
                    <td><a class="al"
                        href="product.do?action=viewProduct&num=${product.num}">${product.name}</a></td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                </tr>
            </c:if>
        </c:forEach>
        <tr>
            <td colspan="4" bgcolor="pink"></td>
        </tr>
    </table>
    <div id="view"></div>
    <input type="button" value="상품 등록"
        onclick="location.href='product.do?action=addProductForm'">
</body>
</html>