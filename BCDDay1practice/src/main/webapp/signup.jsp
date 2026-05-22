<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/13/2026
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
<form action="signup" method="post">
    <table>
        <tr>
            <th>Name</th>
            <td><input name="name"/></td>
        </tr>
        <tr>
            <th>Mobile</th>
            <td><input name="mobile"/></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><input name="email"/></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><input name="password" type="password"/></td>
        </tr>
        <tr>
            <td><button>Submit</button></td>
        </tr>
    </table>
</form>
</body>
</html>
