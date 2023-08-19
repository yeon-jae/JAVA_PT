<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <div class="container">
         <h1> Welcome to login page</h1>
           <pre>${errorMessage}</pre>
           <form method="post">
                Name:<input type="text" name="name">
                <br>
                Password:<input type="password" name="password">
                <input type="submit">
           </form>
    </div>
</body>
</html>