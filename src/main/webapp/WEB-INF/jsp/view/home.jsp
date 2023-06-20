<%@ page import="com.mouhcine.ContactSpringBoot.bo.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>
<body>
<div class="container my-5">
    <div class="d-flex justify-content-between align-items-center my-4">
        <div>
            <a href="/" class="btn btn-primary">Contact</a>
            <a href="/groupes" class="btn btn-primary mx-4">Groupes</a>
        </div>
            <a class="btn btn-primary my-3" href="add">add new contact</a>
    </div>
    <c:if test="${not empty msg}">
        <div class="alert alert-success">
                ${msg}
        </div>
    </c:if>
    <c:set var="list" value="${data}"/>

    <form action="search">
    <div class="d-flex">
        <input type="search" name="search_value" value="${param.search_value}" class="form-control" placeholder="Searching ...">
        <select name="typeSearch" class="mx-4">
            <option value="nom">Nom</option>
            <option value="tel1">Tel Personnel</option>
            <option value="tel2">Tel Professionnel</option>
        </select>
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nom</th>
            <th scope="col">Prenome</th>
            <th scope="col">Email</th>
            <th scope="col">Email Professionnel</th>
            <th scope="col">Adress</th>
            <th scope="col">Genre</th>
            <th scope="col">Tel1</th>
            <th scope="col">Tel2</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contact" items="${list}">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.nom}</td>
                <td>${contact.prenome}</td>
                <td>${contact.email}</td>
                <td>${contact.emailProf}</td>
                <td>${contact.adress}</td>
                <td>${contact.genre}</td>
                <td>${contact.tel1}</td>
                <td>${contact.tel2}</td>
                <td>
                    <form action="edit" method="post">
                        <input type="hidden" name="contact_id" value="${contact.id}">
                        <button class="btn btn-primary">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="delete" method="post">
                        <input value="${contact.id}" name="contactId" type="hidden">
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
