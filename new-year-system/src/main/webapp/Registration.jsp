<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Year Celebration Registration Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <script src="
    https://cdn.jsdelivr.net/npm/axios@1.7.9/dist/axios.min.js
    "></script>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: url('https://static.vecteezy.com/system/resources/previews/002/981/356/non_2x/sparkler-in-yellow-and-orange-light-on-a-black-background-free-photo.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #333;
        }
        header {
            background: linear-gradient(90deg, #000000, #333333);
            color: white;
            padding: 10px;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        header .new-year-banner {
            font-size: 28px;
            font-weight: bold;
        }
        header nav a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-size: 16px;
        }
        header nav a:hover {
            text-decoration: underline;
        }
        .form-container {
            max-width: 700px;
            margin: 50px auto;
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
        }
        .form-container h1 {
            color: #000000;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container .btn-primary {
            background: linear-gradient(90deg, #000000, #333333);
            border: none;
        }
        .form-container .btn-primary:hover {
            background: linear-gradient(90deg, #333333, #000000);
        }
        footer {
            background: linear-gradient(90deg, #000000, #333333);
            color: white;
            text-align: center;
            padding: 2px;
            position: fixed;
            bottom: 0;
            width: 100%;
            box-shadow: 0 -4px 6px rgba(0, 0, 0, 0.1);
        }
         header .logo {
                    display: flex;
                    align-items: center;
                }
                header .logo img {
                    height: 40px;
                    margin-right: 10px;
                }
        footer .social-links a {
            color: white;
            text-decoration: none;
            margin: 2px;
        }
        footer .social-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<header>
    <div class="d-flex justify-content-between align-items-center">
        <div class="logo d-flex align-items-center">
            <img src="https://raw.githubusercontent.com/X-workzDev01/xworkzwebsite/master/src/main/webapp/assets/images/Logo.png" alt="Xworkz ODC Logo">
        </div>
        <nav>
            <a href="index.jsp">Home</a>
            <a href="about.jsp">About</a>
            <a href="contact.jsp">Contact</a>
        </nav>
    </div>
</header>


<main class="container my-5">
    <div class="form-container">
        <h1>Registration Form</h1>
        <p class="text-center">Join us in the New Year celebration!</p>
        <form action="user" method="post">
            <div>
                <span style="font-size:0.7rem;color:red">${firstNameError}</span>
            </div>
            <div class="mb-3">
                <label class="form-label">Name:</label>
                <div class="row">
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First" value="${userDto.getFirstName()}" required>
                    </div>
                    <div>
                        <span style="font-size:0.7rem;color:red">${lastNameError}</span>
                    </div>
                    <label class="form-label">Last Name:</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last" value="${userDto.getLastName()}" required>
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">Email:</label>
                <div class="row">
                    <div class="col-md-6">
                    <div>
        <span id="emailError" style="color:red"></span>
        </div>
                        <input type="email" class="form-control" id="email" name="email"  placeholder="Email" onblur="checkEmail()" required>
                    </div>
                    <div class="col-md-6">
                        <input type="email" class="form-control" id="alternativeEmail" name="alterEmail" placeholder="Alternative Email">
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">Contact Numbers:</label>
                <div class="row">
                    <div class="col-md-6">
                        <input type="tel" class="form-control" id="contactNo" name="contact" placeholder="Contact Number" required>
                    </div>
                    <div class="col-md-6">
                        <input type="tel" class="form-control" id="alterContact" name="alterContact" placeholder="Alternative Contact">
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <label for="dob" class="form-label">Date of Birth:</label>
                <input type="date" class="form-control" id="dob" name="dob" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Address:</label>
                <input type="text" class="form-control" id="village" name="place" placeholder="Village" required>
            </div>
            <div class="mb-3">
                <label for="state" class="form-label">State:</label>
                <select class="form-select" id="state" name="state" required>
                    <option value="">Select State</option>
                    <option value="Karnataka">Karnataka</option>
                    <option value="Maharashtra">Maharashtra</option>
                    <option value="Andhra Pradesh">Andhra Pradesh</option>
                </select>
                <label for="district" class="form-label mt-3">District:</label>
                <select class="form-select" id="district" name="district" required>
                    <option value="">Select District</option>
                    <option value="hassan">Hassan</option>
                    <option value="mysore">Mysore</option>
                    <option value="mandya">Mandya</option>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Password:</label>
                <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Password" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Confirm Password:</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required>
            </div>
            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary">Register</button>
                <button type="reset" class="btn btn-secondary">Reset</button>
            </div>
        </form>
    </div>
</main>

<footer>
    <p>&copy; 2025 Event Management Company. All rights reserved.</p>
    <div class="social-links">
        <a href="https://www.instagram.com" target="_blank">Instagram</a>
        <a href="https://twitter.com" target="_blank">Twitter</a>
        <a href="https://www.linkedin.com" target="_blank">LinkedIn</a>
    </div>
</footer>

<script>
    // JavaScript code for dynamic district loading and form validation remains the same.
    async function checkEmail() {
    const email =document.getElementById("email").value
    console.log(email)
    const response = await axios("http://localhost:8080/new-year-system/api/checkEmail/" +email)
    if(response.data==="Email already exists"){
    document.getElementById("emailError").innerHTML=response.data
    }
    else{
    document.getElementById("emailError").innerHTML=""
    }
 }
</script>

</body>
</html>

