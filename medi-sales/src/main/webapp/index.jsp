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

        /* Main Section */
        .main-section {
            text-align: center;
            color: black;
            padding: 100px 10px;
            background: url('https://static.vecteezy.com/system/resources/previews/000/424/971/original/set-of-medicine-bottles-drugs-and-pills-on-counter-pharmacy-vector.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 300px;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .main-section h1 {
            font-size: 3em;
            margin: 0;
        }

        .main-section p {
            font-size: 1.2em;
            margin-top: 10px;
        }

        /* Footer */
        footer {
            background: linear-gradient(45deg, #bbeef3, #000000);
            color: white;
            text-align: center;
            padding: 15px 10px; /* Reduced padding */
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        footer p {
            margin: 5px 0;
            font-size: 0.9em; /* Slightly smaller text */
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
            width: 36px; /* Smaller button size */
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
            height: 18px; /* Smaller icon size */
            width: 18px;
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
        </nav>
    </header>

    <!-- Main Section -->
    <div class="main-section">
        <h1>Welcome to Medi Sales</h1>
        <p>Your trusted platform for finding the best medical sales.</p>
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
