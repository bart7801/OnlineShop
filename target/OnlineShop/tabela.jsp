<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="cssStyle/tabela.css">

    <title>Tabelka</title>
    <%

        String data = (String) request.getAttribute("button");

    %>
</head>
<body>

<div id="header">
    <h3>Witaj <%=data%>
    </h3>
    <h5>Here is the list of products offered...</h5>
</div>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Photo</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
</table>
</body>
</html>