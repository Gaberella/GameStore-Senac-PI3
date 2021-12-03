<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="assets/css/testeLoginStyle.css" type="text/css" rel="stylesheet">
    <title>Game Store - Login</title>
  </head>
  <body>
      <h1>
          <c:out value="${msgErro}"></c:out>
      </h1>
    <div class="image">
       
      <div>
        <div class="container-fluid bg">
          <div class="row">
            <!-- posicionamento do box todo de login -->
            <div class="col-md-1"></div> 
            <!-- largura do box -->
            <div class="col-md-5">
                
                <!-- form start -->   
                <form class="form-container box-bg" method="post">
                      <!-- logo -->
                      <div class="logo">
                          <img src="assets/images/logo.png">
                      </div>
                      <div class="text">
                        <h1 class="text">Login Usuário</h1>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email </label>
                        <input type="email" class="form-control patas" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Insira o email">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Senha</label>
                        <input type="password" id="exampleInputPassword1" name="senha" placeholder="Senha">
                      </div>

                      <div class="col-md-12">
                        <button type="submit" class="btn btn-dark btn-lg btn-block">Entrar</button>
                        <button type="submit" class="btn btn-dark btn-lg btn-block">
                            <a href="index.html" class="link-voltar">Voltar</a>
                        </button>
                      </div>
                </form>
                </div>

              <!-- form end -->
            <div class="col-md4 col-sm-4 col-xs-12"></div>
          </div>
        </div>
      </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>