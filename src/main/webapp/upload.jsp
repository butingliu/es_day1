<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/ems/css/style.css"/>
</head>

<body>
<h1>上传</h1>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="haha">
    <input type="submit" value="上传">
</form>
<h1>下载</h1>
<a href="${pageContext.request.contextPath}/file/download?name=123.sql">嘿嘿</a>
<a href="${pageContext.request.contextPath}/file/download?name=456.txt">哈哈</a>
<a href="${pageContext.request.contextPath}/file/download?name=day9-12.sql">哼哼</a>
</body>
</html>
