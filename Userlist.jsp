<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.admin.Admin" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER MANAGEMENT SYSTEM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand">User Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath() %>">Users</a>
        </li>
        </ul>
        </div>
        </div>
        </nav>
        <h1 style="color:blue" align="center">User Management System</h1>
        <hr>
        <hr>
        <br>
        <div class="container">
        <a href="<%=request.getContextPath() %>/add"
        class="btn btn-success">Add User</a></div>
        <br>
        <br>
        <table class="table table-striped">
        <thead>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>City</th>
        <th>Actions</th>
        </thead>
        <tbody>
        <a:forEach items="${display}" var="u">
        <tr>
        <td><a:out value="${u.id}"></a:out></td>
        <td><a:out value="${u.name}"></a:out></td>
        <td><a:out value="${u.email}"></a:out></td>
        <td><a:out value="${u.city}"></a:out></td>
        <td><a href="edit?id=<a:out value="${u.id}"></a:out>">Edit</a> &nbsp;&nbsp; <a href="delete?id=<a:out value="${u.id}"></a:out>">Delete</a>
        </td>
        </tr>
        </a:forEach>
        </tbody>
        </table>
</body>
</html>