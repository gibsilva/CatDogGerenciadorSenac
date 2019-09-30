<%-- 
    Document   : incluir-categoria
    Created on : 22/09/2019, 10:40:11
    Author     : Gi
--%>

<%@include file="../header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>Alteração de Fornecedores</title>
<div class="main-panel ps-container ps-theme-default ps-active-y" data-ps-id="1f824408-32f0-04a9-f7a5-3406fff7d60f">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <a class="navbar-brand" href="#pablo">Alteração de Fornecedor</a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon icon-bar"></span>
                <span class="navbar-toggler-icon icon-bar"></span>
                <span class="navbar-toggler-icon icon-bar"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end">

                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#pablo" id="navbarDropdownProfile" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user"></i>
                            <p class="d-lg-none d-md-block">
                                Account
                            </p>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                            <a class="dropdown-item" href="#">Perfil</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Log out</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- End Navbar -->
    <div class="content">
        <div class="container-fluid">
            <div class="container">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header card-header-info">
                            <h4 class="card-title">Alterar Fornecedores</h4>
                            <p class="card-category">Altere de dados dos fornecedores</p>
                        </div>
                        <div class="card-body">
                            <form action="alterar-fornecedor" method="post">
                                <input type="hidden" value="${fornecedor.id}" name="id">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Nome do Fornecedor</label>
                                            <input type="text" class="form-control" id="fornecedor" name="fornecedor"
                                                   required value="${fornecedor.nome}">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Razão Social</label>
                                            <input type="text" class="form-control" id="razaoSocial" name="razaoSocial"
                                                   required value="${fornecedor.razaoSocial}">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">CNPJ</label>
                                            <input type="text" class="form-control" id="cnpj" name="cnpj" readonly value="${fornecedor.documento}">
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">CEP</label>
                                            <input type="text" class="form-control" id="cep" name="cep" required value="${fornecedor.cep}">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Logradouro</label>
                                            <input type="text" class="form-control" id="logradouro" name="logradouro"
                                                   readonly value="${fornecedor.logradouro}">
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Numero</label>
                                            <input type="text" class="form-control" id="numero" name="numero" required value="${fornecedor.numero}">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Complemento</label>
                                            <input type="text" class="form-control" id="complemento" name="complemento" value="${fornecedor.complemento}">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-5">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Bairro</label>
                                            <input type="text" class="form-control" id="bairro" name="bairro" readonly value="${fornecedor.bairro}">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Cidade</label>
                                            <input type="text" class="form-control" id="cidade" name="cidade" readonly value="${fornecedor.cidade}">
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Estado</label>
                                            <input type="text" class="form-control" id="estado" name="estado" readonly value="${fornecedor.estado}">
                                        </div>
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputAtivo">Status</label>
                                        <select id="ativo" name="ativo" class="custom-select" value="${fornecedor.ativo}" required>
                                            <option value="true">Ativo</option>
                                            <option value="false">Inativo</option>
                                        </select>
                                    </div>
                                </div>
                                <br>
                                <button type="submit" class="btn btn-success pull-right">Salvar</button>
                                <a href="listar-fornecedor" class="btn btn-danger pull-right">Cancelar</a>
                                <div class="clearfix"></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
    <div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;">
    </div>
</div>
<div class="ps-scrollbar-y-rail" style="top: 0px; right: 0px; height: 268px;">
    <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 88px;">
    </div>
</div>

<script>
    //estamos usando uma api gratuita para a consulta de CEPs
    $("#cep").focusout(function () {
        if ($("#cep").val() === '00000-000' || $("#cep").val() === '11111-111') {
            cepInvalido();
        } else {
            //Inï¿½cio do Comando AJAX
            $.ajax({
                //O campo URL diz o caminho de onde virï¿½ os dados
                //ï¿½ importante concatenar o valor digitado no CEP
                url: 'https://viacep.com.br/ws/' + $(this).val() + '/json/unicode/',
                //Aqui vocï¿½ deve preencher o tipo de dados que serï¿½ lido,
                //no caso, estamos lendo JSON.
                dataType: 'json',
                //SUCESS ï¿½ referente a funï¿½ï¿½o que serï¿½ executada caso
                //ele consiga ler a fonte de dados com sucesso.
                //O parï¿½metro dentro da funï¿½ï¿½o se refere ao nome da variï¿½vel
                //que vocï¿½ vai dar para ler esse objeto.
                success: function (resposta) {
                    //Agora basta definir os valores que vocï¿½ deseja preencher
                    //automaticamente nos campos acima.
                    $("#logradouro").val(resposta.logradouro);
                    $("#complemento").val(resposta.complemento);
                    $("#bairro").val(resposta.bairro);
                    $("#cidade").val(resposta.localidade);
                    $("#estado").val(resposta.uf);
                    //Vamos incluir para que o Nï¿½mero seja focado automaticamente
                    //melhorando a experiï¿½ncia do usuï¿½rio
                    $("#numero").focus();
                },
                error: function (resposta) {
                    cepInvalido();
                }
            });
        }
    });

    function cepInvalido() {
        alert('Cep invï¿½lido');
        $('#cep').val('');
        $("#logradouro").val('');
        $("#complemento").val('');
        $("#bairro").val('');
        $("#cidade").val('');
        $("#uf").val('');
        $("#cep").focus();
    }
</script>