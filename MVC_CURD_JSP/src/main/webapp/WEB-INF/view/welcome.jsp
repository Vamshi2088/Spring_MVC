<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hello welcome to springmvc</h1>
<a href="./reg" text-align="center">Register_NEW_PERSON</a>
<table border="1" width="500" align="center">
        <tr bgcolor="red">
            <th>person ID</th>
            <th>person NAME</th>
            <th>person salary</th>
            <!--             <th>email</th> -->
            <th>Actions</th>
        </tr>
        <c:forEach var="prs" items="${ref}">

            <tr>
                <td>${prs.id}</td>
                <td>${prs.name}</td>
                <td>${prs.salary}</td>
                <td><a href="delete?id=${prs.id}">delete</a>
                 <a href="getbyid?id=${prs.id}">update</a></td>
            </tr>

        </c:forEach>
    </table>

</body>
</html>