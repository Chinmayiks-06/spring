<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medi Sales - Sign Up</title>
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
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .container h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        form {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
        }

        form div {
            display: flex;
            flex-direction: column;
        }

        form div.full-width {
            grid-column: span 2;
        }

        form label {
            font-size: 14px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        form input, form select {
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form input[type="submit"] {
            background-color: #007bff;
            color: white;
            font-size: 16px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        form input[type="submit"]:hover {
            background-color: #0056b3;
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
        .submit-btn {
            background: linear-gradient(45deg, #000000, #bbeef3);
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.2s;
        }

        .submit-btn:hover {
            background-color: #575757;
            transform: scale(1.1);
        }

    </style>
</head>
<body>
    <!-- Header -->
    <header>
        <div class="logo">
            <img src="https://raw.githubusercontent.com/X-workzDev01/xworkzwebsite/master/src/main/webapp/assets/images/Logo.png" alt="Medi Sales Logo">
            <span>Medi Sales</span>
        </div>
        <nav>
            <a href="index">Home</a>
        </nav>
    </header>

    <!-- Signup Form -->
    <div class="container">
        <h1>Registration Form</h1>
        <form action="signup" method="post">

                     <div>
                <label for="companyName">Company Name*</label>
                <input type="text" id="companyName" name="companyName" required>
                <span style="font-size:0.7rem;color:red">${companyNameError}</span>
            </div>
            <br>
            <div>
                <label for="contactPerson">Contact Person*</label>
                <input type="text" id="contactPerson" name="contactPerson" required>
                <span style="font-size:0.7rem;color:red">${contactPersonError}</span>
            </div>
            <div>
                <label for="businessType">Business Type*</label>
                <select id="businessType" name="businessType" required>
                    <option value="">Select</option>
                    <option value="Retail">Retail</option>
                    <option value="Wholesale">Wholesale</option>
                </select>
            </div>
            <div>
                <label for="regNumber">Registered Mobile*</label>
                <input type="tel" id="regNumber" name="regNumber" required>
                <span style="font-size:0.7rem;color:red">${mobileNumberError}</span>
            </div>
            <div>
                <label for="regEmail">Registered Email*</label>
                <input type="email" id="regEmail" name="regEmail" required>
                <span style="font-size:0.7rem;color:red">${emailError}</span>

            </div>
            <div>
                <label for="addressOne">Address 1*</label>
                <input type="text" id="addressOne" name="addressOne" required>
                <span style="font-size:0.7rem;color:red">${addressOneError}</span>

            </div>
            <div>
                <label for="addressSecond">Address 2</label>
                <input type="text" id="addressSecond" name="addressSecond">
            </div>
            <div>
                <label for="pincode">Pincode*</label>
                <input type="number" id="pincode" name="pincode" required>
                <span style="font-size:0.7rem;color:red">${pincodeError}</span>

            </div>
            <div>
                <label for="referral">Referral (Optional)</label>
                <input type="text" id="referral" name="referral">

            </div>
            <div>
                <label for="password">Password*</label>
                <input type="password" id="password" name="password" required>
                <span style="font-size:0.7rem;color:red">${passwordError}</span>

            </div>
            <div>
                <label for="confirmPassword">Confirm Password*</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
                <span style="font-size:0.7rem;color:red">${confirmPasswordError}</span>

            </div>
            <div class="full-width">
            <input type="submit" value="Register" class="submit-btn">
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
