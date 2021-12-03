<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Relatórios</title>

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>
    <div>
        <div class="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="content">
                    <nav class="navbar navbar-default">
                        <div style="font-size: 20px; text-align: center;">Relatórios</div>
                    </nav>
                    <div id="rvendas">
                        <div class="row">
                            <div class="form-group col-md-2">

                                <label for="inputState">Período:</label>
                                <select id="inputState" class="form-control" onChange="window.location.href = this.options[this.selectedIndex].value">
                                    <option value="RelatoriosServlet?filtro=7" <c:if test="${filtro == 7}">selected</c:if>>Semanal</option>
                                    <option value="RelatoriosServlet?filtro=15" <c:if test="${filtro == 15}">selected</c:if>>Quinzenal</option>
                                    <option value="RelatoriosServlet?filtro=30" <c:if test="${filtro == 30}">selected</c:if>>Mensal</option>
                                </select>
                            </div> 
                        </div>
                        <table class="table" id="tabelavendas">
                            <thead>
                                <tr>
                                    <th scope="col">Cod. do pedido</th>
                                    <th scope="col">Cliente</th>
                                    <th scope="col">Funcionario</th>
                                    <th scope="col">Filial</th>
                                    <th scope="col">Data</th>
                                    <th scope="col">Valor venda</th>


                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${relatorio}" var="r">
                                <tr>
                                    <td scope="row"><c:out value="${r.idPedido}" /></td>
                                    <td><c:out value="${r.cliente.nome}" /></td>
                                    <td><c:out value="${r.funcionario.nome}" /></td>
                                    <td><c:out value="${r.idFilial}" /></td>
                                    <td><c:out value="${r.data}" /></td>
                                    <td><c:out value="${r.precovenda}" /></td>

                                </tr>
                            </c:forEach>

                        </tbody>

                    </table>
                    <div style="margin-bottom: 2px;">
                        <button type="button" class="btn btn-secondary btn-lg" id="exportarcadastros">
                            <i class="fas fa-cloud-download-alt"></i> Exportar CSV</button>

                    </div>
                </div>

                <div id="inventario" style="display: none">
                    <div class="form-group col-md-2">
                        <div class="row">
                            <label for="inputState">Tipo de relatorio:</label>
                            <select id="inputState" class="form-control">
                                <option selected>Selecione...</option>
                                <option value="0">Semanal</option>
                                <option value="1">Quinzenal</option>
                                <option value="2">Mensal</option>
                            </select>
                        </div>    
                    </div>

                    <div style="margin-bottom: 2px;">
                        <button type="button" class="btn btn-secondary btn-lg" id="exportarcadastros">
                            <i class="fas fa-cloud-download-alt"></i> Exportar CSV</button>

                    </div>
                </div>

                <div id="cadastros" style="display: none">
                    <div class="form-group col-md-2">
                        <div class="row">
                            <label for="inputState">Tipo de relatorio:</label>
                            <select id="inputState" class="form-control" onChange="window.location.href = this.options[this.selectedIndex].value" >
                                <option value="0 selected="">Semanal</option>
                                <option value="1">Quinzenal</option>
                                <option value="2">Mensal</option>
                            </select>
                        </div>    "
                    </div>

                    <div style="margin-bottom: 2px;">

                        <button type="button" class="btn btn-secondary btn-lg" id="exportarcadastros">
                            <i class="fas fa-cloud-download-alt"></i> Exportar CSV</button>

                    </div>
                </div>

            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />


        <script type="text/javascript">
        $(document).ready(function () {
            $("#calendario").datepicker();

            $('#tabelaVendas').DataTable({
                "language": {
                    "lengthMenu": "Mostrando MENU resultados por página",
                    "zeroRecords": "Nada encontrado - desculpe.",
                    "info": "Mostrando página PAGE de PAGES",
                    "infoEmpty": "Não há dados para mostrar",
                    "infoFiltered": "(filtrado no total de MAX resultados)",
                    "search": "Procurar: ",
                    "paginate": {
                                    "first": "Primeiro",
                                    "last": "Último",
                                    "next": "Próximo",
                                    "previous": "Anterior"
                                },
            }
        });
        
    });

        function gerarCSV(){
            
                var content = [['Cod. Pedido', 'Cliente', 'Funcionario', 'Filial', 'Data', 'Valor venda']];

                 <c:forEach items="${relatorio}" var="r">
                content.push(['${r.idPedido}', '${r.cliente.nome}', '${r.funcionario.nome}', '${r.idFilial}', '${r.data}', '${r.precovenda}']);
                 </c:forEach>

                var finalVal = '';

                for (var i = 0; i < content.length; i++) {
                    var value = content[i];

                    for (var j = 0; j < value.length; j++) {
                        var innerValue = value[j];
                        var result = innerValue.replace(/"/g, '""');
                        if (result.search(/("|,|\n)/g) >= 0)
                            result = '"' + result + '"';
                        if (j > 0)
                            finalVal += ',';
                        finalVal += result;
                    }

                    finalVal += '\n';
                }

                var pom = document.createElement('a');
                pom.setAttribute('href', 'data:text/csv;charset=utf-8,' + encodeURIComponent(finalVal));
                pom.setAttribute('download', 'test.csv');
                pom.click();
            }
            
        $("#exportarcadastros").on("click", function () {
            gerarCSV();
        });

         

    </script>
</body>
    </html>