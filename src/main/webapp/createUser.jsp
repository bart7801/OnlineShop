<%--
  Created by IntelliJ IDEA.
  User: bart
  Date: 2019-09-27
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="cssStyle/createUser.css">
    <title>CreateUser</title>
</head>
<body>
<main>
    <h3 id="header">Aby się zalgowac wypełnij formularz</h3>
    <form method="post" action="CreateUserServlet">
        <input type="text" name="create_name" placeholder="Name"/>
        <input type="text" name="create_surname" placeholder="Surname"/>
        <input type="text" name="create_userName" placeholder="UserName"/>
        <input type="text" name="create_password" placeholder="Password"/>
        <input type="submit" name="create_registry" value="Sign up"/>
    </form>
    <form action="log.jsp" method="post">
        <input type="submit" value="Back to login"/>
    </form>
</main>
</body>
</html>
