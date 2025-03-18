<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Kiosk Using AWS Rekognition</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
        }
        h1 {
            color: #2c3e50;
        }
        p {
            font-size: 16px;
        }
        ul {
            background: #f4f4f4;
            padding: 15px;
            border-radius: 5px;
        }
        li {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <h1>Smart Kiosk Using AWS Rekognition</h1>
    <p>This system consists of an Android app and a Spring Boot server.</p>
    
    <ul>
        <li>The Android app captures a user's photo using the camera module.</li>
        <li>The photo is then sent to the Spring Boot server and deleted from the device.</li>
        <li>The server analyzes the user's age and gender based on the image and sends a personalized menu list to the app.</li>
    </ul>
</body>
</html>
