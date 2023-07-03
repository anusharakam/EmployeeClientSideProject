<html>
<head><title>Login</title></head>
<body>
<center>
    <h1>Login Page</h1>
    <%--    <c:if test="${error eq 'true'}"> <font color="red">${msg}</font></c:if>&ndash;%&gt;
        <font color="#008b8b">${logOutMsg} </font>&ndash;%&gt;--%>
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
</body>
</center>
</html>
