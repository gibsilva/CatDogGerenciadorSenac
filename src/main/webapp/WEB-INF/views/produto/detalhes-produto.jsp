<%-- 
    Document   : detalhes-produto
    Created on : 20/09/2019, 07:20:30
    Author     : Gi
--%>
<%@include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Detalhes do produto</title>

<div class="main-panel ps-container ps-theme-default ps-active-y" data-ps-id="1f824408-32f0-04a9-f7a5-3406fff7d60f">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <a class="navbar-brand" href="#pablo">Detalhes do Produto</a>
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

    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-5">
                    <div class="card">
                        <div class="card-header card-header-info">
                            <h4 class="card-title">Imagens do Produto</h4>  
                        </div>
                        <div class="card-body">
                            <div id="carouselExampleControls" class="carousel slide"
                                 data-ride="carousel">

                                <div class="carousel-inner">
                                    <c:forEach var="c" items="${produto.imagens}">
                                        <div class="carousel-item active">
                                            <img class="d-block carousel-picture "
                                                 src="${c.caminho}"
                                                 alt="${c.nome}">
                                        </div>
                                    </c:forEach>
                                </div>

                                <a class="carousel-control-prev" href="#carouselExampleControls"
                                   role="button" data-slide="prev"> <span
                                        class="carousel-control-prev-icon iconCarousel" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a> <a class="carousel-control-next" href="#carouselExampleControls"
                                        role="button" data-slide="next"> <span
                                        class="carousel-control-next-icon iconCarousel" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="card">
                        <div class="card-header card-header-info">
                            <h4 class="card-title">Detalhes do Produto</h4>
                            <p class="card-category">informa��es sobre o produto</p>
                        </div>
                        <div class="card-body justify-content-center">
                            <form>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Nome/T�tulo</label>
                                            <input type="text" class="form-control" id="nomeProduto" name="nomeProduto" readonly value="${produto.nome}">
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Quantidade</label>
                                            <input type="text" class="form-control" id="quantidade" name="quantidade" readonly value="${produto.quantidade}">
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="form-group col-md-3">
                                        <label class="bmd-label-floating" for="inputState">Tipo de Animal</label>
                                        <input type="text" class="form-control" id="tipoAnimal" name="tipoAnimal" readonly value="${produto.getTipoAnimal().toString()}">
                                    </div>

                                    <div class="form-group col-md-3">
                                        <label class="bmd-label-floating" for="inputState">Porte de Animal</label>
                                        <input type="text" class="form-control" id="porteAnimal" name="porteAnimal" readonly value="${produto.getPorteAnimal().toString()}">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label class="bmd-label-floating" for="categoria">Categoria</label>
                                        <input type="text" class="form-control" id="categoria" name="categoria" readonly value="${produto.categoria.nome}">
                                    </div>

                                    <div class="form-group col-md-3">
                                        <label class="bmd-label-floating" for="fornecedor">Fornecedor</label>
                                        <input type="text" class="form-control" id="fornecedor" name="fornecedor" readonly value="${produto.fornecedor.nome}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Descri��o</label>
                                            <textarea class="form-control" rows="2"  maxlength="100" 
                                                      id="descricao" name="descricao" readonly></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Especifica��o</label>
                                            <textarea class="form-control" rows="2" maxlength="300" 
                                                      id="especificacao" name="especificacao" readonly></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Pre�o Compra</label>
                                            <input type="text" class="form-control" id="precoCompra" name="precoCompra" readonly value="<fmt:formatNumber value="${produto.precoCompra}" type="currency"></fmt:formatNumber>">
                                            </div>
                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group bmd-form-group">
                                                <label class="bmd-label-floating">Pre�o Venda</label>
                                                <input type="text" class="form-control" id="precoVenda" name="PrecoVenda" readonly value="<fmt:formatNumber value="${produto.precoVenda}" type="currency"></fmt:formatNumber>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-2">
                                            <label class="bmd-label-floating" for="status">Status</label>
                                        <c:if test="${produto.ativo == true}">
                                            <input type="text" class="form-control" id="status" name="status" readonly value="Ativo">
                                        </c:if>
                                        <c:if test="${produto.ativo == false}">
                                            <input type="text" class="form-control" id="status" name="status" readonly value="Inativo">
                                        </c:if>
                                    </div>
                                </div>
                                <c:url var="alterarProduto" value="/alterar-produto">
                                    <c:param name="id" value="${produto.id}" />
                                </c:url>
                                <a href="${alterarProduto}" class="btn btn-success pull-rights" data-toggle="tooltip" data-placement="left" title="Alterar Produto">Alterar</a>
                                <button type="" class="btn btn-danger pull-right">Cancelar</button>
                                <div class="clearfix"></div>

                            </form>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        document.getElementById('descricao').value = '${produto.descricao}';
        document.getElementById('especificacao').value = '${produto.especificacao}';
    });
</script>
