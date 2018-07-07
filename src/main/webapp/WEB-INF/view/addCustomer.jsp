<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

    <title>New Customer Form</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form-style.css"/>
</head>
<body>

<h1>Customer List Management</h1>
<div id="myForm">
    <h3>New Customer Form</h3>

    <form:form action="add" modelAttribute="customer" method="POST">
        <table>
            <tr>
                <td><span class="text">First Name </span><span class="red">*</span></td>
                <td><form:input path="firstName" required="required"/></td>
                <td></td>
            </tr>
            <tr>
                <td><span class="text">Lasst Name </span><span class="red">*</span></td>
                <td><form:input path="lastName" required="required"/></td>
                <td></td>
            </tr>
            <tr>
                <td><span class="text">Email </span><span class="red">*</span></td>
                <td><form:input path="email" required="required"/></td>
                <td></td>
            </tr>
            <tr>
                <td><a href="${pageContext.request.contextPath}/customer/list" class="btn">&laquo; Back</a></td>
                <td><input type="submit" value="Save" class="btn"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
