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
                <button type="button" class="btn btn-secondary btn-lg" id="liberapesquisa">Listar</button>
            </div>

            <div id="cadastro">
                <form action="${pageContext.request.contextPath}/RealizarVendaServlet" method="post"> 
                           
                    <div class="form-row">
                        <div class="form-group col-md-8">
                            <label for="servico">Nome</label>
                            <input type="text" class="form-control" name="nome" value="${venda.nome}" >
                        </div>

                        <div class="form-group col-md-4">
                            <label for="endereco">Endereco</label>
                            <input type="text" class="form-control" id="calendario" name="endeteco" value="${venda.endereco}" >
                        </div> 
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="email">Email</label>
                            <input type="text" class="form-control" name="email" value="${venda.email}" >
                        </div>
                        
                        <div class="form-group col-md-6">
                            <label for="calendario">Data da Venda</label>
                            <input type="text" class="form-control" name="dataVenda" value="${venda.dataVenda}" >
                        </div>
                        
                        <div class="form-group col-md-6">
                            <label for="valorVenda">Valor total</label>
                            <input type="text" class="form-control" name="valorVenda" value="${venda.valorVenda}" >
                        </div>
                        
                        <div class="form-group col-md-6">
                            <label for="tipoPagamento">Tipo de Pagamento</label>
                            <select id="inputState" class="form-control" name="tipoPagamento" value="${cliente.tipoPagamento}">
                                <option selected>Selecione...</option>
                                <option value="1" <c:if test="${venda.tipoPagamento == 1}">selected</c:if>>Boleto</option>
                                <option value="2" <c:if test="${venda.tipoPagamento == 2}">selected</c:if>>Cartão de Débito</option>
                                <option value="3" <c:if test="${venda.tipoPagamento == 3}">selected</c:if>>Cartão de Crédito</option>

                            </select>
                        </div>

                        <div class="form-row">
                            
                            <div class="form-group col-md-6">
                                <label for="idFilial">Id Filial</label>
                                <input type="text" class="form-control" id="endereco" name="idFilial" value="${venda.idFlial}">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="idProduto">Id Produto</label>
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
