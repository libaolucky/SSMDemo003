<%--
  Created by IntelliJ IDEA.
  User: TJYSB
  Date: 2021/9/3
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台界面</title>
</head>
<body>
    <%--<h1>欢迎！管理员： ${sessionScope.adminInfo.adminName} 登录！</h1>--%>
    <h1>欢迎！用户
        ${requestScope.lname} 登录！
    </h1>
    <h2>你的账户密码是： ${requestScope.pwd}
    </h2>
</body>
</html>
