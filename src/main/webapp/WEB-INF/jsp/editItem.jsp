<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改商品信息</title>

</head>
<c:choose>
    <c:when test="${empty itemsDto.id}">
        <c:set var="PATH_SUBMIT_URL" value="${pageContext.request.contextPath }/items/addItems"/>
        <c:set var="METHOD" value="POST"/>
    </c:when>
    <c:otherwise>
        <c:set var="PATH_SUBMIT_URL" value="${pageContext.request.contextPath }/items/editItems"/>
        <c:set var="METHOD" value="PUT"/>
    </c:otherwise>
</c:choose>
<body>
<!-- 错误信息 -->
<c:forEach items="${errors }" var="error">
    ${error.defaultMessage }<br/>
</c:forEach>
<form id="itemForm" action="${PATH_SUBMIT_URL}" method="${METHOD}" >
    <input type="hidden" name="id" value="${itemsDto.id }"/>
    修改商品信息：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${itemsDto.name }"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${itemsDto.price }"/></td>
        </tr>
        <tr>
            <td>商品编号</td>
            <td><input type="text" name="itemsCode" value="${itemsDto.itemsCode }"/></td>
        </tr>
<%--        <tr>
            <td>商品生产日期</td>
            <td><input type="text" name="createTime"
                       value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH-mm-ss"/>"/></td>
        </tr>--%>
        <tr>
            <td>商品图片</td>
            <td><input type="text" name="pic" value="${itemsDto.pic }"/></td>
        </tr>
        <%--<tr>
            <td>商品图片</td>
            <td>
                <c:if test="${itemsCustom.pic !=null}">
                    <img src="/pic/${itemsCustom.pic}" width=100 height=100/>
                    <br/>
                </c:if>
                <input type="file"  name="pictureFile"/>
            </td>
        </tr>--%>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${itemsDto.detail }</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>

</form>
</body>

</html>