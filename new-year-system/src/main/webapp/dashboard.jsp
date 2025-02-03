<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Successfully Logged In</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            color: #333;
        }
        header {
            background-color: #333;
            color: white;
            padding: 15px 20px;
            text-align: center;
            position: sticky;
            top: 0;
            z-index: 1000;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        header .logo {
            display: flex;
            align-items: center;
        }
        header .logo img {
            height: 40px;
            margin-right: 10px;
        }
        header nav a {
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            margin: 0 15px;
            font-size: 16px;
        }
        header nav a:hover {
            background-color: #575757;
            border-radius: 5px;
        }
        h2 {
            color: #0000ff;
            text-align: center;
            margin-top: 200px;
        }
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        footer .social-links {
            margin-top: 10px;
        }
        footer .social-links a {
            color: white;
            text-decoration: none;
            padding: 10px;
            font-size: 20px;
            margin: 0 10px;
        }
        footer .social-links a:hover {
            color: #ddd;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <header>
        <div class="logo">
            <img src="https://raw.githubusercontent.com/X-workzDev01/xworkzwebsite/master/src/main/webapp/assets/images/Logo.png" alt="Xworkz ODC Logo">
        </div>
        <nav>
            <a href="index.jsp">Home</a>
            <a href="update?id=${dto.getId()}">Update Profile</a>
        </nav>
    </header>

    <!-- Main Content -->
    <h2>Successfully logged in ${dto.getFirstName()}</h2>
    <nav>
        <div style="text-align: center; margin-top: 20px;">
        </div>
    </nav>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 Xworkz. All rights reserved.</p>
        <div class="social-links">
            <a href="https://www.instagram.com" target="_blank">Instagram</a>
            <a href="https://twitter.com" target="_blank">Twitter</a>
            <a href="https://www.linkedin.com" target="_blank">LinkedIn</a>
        </div>
    </footer>
</body>
</html>
