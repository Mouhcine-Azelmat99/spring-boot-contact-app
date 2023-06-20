<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Edit Contact</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>
<body>
<div class="container">

    <h1 class="my-5">Edit Contact</h1>
    <f:form method="POST" action="update" modelAttribute="contactModel">
        <div class="mb-3">
            <input type="hidden" value="${contactModel.id}" name="id">
        </div>
        <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <f:input class="form-control" path="nom"/>
        </div>
        <div class="mb-3">
            <label for="prenome" class="form-label">Prenome</label>
            <f:input class="form-control" path="prenome"/>
        </div>
        <div class="mb-3">
            <label for="emailProf" class="form-label">Email Professionel</label>
            <f:input class="form-control" type="email" path="emailProf"/>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <f:input class="form-control" type="email" path="email"/>
        </div>
        <div class="mb-3">
            <label for="tel1" class="form-label">Tel 1</label>
            <f:input path="tel1" class="form-control"/>
        </div>
        <div class="mb-3">
            <label for="tel2" class="form-label">Tel 2</label>
            <f:input path="tel2" class="form-control"/>
        </div>
        <div class="mb-3">
            <label for="adress" class="form-label">Adress</label>
            <f:input path="adress" class="form-control"/>
        </div>
        <div class="mb-3">
            <label for="genre" class="form-label">Genre</label>
            <f:select path="genre" class="form-control">
                <f:option value="male">Male</f:option>
                <f:option value="female">Female</f:option>
            </f:select>
        </div>
        <input type="submit" class="btn btn-primary" value="Update" />
    </f:form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
