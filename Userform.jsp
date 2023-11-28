<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.admin.Admin" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <li` class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath() %>/list">Users</a>
        </li>
        </ul>
        </div>
        </div>
        </nav>
        <c:if test="${list==null}">
        <form action="insert" method="post">
        </c:if>
        <c:if test="${list!=null}">
        <form action="update" method="post">
        </c:if>
        <h2>
        <c:if test="${list==null}">
        ADD USER
        </c:if>
        <c:if test="${list!=null}">
        EDIT USER
        </c:if>
        </h2>
        <div class="mb-3">
  <input type="hidden" class="form-control" id="id" name="id" value="${list.id}">
</div> 
       
 <div align="center" class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Name</label>
  <input type="text" class="form-control" id="name" name="name" value="${list.name}" placeholder="Enter Name" >
</div>      

<div align="center" class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Email </label>
  <input type="email" class="form-control" id="email" name="email" value="${list.email}" placeholder="Enter Email"  >
</div>
<div align="center" class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">City</label>
  <input type="text" class="form-control" id="city" name="city" value="${list.city}" placeholder="Enter City" >
</div>
<div align="center" class="mb-3 container">
<input type="submit" value="save" class="btn btn-success" style="width:150px"></div>
</form>
</form>
</body>
</html>