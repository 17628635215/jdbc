<%@ page import="java.util.List" %>
<%@ page import="domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    * {
        margin: 0px;
        padding: 0px;
    }
    .t1{
        text-align: center;
    }
</style>
<body>
    <center>
        <h1 style="margin-top: 20vh;margin-bottom: 20px;">学生信息表1</h1>
        <table class="t1" border="1" cellspacing="0" width="500px">
            <thead>
            <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>电话</th>
                <th>邮箱</th>
            </tr>
            </thead>
            <tbody class="tbody">
                <c:forEach items="${sessionScope.user}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.sex}</td>
                        <td>${user.age}</td>
                        <td>${user.tel}</td>
                        <td>${user.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h1 style="margin-top: 20vh;margin-bottom: 20px;">学生信息表2</h1>
        <table class="t1" border="1" cellspacing="0" width="500px">
            <thead>
            <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>电话</th>
                <th>邮箱</th>
            </tr>
            </thead>
            <tbody class="tbody">
                <%
                    List<User> users = (List<User>) session.getAttribute("user");
                    for (User user:users){
                %>
                <tr class="row">
                    <td class="r1"><%=user.getId()%></td>
                    <td class="r1"><%=user.getName()%></td>
                    <td class="r1"><%=user.getSex()%></td>
                    <td class="r1"><%=user.getAge()%></td>
                    <td class="r1"><%=user.getTel()%></td>
                    <td class="r1"><%=user.getEmail()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </center>
</body>
</html>
