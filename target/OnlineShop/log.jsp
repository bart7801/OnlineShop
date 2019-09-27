<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Unlock" rel="stylesheet">
    <link rel="stylesheet" href="cssStyle/log.css">
    <title>LogForm</title>
</head>
<body>
<h1>Welcome in my shop. Please Sign in.</h1>
<div id="container">
    <form method="post" action="LoginServlet">
        <input type="text" name="name" placeholder="Name"/>
        <input type="text" name="surname" placeholder="Surname"/>
        <input type="password" name="code" placeholder="Password"/><br/>
        <input type="submit" value="log In" name="button"/>
    </form>
    <form method="post" action="CreateUserServlet">
        <input type="submit" value="Sign up" name="input5"/>
    </form>
</div>
</body>
</html>
