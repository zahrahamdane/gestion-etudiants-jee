<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="style.css" />
    <title>Login</title>
  </head>
  <body>
    <div class="login-container">
      <h2>Connexion</h2>
      <form action="login" method="post">
        <div class="form-group">
          <label for="username">Nom d'utilisateur :</label>
          <input type="text" id="username" name="username" required />
        </div>

        <div class="form-group">
          <label for="password">Mot de passe :</label>
          <input type="password" id="password" name="password" required />
        </div>

        <div class="form-group">
          <button type="submit">Se connecter</button>
        </div>
      </form>
    </div>
  </body>
</html>
