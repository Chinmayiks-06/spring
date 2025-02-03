<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="java.util.List" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="chin" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f8f8f8;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        a {
            text-decoration: none;
            color: #007bff;
            padding: 5px 10px;
            border-radius: 4px;
            margin-right: 10px;
        }

        a:hover {
            background-color: #007bff;
            color: white;
        }

        .container {
            max-width: 1200px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .table-container {
            max-width: 100%;
            overflow-x: auto;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Registration Details</h1>
        <div class="table-container">
            <table>
                <tr>
                   <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>password</th>
                    <th>confirm password</th>
                    <th>Action</th>
                </tr>
                <chin:forEach items="${ListOfUsers}" var="dto">
                    <tr>
                        <td>${dto.getUserId()}</td>
                        <td>${dto.getUserName()}</td>
                        <td>${dto.getEmailId()}</td>
                        <td>${dto.getPassword()}</td>
                        <td>${dto.getConfirmPassword()}</td>
                        <td>
                            <a href="delete?id=${dto.getUserId()}">Delete</a>&nbsp
                            <a href="edit?id=${dto.getUserId()}">Edit</a>
                        </td>

                    </tr>
                </chin:forEach>

            </table>
        </div>
    </div>

</body>
</html>
