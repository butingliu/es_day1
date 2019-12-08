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
    <link href="${pageContext.request.contextPath}/ems/css/common.css" type="text/css" rel="stylesheet"/>
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
                Welcome (请显示当前登陆用户)!
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
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Bir
                    </td>
                    <td>
                        Dept
                    </td>
                    <td>
                        Operation(处理删除的友情提醒)
                    </td>
                </tr>
                <c:forEach items="${requestScope.list}" var="l">
                    <tr class="row1">
                        <td>
                                ${l.id}
                        </td>
                        <td>
                                ${l.name}
                        </td>
                        <td>
                                ${l.salary}
                        </td>
                        <td>
                                ${l.age}
                        </td>
                        <td>
                            <fmt:formatDate value="${l.bir}"></fmt:formatDate>
                        </td>
                        <td>
                                ${l.department.name}
                        </td>
                        <td>
                            <a href="javascript:void(0)"
                               onclick="confirmDelete('${pageContext.request.contextPath}/employees/deleteemployees?id=${l.id}');">delete
                                emp</a>&nbsp;<a
                                href="${pageContext.request.contextPath}/employees/updateemployees1?id=${l.id}">update
                            emp</a>
                        </td>
                    </tr>
                </c:forEach>

                <%--
                                        <tr class="row2">
                                            <td>
                                                2
                                            </td>
                                            <td>
                                                lishi
                                            </td>
                                            <td>
                                                20000
                                            </td>
                                            <td>
                                                20
                                            </td>
                                            <td>
                                                2012-12-12
                                            </td>
                                            <td>
                                                教学部
                                            </td>
                                            <td>
                                                <a href="emplist.jsp">delete emp</a>&nbsp;<a href="updateEmp.jsp">update emp</a>
                                            </td>
                                        </tr>--%>
            </table>
            <div class="pagination">
                <a class="firstPage"
                   href="${pageContext.request.contextPath}/employees/showemployees?id=${requestScope.id}&currentPage=${requestScope.currentPage-1}"/>&nbsp;
                <%--<span class="currentPage">1</span> <a
                    href="javascript:$.pageSkip(2);">2</a> <a
                    href="javascript:$.pageSkip(3);">3</a> <span class="pageBreak">...</span>--%>
                <c:forEach items="${requestScope.list1}" var="l" step="1">
                    <span><a
                            href="${pageContext.request.contextPath}/employees/showemployees?id=${requestScope.id}&currentPage=${step}"/>第${step+1}页</span>
                </c:forEach>
                <a class="nextPage"
                   href="${pageContext.request.contextPath}/employees/showemployees?id=${requestScope.id}&currentPage=${requestScope.currentPage+1}"/>">&nbsp;</a>
                <%--<a class="lastPage" href="javascript: $.pageSkip(6);">&nbsp;</a>
                <span class="pageSkip"> 共6页 到第<input id="pageNumber"
                    name="pageNumber" value="1" maxlength="9"
                    onpaste="return false;">页
                        <button type="submit">&nbsp;</button>
                </span>(请在全部功能完成后在处理分页)--%>
            </div>
            <p>
                <input type="button" class="button" value="Add Employee"
                       onclick="location='${pageContext.request.contextPath}/ems/emp/addEmp.jsp'"/>
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
