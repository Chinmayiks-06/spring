<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #000; /* Black background */
            margin: 0;
            padding: 0;
            color: white;
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
        .container {
            background: rgba(0, 0, 0, 0.7); /* Dark background with transparency */
            padding: 40px 30px;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
            text-align: center;
            width: 320px;
            margin: 100px auto; /* Center the container vertically */
        }
        h2 {
            margin-bottom: 25px;
            color: white;
            font-size: 24px;
            font-weight: bold;
            letter-spacing: 0.5px;
        }
        input {
            width: 100%;
            padding: 12px;
            margin: 15px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            background-color: #444; /* Darker input fields */
            color: white;
        }
        input:focus {
            border-color: #4CAF50; /* Green color for focus */
            outline: none;
        }
        .button-container {
            display: flex;
            justify-content: space-between;
        }
        button {
            width: 48%;
            padding: 12px;
            background-color: #4CAF50; /* Green button color */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button.back {
            background-color: #6c757d; /* Gray button for "Back" */
        }
        button:hover {
            opacity: 0.9;
        }
        .forgot-password {
            margin-top: 15px;
            font-size: 14px;
        }
        .forgot-password a {
            color: #4CAF50;
            text-decoration: none;
        }
        .forgot-password a:hover {
            text-decoration: underline;
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
            <a href="Registration.jsp">Sign Up</a>
            <a href="Signin.jsp">Login</a>
        </nav>
    </header>

    <!-- Main Content -->
    <div class="container">
        <h2>Login</h2>
         <span style="color:red">${valid}</span>

        <form action="signin" method="post">
            <span>${invalid}</span>
            <input type="email" id="email" name="email" placeholder="Email" value="${email}" required>
            <input type="password" id="password" name="password" placeholder="Password" required>
            <div class="button-container">
                <button type="submit">Sign In</button>
                <button type="button" class="back" onclick="history.back()">Back</button>
            </div>
            <div class="forgot-password">
                <a href="forgetPassword.jsp">Forgot Password?</a>
            </div>
        </form>
    </div>

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
