<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="getAdmin" method="post">
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
            <td><input type="text" name="role"></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit" name="submit"></td>
            <td><input type="reset" value="reset" name="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
