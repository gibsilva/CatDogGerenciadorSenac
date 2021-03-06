<%-- 
    Document   : incluirProduto
    Created on : 21/09/2019, 22:06:46
    Author     : Gi
--%>
<%@include file="../header.jsp" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="main-panel ps-container ps-theme-default ps-active-y" data-ps-id="1f824408-32f0-04a9-f7a5-3406fff7d60f">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <a class="navbar-brand" href="#pablo">Altera��o de Produto</a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon icon-bar"></span>
                <span class="navbar-toggler-icon icon-bar"></span>
                <span class="navbar-toggler-icon icon-bar"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end">

                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#pablo" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user"></i>
                            <p class="d-lg-none d-md-block">
                                Account
                            </p>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                            <a class="dropdown-item" href="#">Perfil</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="logout">Log out</a>
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
                            <h4 class="card-title">Alterar Produto</h4>
                            <p class="card-category">Altera��o de dados do produto</p>
                        </div>
                        <div class="card-body">
                            <form action="alterar-produto" method="post">
                                <input type="hidden" id="id" name="id" value="${produto.id}">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Nome/T�tulo</label>
                                            <input type="text" class="form-control" id="nomeProduto" name="nomeProduto" required value="${produto.nome}">
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Quantidade</label>
                                            <input type="text" class="form-control" id="quantidade" name="quantidade" required value="${produto.quantidade}">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputState">Tipo de Animal</label>
                                        <select class="form-control" id="tipoAnimal" name="tipoAnimal" required>
                                            <option value="">Selecione</option>
                                            <c:forEach var="c" items="${tipoAnimal}">
                                                <option value="${c.getOpcao()}">${c.toString()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputState">Categoria</label>
                                        <select class="form-control" id="idCategoria" name="idCategoria" required>
                                            <option value="">Selecione</option>
                                            <c:forEach var="c" items="${categorias}">
                                                <option value="${c.id}">${c.nome}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputState">Porte de Animal</label>
                                        <select class="form-control" id="porteAnimal" name="porteAnimal" required>
                                            <option value="">Selecione</option>
                                            <c:forEach var="c" items="${porteAnimal}">
                                                <option value="${c.getOpcao()}">${c.toString()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floatin" for="fornecedor">Fornecedor</label>
                                        <select class="form-control" id="idFornecedor" name="idFornecedor" required>
                                            <option value="">Selecione</option>
                                            <c:forEach var="c" items="${fornecedores}">
                                                <option value="${c.id}">${c.nome}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                </div>

                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Descri��o</label>
                                            <textarea class="form-control" rows="2"  maxlength="100" 
                                                      id="idDescricao" name="descricao" required=""></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Especifica��o</label>
                                            <textarea class="form-control" rows="2" maxlength="300" 
                                                      id="idEspecificacao" name="especificacao" required></textarea>
                                        </div>
                                    </div>


                                </div>

                                <div class="row">
                                    <div class="col-md-2">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Pre�o Compra</label>
                                            <input type="text" class="form-control" id="precoCompra" name="precoCompra" required value="<fmt:formatNumber value="${produto.precoCompra}" type="number"></fmt:formatNumber>">
                                            </div>
                                        </div>

                                        <div class="col-md-2">
                                            <div class="form-group bmd-form-group">
                                                <label class="bmd-label-floating">Pre�o Venda</label>
                                                <input type="text" class="form-control" id="precoVenda" name="precoVenda" required value="<fmt:formatNumber value="${produto.precoVenda}" type="number"></fmt:formatNumber>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-2">
                                            <label class="bmd-label-floating" for="inputState">Status</label>
                                            <select id="inputState" class="form-control" id="idStatus" name="ativo" required>
                                                <option value="">Selecione</option>
                                                <option value="true">Ativo</option>
                                                <option value="false">Inativo</option>
                                            </select>
                                        </div>
                                    </div>
                                    <br>
                                    <button id="btnSalvar" onclick="salvar()" type="submit" class="btn btn-success pull-right">Salvar</button>
                                    <a href="listar-produto" type="" class="btn btn-danger pull-right">Cancelar</a>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div class="card-header card-header-info">
                                    <h4 class="card-title">Lista de imagens</h4>
                                    <p class="card-category">Altera��o das imagens</p>
                                </div>
                                <br>
                                <div class="row text-center text-lg-left">
                                <c:forEach var="c" items="${produto.imagens}">
                                    <div class="col-lg-3 col-md-4 col-6">
                                        <c:url var="imagem" value="/imagem">
                                            <c:param name="idImagem" value="${c.id}" />
                                        </c:url>
                                        <img class="img-fluid img-thumbnail" src="${imagem}" alt="${c.nome}">
                                        <input id="fileInput" type="file" style="display:none;" />
                                        <input type="button" class="btn btn-primary btn-block" value="Escolher imagem" onclick="alterarImagem(${c.id})" />
                                    </div>
                                </c:forEach>
                            </div>
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
    var idImagem = 0;
    var permissao = '${sessionScope.usuarioLogado.permissao}';

    $(document).ready(function () {
        if (permissao !== 'Adminstrador')
            funcAuxiliar();
        document.getElementById('idFornecedor').value = '${produto.idFornecedor}';
        document.getElementById('idCategoria').value = '${produto.idCategoria}';
        document.getElementById('idDescricao').value = '${produto.descricao}';
        document.getElementById('idEspecificacao').value = '${produto.especificacao}';
        document.getElementById('tipoAnimal').value = '${produto.tipoAnimal.getOpcao()}';
        document.getElementById('porteAnimal').value = '${produto.porteAnimal.getOpcao()}';
        console.log('${produto.ativo}');
        if ('${produto.ativo}' === true) {
            document.getElementById('inputState').value = 'false';
        } else {
            document.getElementById('inputState').value = 'true';
        }
    });

    function salvar() {
        $('#porteAnimal').attr('disabled', false);
        $('#idCategoria').attr('disabled', false);
        $('#idFornecedor').attr('disabled', false);
        $('#inputState').attr('disabled', false);
        $('#tipoAnimal').attr('disabled', false);
    }

    function alterarImagem(id) {
        document.getElementById('fileInput').click();
        idImagem = id;
    }

    function funcAuxiliar() {
        $('#nomeProduto').prop('readonly', true);
        $('#tipoAnimal').attr('disabled', true);
        $('#porteAnimal').attr('disabled', true);
        $('#idCategoria').attr('disabled', true);
        $('#idFornecedor').attr('disabled', true);
        $('#idDescricao').prop('readonly', true);
        $('#idEspecificacao').prop('readonly', true);
        $('#precoCompra').prop('readonly', true);
        $('#precoVenda').prop('readonly', true);
        $('#inputState').attr('disabled', true);
    }

    $('#fileInput').change(function () {
        var imagem = $('#fileInput').val();
        trocarImagem(imagem);
    });

    function trocarImagem(imagem) {
        console.log(imagem);
        var sampleFile = document.getElementById("fileInput").files[0];
        var formdata = new FormData();

        formdata.append("fileInput", sampleFile);
        formdata.append("id", idImagem);

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "alterar-imagens", true);
        console.log(idImagem);
        xhr.send(formdata);
        xhr.onload = function (e) {

            if (this.status === 200) {
                alert('Imagem alterada');
            }

        };
        /*
         $.ajax({
         url: "alterar-imagens",
         type: "GET",
         contentType: 'application/json',
         data: {'arquivo': imagem},
         success: function (data) {
         console.log(data);
         },
         error: function (jqXHR, textStatus, errorThrown) {
         console.log(jqXHR, textStatus, errorThrown);
         }
         });
         */
    }

    // FileInput
    $('.form-file-simple .inputFileVisible').click(function () {
        $(this).siblings('.inputFileHidden').trigger('click');
    });

    $('.form-file-simple .inputFileHidden').change(function () {
        var filename = $(this).val().replace(/C:\\fakepath\\/i, '');
        $(this).siblings('.inputFileVisible').val(filename);
    });

    $('.form-file-multiple .inputFileVisible, .form-file-multiple .input-group-btn').click(function () {
        $(this).parent().parent().find('.inputFileHidden').trigger('click');
        $(this).parent().parent().addClass('is-focused');
    });

    $('.form-file-multiple .inputFileHidden').change(function () {
        var names = '';
        for (var i = 0; i < $(this).get(0).files.length; ++i) {
            if (i < $(this).get(0).files.length - 1) {
                names += $(this).get(0).files.item(i).name + ',';
            } else {
                names += $(this).get(0).files.item(i).name;
            }
        }
        $(this).siblings('.input-group').find('.inputFileVisible').val(names);
    });

    $('.form-file-multiple .btn').on('focus', function () {
        $(this).parent().siblings().trigger('focus');
    });

    $('.form-file-multiple .btn').on('focusout', function () {
        $(this).parent().siblings().trigger('focusout');
    });


</script>
