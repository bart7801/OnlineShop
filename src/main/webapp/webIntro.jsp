<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Unlock" rel="stylesheet">
    <link rel="stylesheet" href="cssStyle/webIntro.css">
    <title>webIntro.jsp</title>
    <%
        String name = (String) request.getSession().getAttribute("button");
    %>
</head>
<body>
<h1 id="header"> Hello <span style="color: red"><%=name%></span> . Would you like start shopping?</h1>

<div id="forms">
    <form method="post" action="ReadProductsServlet">
        <input class="inp" type="submit" value="Let`s start"/>
    </form>
    <form method="post" action="log.jsp">
        <input class="inp" type="submit" value="Go back"/>
    </form>
    <form method="post" action="changeDetails.jsp">
        <input class="inp" type="submit" value="Change details"/>
    </form>
</div>
</body>
</html>
