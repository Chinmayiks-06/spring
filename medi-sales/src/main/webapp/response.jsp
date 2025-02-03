<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medi Sales</title>
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

        h2 {
            color: #0000ff;
            text-align: center;
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
            margin-top: 424px;
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
        h2{
        text-align :center;
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
            <a href="SignUp">Sign Up</a>
            <a href="login">Login</a>
            <a href="index">Home</a>
        </nav>
    </header>

    <!-- Main Content -->
    <h2 >Thank you ${name} for Registering</h2>
    <nav>
            <div style="text-align: center; margin-top: 20px;">
            </div>
        </nav>

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