<%@ page import="com.mouhcine.ContactSpringBoot.bo.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Groupe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>
<body>
<div class="container my-5">
    <div class="d-flex justify-content-between align-items-center my-4">
        <div>
            <a href="/" class="btn btn-primary">Contact</a>
            <a href="/groupes" class="btn btn-primary mx-4">Groupes</a>
        </div>
        <f:form method="POST" action="addGroupe" modelAttribute="groupeModel" cssClass="shadow p-3">
            <div class="mb-3">
                <label for="nom" class="form-label">Nom</label>
                <f:input class="form-control" path="nom"/>
            </div>
            <div class="d-grid gap-2">
                <input type="submit" class="btn btn-primary" value="Add groupe" />
            </div>
        </f:form>
    </div>
    <c:if test="${not empty msg}">
        <div class="alert alert-success">
                ${msg}
        </div>
    </c:if>
    <c:set var="list" value="${data}"/>



    <form action="searchGroupe">
        <div class="d-flex">
            <input type="search" name="search_value" value="${param.search_value}" class="form-control" placeholder="Searching ...">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nom</th>
            <th scope="col">Manage</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="groupe" items="${list}">
            <tr>
                <td>${groupe.id}</td>
                <td>${groupe.nom}</td>
                <td><a class="btn btn-primary" href="/groupes/${groupe.id}">Manage</a></td>
                <td>
                    <form action="deleteGroupe" method="post">
                        <input value="${groupe.id}" name="groupeId" type="hidden">
                        <button class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
