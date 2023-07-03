<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>edit page</title>
</head>
<body>
<center>


    <h1>Edit Employee</h1>
    <%--@elvariable id="employeeDetails" type=""--%>
    <form:form modelAttribute="employeeDetails" action="UpdateEmployee" method="post">
        <label>employeeId :</label>
        <input name="employeeId" readonly  value="${Employee.employeeId}"/><br>
        <label>name :</label>
        <input name="name" value="${Employee.name}"/><br>
        <label>email :</label>
        <input name="email" value="${Employee.email}"/><br>
        <label>password :</label>
        <input name="password" value="${Employee.password}"/><br>
        <label>department :</label>
        <input name="department" value="${Employee.department}"/><br>
        <label>salary :</label>
        <input name="salary" value="${Employee.salary}"/><br>
        <label>phoneNumber :</label>
        <input name="phoneNumber" value="${Employee.phoneNumber}"/><br>
        <label>address :</label>
        <input name="address" value="${Employee.address}"/><br>

        <input type="submit" value="Update">
    </form:form>
    <br>
    <a href="/viewCompanyList">Back</a>
</center>
</body>
</html>