<%-- 
    Document   : vendas
    Created on : 24/11/2018, 16:54:40
    Author     : vyvis
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>PetShop TADES - Vendas</title>
   
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>

    <div class="wrapper">
        <jsp:include page="menu.jsp"></jsp:include>
        <div id="content">
            <div class="row">
                <div class="col-md-8">
                    <nav class="navbar navbar-default">
                        <div style="font-size: 20px; text-align: center;" id="clienteselecionado">Selecione um Cliente</div>
                    </nav>
                    <div class="navbar">
                        <table class="table" id="tabelaitens">
                            <thead>
                                <tr>
                                    <th>Cod.</th>
                                    <th>Nome</th>
                                    <th>Quantidade</th>
                                    <th>Valor</th>
                                    <th>Tipo</th>
                                    <th>Adicionar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${servicos}" var="s">
                                   <tr>
                                       <td>${s.id}</td>
                                        <td>${s.descricao} (
                                            <c:if test="${s.tamanhoAnimal == 1}">Pequeno</c:if>
                                            <c:if test="${s.tamanhoAnimal == 2}">Médio</c:if>
                                            <c:if test="${s.tamanhoAnimal == 3}">Grande</c:if>
                                            )</td>
                                        <td>100</td>
                                        <td>R$${s.preco}</td>
                                        <td>Serviço</td>
                                        <td style="text-align: center;"><span class="adicionarproduto glyphicon glyphicon-plus" aria-hidden="true"></span></td>
                                    </tr> 
                                </c:forEach>
                                    
                                <c:forEach items="${produtos}" var="p">
                                   <tr>
                                       <td>${p.idProduto}</td>
                                        <td>${p.nome} ${p.modelo}</td>
                                        <td>${p.quantidade}</td>
                                        <td>R$${p.preco}</td>
                                        <td>Produto</td>
                                        <td style="text-align: center;"><span class="adicionarproduto glyphicon glyphicon-plus" aria-hidden="true"></span></td>
                                    </tr> 
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="col-md-4">
                    <nav class="navbar navbar-default">
                        <div style="font-size: 10px; text-align: center;">
                            <select id="listaclientes" name="clientes" style="width: 100%; height: 28px;">
                                <option>Selecione um cliente</option>
                                <c:forEach items="${clientes}" var="c">
                                   <option value="${c.id}">${c.nome}</option>
                                </c:forEach>
                            </select>

                    </nav>
                    <div class="navbar" style="height:150px; overflow: auto;">
                        <table class="table" id="tabelacarrinho">
                            <thead>
                            </thead>
                            <tbody>
           
                            </tbody>
                        </table>
                    </div>
                    <div class="navbar">
                        Valor total <h4 id="valortotal">R$0</h4>
                    </div>

                    <div class="navbar">
                        <button type="button" class="btn btn-secondary btn-lg" id="finalizarvenda" style="width: 100%">
                            Finalizar venda</button>
                        <br><br>
                        <button type="button" class="btn btn-secondary btn-lg" id="exportarcadastros" style="width: 100%">
                            Cancelar</button>
                    </div>

                </div>
            </div>



        </div>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

    <script type="text/javascript">
        var produtos_selecionados = {};
        produtos_selecionados["venda"] = [];
        var valor_total = 0;
        var cliente_selecionado = 0;
        $(document).ready(function () {
            
            $('#listaclientes').on('change', function() {
                $('#clienteselecionado').html($(this).find("option:selected").text());
                cliente_selecionado = $(this).val();
             });
              
            $('#tabelaitens').DataTable({
                "language": {
                    "lengthMenu": "Mostrando _MENU_ resultados por página",
                    "zeroRecords": "Nada encontrado - desculpe.",
                    "infoEmpty": "Não há dados para mostrar",
                    "infoFiltered": "(filtrado no total de _MAX_ resultados)",
                    "search": "Procurar: ",
                    "info": "Mostrando página _PAGE_ de _PAGES_",
                    "paginate": {
                        "first": "Primeiro",
                        "last": "Último",
                        "next": "Próximo",
                        "previous": "Anterior"
                    },
                }
            });
            
            $("#finalizarvenda").on("click", function () 
            {
                
                if(cliente_selecionado == 0) 
                {
                    alert("Selecione um cliente!");
                    return;
                }
                
                if(produtos_selecionados["venda"].length == 0) 
                {
                    alert("Selecione pelo menos um produto/serviço!");
                    return;
                }
                
                $.ajax(
                {
                 type: "POST",
                 url: "VendaServlet",
                 data: {
                    cliente: cliente_selecionado,
                    produtos: JSON.stringify(produtos_selecionados),
                    valor_venda: valor_total
                },
                 success: function(data){
                  alert('Compra cadastrada com sucesso!');
                  location.href = 'VendaServlet';
                }
            });
            });
            
            $(".adicionarproduto").on("click", function () 
            {
                var novo_produto = true;
                var qtd = parseInt(prompt("Digite a quantidade:"));
                if (qtd != null && qtd > 0) 
                {
                    if( parseInt($(this).closest('tr').find('td').eq(2).text()) < qtd ) 
                    {
                        alert("Estoque insuficiente deste produto");
                        return;
                    }
                    $(this).closest('tr').find('td').eq(2).text( parseInt($(this).closest('tr').find('td').eq(2).text()) - qtd);
                    for (var i = 0; i < produtos_selecionados["venda"].length; i++) 
                    {
                        if(produtos_selecionados["venda"][i].id == $(this).closest('tr').find('td').eq(0).text()) 
                        {
                            produtos_selecionados["venda"][i].qtd += qtd;
                            novo_produto = false;
                        }
                    }
                    if(novo_produto) 
                    {
                        $('#tabelacarrinho').append('<tr>' +
                            '<td>' + $(this).closest('tr').find('td').eq(0).text() + '</td>' +
                            '<td>' + $(this).closest('tr').find('td').eq(1).text() + '</td>' +
                            '<td>' + qtd + '</td>' +
                            '<td>' + $(this).closest('tr').find('td').eq(3).text() + '</td>' +
                            '<td><span class="glyphicon glyphicon-remove" aria-hidden="true" onClick="excluir(this, ' +  $(this).closest('tr').find('td').eq(0).text() + ')" id="aka"></span></td>' +
                            '</tr>');
                        produtos_selecionados["venda"].push
                        (
                        {
                            id: $(this).closest('tr').find('td').eq(0).text(),
                            nome: $(this).closest('tr').find('td').eq(1).text().split(" ")[0],
                            valorunitario: parseInt($(this).closest('tr').find('td').eq(3).text().replace("R$", "")),
                            tipo: $(this).closest('tr').find('td').eq(4).text(),
                            qtd: qtd
                        });
                    } else 
                    {
                        var tabela = document.getElementById('tabelacarrinho');
                        var linhas = tabela.rows.length;
                        for(var i=0; i < linhas; i++)
                        {
                          var row = tabela.rows[i];
                          if (row.cells[0].innerHTML == $(this).closest('tr').find('td').eq(0).text()) 
                          { 
                              //se for o item que estou procurando
                                row.cells[2].innerHTML = parseInt(row.cells[2].innerHTML) + qtd;
                          }
                        }
                    }
                    valor_total += parseInt( parseInt($(this).closest('tr').find('td').eq(3).text().replace("R$", "")) * qtd );
                    
                    $("#valortotal").text("R$" + valor_total);
                    produtos_selecionados.valortotal = valor_total;
                    console.log(produtos_selecionados);
                }
            });
            
            
        });
        function excluir(elemento, idproduto) 
        {
            var id_produto = $(elemento).closest('tr').find('td').eq(0).text(); //pega o id do produto que esta sendo deletado
            var quantidade_produto = $(elemento).closest('tr').find('td').eq(2).text(); //qtd do produto que foi adicionado (para repor o estoque)
            for(var count = 1; $('#tabelaitens').find('tr').eq(count).text() != ""; count++) 
            { 
                //for na lista de produtos disponíveis
                if( $('#tabelaitens').find('tr').eq(count).find('td').eq(0).text() == id_produto) 
                { 
                    //se achou o produto que estamos deletando, vamos repor o estoque
                    $('#tabelaitens').find('tr').eq(count).find('td').eq(2).text(parseInt($('#tabelaitens').find('tr').eq(count).find('td').eq(2).text()) + parseInt(quantidade_produto));
                }
            }
            $(elemento).closest('tr').remove(); //deleta a linha na tabela do carrinho
            
            for( var i = 0; i < produtos_selecionados["venda"].length; i++)
            { 
                //começa a tratativa para remover do array que será enviado via json
               if ( produtos_selecionados["venda"][i].id == idproduto) 
               {
                 produtos_selecionados["venda"].splice(i, 1); //remove do array
               } 
            }
            valor_total = 0; 
            for( var i = 0; i < produtos_selecionados["venda"].length; i++)
            { 
                //reconta o valor total do carrinho
               valor_total += produtos_selecionados["venda"][i].valorunitario * produtos_selecionados["venda"][i].qtd;
            }
            produtos_selecionados.valortotal = valor_total;
            $("#valortotal").text("R$" + valor_total);
        }
    </script>
</body>

</html>