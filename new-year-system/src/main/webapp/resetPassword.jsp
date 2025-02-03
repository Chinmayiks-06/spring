<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <h2>Reset Password</h2>
    <form action="verify" method="post">
      <input type="email" name="email" placeholder="Enter your email" required>
      <input type="submit" value="verify">
    </form>
    <div class="message" id="message"></div>
    <a href="index.jsp" class="back-link">Back to Home</a>
  </div>

</body>
</html>























