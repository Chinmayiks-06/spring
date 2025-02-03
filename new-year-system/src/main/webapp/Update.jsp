<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
    <style>
        body {
            background-color: white; /* Changed background color to white */
            color: black; /* Adjusted text color to black for readability */
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        header {
            width: 100%;
            background-color: #333;
            padding: 10px 20px;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 1000;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
            display: flex;
            justify-content: flex-end; /* Align the link to the right */
            align-items: center;
        }

        header a {
            color: #4caf50;
            text-decoration: none;
            font-size: 16px;
        }

        form {
            background-color: #f5f5f5; /* Light background for form */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 90%;
            max-width: 400px;
            margin-top: 80px; /* To avoid overlapping with the fixed header */
            color: black; /* Ensure text color is readable on light background */
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"],
        input[type="file"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            margin-top: 15px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        h2 {
            text-align: center;
        }

        @media (max-width: 480px) {
            form {
                padding: 15px;
            }

            input[type="text"],
            input[type="email"],
            input[type="date"],
            input[type="file"],
            input[type="submit"] {
                font-size: 12px;
                padding: 8px;
            }

            input[type="submit"] {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <header>
        <nav style="background-color: #333; color: white; padding: 10px 20px; display: flex; align-items: center; justify-content: space-between;">
            <!-- Left Side -->
            <a href="Signin.jsp" style="color: #4caf50; text-decoration: none; font-size: 16px;">Update Profile</a>

            <!-- Right Side -->
            <div style="display: flex; align-items: center; gap: 1rem;">
                <!-- User Image -->
                <img style="border-radius: 50%; height: 30px; width: 30px;" src="view/${dto.getFileName()}">

                <div style="color: white;">
                    <p style="margin: 0;">Hi, <span style="font-weight: bold;">${dto.getFirstName()}</span></p>
                </div>
            </div>
        </nav>
    </header>

    <!-- Form Section -->
    <form action="updateProfile" method="post" enctype="multipart/form-data">
        <h2>Update Information</h2>
        <h2>${success}</h2>
        <label for="id"></label>
       <input type="hidden" id="id" name="id" value="${dto.getId()}" readonly>

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${dto.getFirstName()}" required>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${dto.getLastName()}" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${dto.getEmail()}" required>

        <label for="alterEmail">Alternate Email:</label>
        <input type="email" id="alterEmail" name="alterEmail" value="${dto.getAlterEmail()}" required>

        <label for="contact">Contact:</label>
        <input type="text" id="contact" name="contact" value="${dto.getContact()}" required>

        <label for="alterContact">Alternate Contact:</label>
        <input type="text" id="alterContact" name="alterContact" value="${dto.getAlterContact()}" required>

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" value="${dto.getDob()}" required>

        <label for="place">Place:</label>
        <input type="text" id="place" name="place" value="${dto.getPlace()}" required>

        <label for="state">State:</label>
        <input type="text" id="state" name="state" value="${dto.getState()}" required>

        <label for="district">District:</label>
        <input type="text" id="district" name="district" value="${dto.getDistrict()}" required>

        <label for="file">Upload File:</label>
        <input type="file" name="file">

        <input type="submit" value="Update">
    </form>
</body>
