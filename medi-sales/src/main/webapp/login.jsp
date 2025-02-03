<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medi Sales - Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        /* Header */
        header {
            background: linear-gradient(45deg, #000000, #bbeef3);
            color: white;
            padding: 10px 20px;
            text-align: center;
            position: sticky;
            top: 0;
            z-index: 1000;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        header .logo {
            display: flex;
            align-items: center;
        }

        header .logo img {
            height: 40px;
            margin-right: 10px;
        }

        header nav {
            display: flex;
        }

        header nav a {
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            margin: 0 10px;
            font-size: 16px;
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.2s;
        }

        header nav a:hover {
            background-color: #575757;
            transform: scale(1.1);
        }

        /* Login Section */
        .login-section {
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(100vh - 200px);
            padding: 20px;
            background-color: #ffffff;
        }

        .login-form {
            background-color: #ffffff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            padding: 30px;
            border-radius: 8px;
            width: 100%;
            max-width: 400px;
        }

        .login-form h2 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
            text-align: center;
        }

        .login-form label {
            display: block;
            font-size: 14px;
            margin-bottom: 5px;
            color: #555;
        }

        .login-form input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        .login-form button {
            width: 100%;
            padding: 10px;
            background: linear-gradient(45deg, #000000, #bbeef3);
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-form button:hover {
            background-color: #575757;
        }

        .login-form .forgot-password {
            text-align: center;
            margin-top: 10px;
        }

        .login-form .forgot-password a {
            color: #007bff;
            text-decoration: none;
        }

        .login-form .forgot-password a:hover {
            text-decoration: underline;
        }

        /* Footer */
        footer {
            background: linear-gradient(45deg, #bbeef3, #000000);
            color: white;
            text-align: center;
            padding: 15px 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        footer p {
            margin: 5px 0;
            font-size: 0.9em;
        }

        footer .social-links {
            margin-top: 10px;
            display: flex;
            gap: 15px;
            justify-content: center;
        }

        footer .social-links a {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            width: 36px;
            height: 36px;
            border-radius: 50%;
            background-color: #444;
            transition: background-color 0.3s, transform 0.2s;
        }

        footer .social-links a:hover {
            background-color: #666;
            transform: scale(1.1);
        }

        footer .social-links a img {
            height: 18px;
            width: 18px;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <header>
        <div class="logo">
            <img src="https://raw.githubusercontent.com/X-workzDev01/xworkzwebsite/master/src/main/webapp/assets/images/Logo.png" alt="Medi Sales Logo">
        </div>
        <nav>
            <a href="index">Home</a>
        </nav>
    </header>

    <!-- Login Section -->
    <div class="login-section">
             <span style="color:red">${valid}</span>
        <form class="login-form" action="signin" method="POST">
            <h2>Login</h2>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>

            <button type="submit">Login</button>

            <div class="forgot-password">
                <a href="/forgot-password">Forgot Password?</a>
            </div>
        </form>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2025 Medi Sales. All rights reserved.</p>
        <div class="social-links">
            <a href="https://www.instagram.com" target="_blank" aria-label="Instagram">
                <img src="https://upload.wikimedia.org/wikipedia/commons/a/a5/Instagram_icon.png" alt="Instagram">
            </a>
            <a href="https://www.facebook.com" target="_blank" aria-label="Facebook">
                <img src="https://upload.wikimedia.org/wikipedia/commons/5/51/Facebook_f_logo_%282019%29.svg" alt="Facebook">
            </a>
            <a href="https://www.linkedin.com" target="_blank" aria-label="LinkedIn">
                <img src="https://upload.wikimedia.org/wikipedia/commons/e/e9/Linkedin_icon.svg" alt="LinkedIn">
            </a>
        </div>
    </footer>
</body>
</html>
