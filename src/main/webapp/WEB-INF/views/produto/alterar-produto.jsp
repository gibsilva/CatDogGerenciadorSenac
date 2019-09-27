<%-- 
    Document   : incluirProduto
    Created on : 21/09/2019, 22:06:46
    Author     : Gi
--%>
<%@include file="../header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<div class="main-panel ps-container ps-theme-default ps-active-y" data-ps-id="1f824408-32f0-04a9-f7a5-3406fff7d60f">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <a class="navbar-brand" href="#pablo">Alteração de Produto</a>
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
                            <h4 class="card-title">Alterar Produto</h4>
                            <p class="card-category">Alteração de dados do produto</p>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Nome/Título</label>
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
                                                <option value="${c.ordinal()}">${c.toString()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputState">Categoria</label>
                                        <select class="form-control" id="categoria" name="categoria" required>
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
                                                <option value="${c.ordinal()}">${c.toString()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floatin" for="fornecedor">Fornecedor</label>
                                        <select class="form-control" id="fornecedor" name="fornecedor" required>
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
                                            <label class="bmd-label-floating">Descrição</label>
                                            <textarea class="form-control" rows="2"  maxlength="100" 
                                                      id="descricao" name="descricao" required=""></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Especificação</label>
                                            <textarea class="form-control" rows="2" maxlength="300" 
                                                      id="especificacao" name="especificacao" required></textarea>
                                        </div>
                                    </div>


                                </div>

                                <div class="row">
                                    <div class="col-md-2">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Preço Compra</label>
                                            <input type="text" class="form-control" id="precoCompra" name="precoCompra" required value="<fmt:formatNumber value="${produto.precoCompra}" type="number"></fmt:formatNumber>">
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Preço Venda</label>
                                            <input type="text" class="form-control" id="precoVenda" name="PrecoVenda" required value="<fmt:formatNumber value="${produto.precoVenda}" type="number"></fmt:formatNumber>">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group form-file-upload form-file-multiple col-md-6">
                                        <input type="file" multiple="file" class="inputFileHidden" accept="image/png, image/jpeg">
                                        <div class="input-group">
                                            <input type="text" class="form-control inputFileVisible" placeholder="Selecionar Imagens" multiple>
                                            <span class="input-group-btn">
                                                <button id="fileInput" onclick="escolherImagem()" type="button" class="btn btn-fab btn-round btn-info">
                                                    <i class="material-icons">layers</i>
                                                </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputState">Status</label>
                                        <select id="inputState" class="form-control" id="status" name="status" required>
                                            <option selected>Selecione</option>
                                            <option>Ativo</option>
                                            <option>Inativo</option>
                                        </select>
                                    </div>
                                </div>
                                <br>
                                <br>
                                <button type="submit" class="btn btn-success pull-right">Salvar</button>
                                <a href="listar-produto" type="" class="btn btn-danger pull-right">Cancelar</a>
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
    $(document).ready(function () {
        document.getElementById('fornecedor').value = '${produto.getIdFornecedor()}';
        document.getElementById('tipoAnimal').value = '${produto.getTipoAnimal().getOpcao()}';
        document.getElementById('porteAnimal').value = '${produto.getPorteAnimal().getOpcao()}';
        document.getElementById('categoria').value = '${produto.getIdCategoria()}';
        document.getElementById('descricao').value = '${produto.descricao}';
        document.getElementById('especificacao').value = '${produto.especificacao}';
        document.getElementById('ativo').value = '${produto.ativo}';
    });

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
