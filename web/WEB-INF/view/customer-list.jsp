<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Customer List</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/tt.css"/>
</head>
<body>
<h1>Customer List Management</h1>
<br/>
<div id="inline">
    <div id="one">
<a class="btn add" href="${pageContext.request.contextPath}/customer/add">Add Customer</a>
    </div>
    <div id="two">
        <form class="search" action="/customer/search-list" method="GET">
            <input type="search" name="search" value="${search}" placeholder="Who are you looking for?">
            <button type="submit">Search</button>
        </form>
    </div>
</div>
<div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
    </table>
</div>

<div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" class="sortable">
        <tbody>

        <c:forEach items="${customers}" var="customer">
            <c:url var="updateLink" value="/customer/update">
                <c:param name="id" value="${customer.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/customer/delete">
                <c:param name="id" value="${customer.id}"/>
            </c:url>

            <tr>
                <td>${customer.id}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>
                    <a href="${updateLink}">Update</a>
                    <a href="${deleteLink}"
                       onclick="if (!(confirm('Customer will be deleted from database! Are you sure?')))return false">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
