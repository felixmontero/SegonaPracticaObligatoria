<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <title>Login</title>

<link rel="stylesheet" href="/css/login.css">

</head>
<body style="background-image: url(https://img.freepik.com/vector-gratis/fondo-geometrico_23-2148573776.jpg?w=2000);">
<div id="login-form-wrap">
<div class="form-field">
 <h2>Has guanyat!</h2>
</div>

   <form method="post" action="/endform">
    <label for="username">Usuari:</label><br><br>
      <div class="form-field">
      <input type="text" placeholder="Poner Usuario" name="user" required><br><br>
      </div>
      <div class="form-field">
      <input type="submit" value="envia" class="btn">
      </div>
   </form>
</div>
</body>
</html>