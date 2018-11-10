<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/5
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <h2>---->UserList<----</h2>
    <c:forEach items="${userList}" var="user" varStatus="status">
        <p>>-----------------------<</p>
        <p>index:${status.count}</p>
        <p>userName:${user.userName}</p>
        <p>sex:${user.sex}</p>
        <p>age:${user.age}</p>
        <p>>-----------------------<</p>
    </c:forEach>
</body>
</html>
