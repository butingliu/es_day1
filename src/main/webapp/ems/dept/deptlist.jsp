<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ems/js/jquery-1.8.3.js"></script>
    <script>
        function confirmDelete(url) {
            if (confirm("确认要执行该操作吗？")) {
                window.location.href = url;
            }
        }
    </script>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Operation(删除部门员工一并删除)
                    </td>
                </tr>
                <c:forEach items="${list}" var="l">
                    <tr class="row1">
                        <td>
                                ${l.id}
                        </td>
                        <td>
                                ${l.name}
                        </td>
                        <td>
                            <a href="javascript:void(0)"
                               onclick="confirmDelete('${pageContext.request.contextPath}/department/deletedepartment?id=${l.id} ');">delete
                                emp</a>&nbsp;<a
                                href="${pageContext.request.contextPath}/department/updatedepartment1?id=${l.id}">update
                            emp</a>&nbsp;<a
                                href="${pageContext.request.contextPath}/employees/showemployees?id=${l.id}">show
                            emps</a>
                        </td>
                    </tr>
                </c:forEach>


            </table>
            <p>
                <input type="button" class="button" value="Add Dept"
                       onclick="location='${pageContext.request.contextPath}/ems/dept/addDept.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
