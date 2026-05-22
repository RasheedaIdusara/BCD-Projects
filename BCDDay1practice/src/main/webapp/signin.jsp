<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/13/2026
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<form action="signin" method="post">
    <table>
        <tr>
            <th>Email</th>
            <td><input name="email"/></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><input name="password" type="password"/></td>
        </tr>
        <tr>
            <td><button type="submit">Log In</button></td>
        </tr>
    </table>
</form>

</body>
</html>
