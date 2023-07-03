<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="signUpAction" method="post">
    <table>
        <tr>
            <td>USERNAME:</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>PASSWORD:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>ROLE:</td>
            <td><select name="role" id="role">
                <option value="ROLE_USER">USER</option>
            <option value="ROLE_ADMIN">ADMIN</option>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit" name="submit"></td>
            <td><input type="reset" value="reset" name="reset"></td>
        </tr>
    </table>
</form>
<a href="./login"> login</a>
</body>
</html>
