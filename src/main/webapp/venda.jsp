<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Game Store - Vendas</title>

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>

        <div class="wrapper">
            <div style="margin-bottom: 15px;">
                <button type="button" class="btn btn-secondary btn-lg" id="liberacadastro">Cadastro</button>
            </div>

            <div id="cadastro">
                <form action="${pageContext.request.contextPath}/RealizarVendaServle" method="post"> 
                           
                    <div class="form-row">
                        <div class="form-group col-md-8">
                            <label for="servico">Nome</label>
                            <input type="text" class="form-control" name="nomeComprador" value="${venda.nomeComprador}" >
                        </div>

                        <div class="form-group col-md-4">
                            <label for="calendario">Data da Compra</label>
                            <input type="text" class="form-control" id="calendario" name="data" value="${venda.data}" >
                        </div> 
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cpf">Cartão Comprador</label>
                            <input type="text" class="form-control" name="cartaoComprador" value="${venda.cartaoComprador}" >
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="telefone">Id Venda</label>
                                <input type="text" class="form-control" id="telefone" name="idVenda" value="${venda.idVenda}">
                            </div>

                            <div class="form-group col-md-6">
                                <label for="endereco">Id Filial</label>
                                <input type="text" class="form-control" id="endereco" name="idFilial" value="${venda.idFlial}">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="email">Id Produto</label>
                                <input type="text" class="form-control" id="email" name="email" value="${venda.idProduto}">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-4">
                            </div>
                            <div class="form-group col-md-4 text-center">
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Cadastrar</button>
                            </div>
                            <div class="form-group col-md-4">
                            </div>
                        </div>

                </form>

            </div>

    </body>
</html>
