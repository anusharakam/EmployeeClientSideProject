<html>
<head><title>Login</title></head>
<center>
    <h1>Login Page</h1>
    <form name='loginForm'  action="${pageContext.request.contextPath}/login" method='post'>
        <table>
            <tr>
                <td>User Name:</td>
                <td><input type='text' name="userName" placeholder="Enter User Name">
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name="password" placeholder="Enter Password" />
                </td>
            </tr>
            <tr>
                <td><input name="submit" type="submit"
                           value="submit" />
                </td>
                <td><input name="reset" type="reset" />
                </td>
            </tr>
        </table>
        <a href="registrationForm">Sign up</a>
    </form>
</center>
</html>
