<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  <title>Forgot Password</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #121212; /* Dark background */
      color: #fff;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
      background-image: url('https://www.example.com/lamp-image.jpg'); /* Replace with your lamp image */
      background-size: cover;
      background-position: center;
    }

    .container {
      background-color: rgba(0, 0, 0, 0.7);
      padding: 20px;
      border-radius: 8px;
      width: 100%;
      max-width: 400px;
      text-align: center;
    }

    h2 {
      margin-bottom: 20px;
    }

    input[type="email"], input[type="password"] {
      width: 100%;
      padding: 12px;
      margin: 10px 0;
      border-radius: 4px;
      border: 1px solid #ccc;
      background-color: #333;
      color: #fff;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      padding: 14px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      width: 100%;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }

    .message {
      color: #f44336;
      margin-top: 10px;
    }

    .back-link {
      margin-top: 20px;
      display: block;
      color: #fff;
      text-decoration: none;
      font-size: 14px;
    }

    .back-link:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

  <div class="container">
  <span>${valid}</span>
    <h2>Forgot Password</h2>
    <form action="validateOtp" method="post">
      <input type="email" name="email" id="email" placeholder="Enter your email" value="${email}"/><br>
      <span id="message"></span>
     <input type="button" onclick="otpSent()" value="sendOtp" name="otp">
     <br>
     <input type="text"  placeholder="Enter your otp" name="otp">
     <input type="submit" value="submit"  >
    </form>

    <script>
    const otpSent = async () => {
    const email= document.getElementById("email").value;
    console.log(email)
    const response = await axios("http://localhost:8080/new-year-system/api/sendOtp/"+email)
    console.log(response)
    document.getElementById("message").innerHTML=response.data;
    }

    </script>
    <a href="resetPassword.jsp" class="back-link"></a>
  </div>

</body>
</html>
