<%-- 
    Document   : detalhes-produto
    Created on : 20/09/2019, 07:20:30
    Author     : Gi
--%>
<%@include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                                    <div class="carousel-item active">
                                        <img class="d-block carousel-picture "
                                             src="https://www.petlove.com.br/images/products/203974/product/Ra%C3%A7%C3%A3o_Premier_Pet_Ra%C3%A7as_Espec%C3%ADficas_Malt%C3%AAs_Filhotes_-_1_Kg_1199952.jpg?1556369259"
                                             alt="First slide">
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block carousel-picture"
                                             src="https://www.petlove.com.br/images/products/203974/product/Ra%C3%A7%C3%A3o_Premier_Pet_Ra%C3%A7as_Espec%C3%ADficas_Malt%C3%AAs_Filhotes_-_1_Kg_1199952.jpg?1556369259"
                                             alt="Second slide">
                                    </div>
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
                            <p class="card-category">informações sobre o produto</p>
                        </div>
                        <div class="card-body justify-content-center">
                            <form>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Nome/Título</label>
                                            <input type="text" class="form-control" id="nomeProduto" name="nomeProduto" required>
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Quantidade</label>
                                            <input type="text" class="form-control" id="quantidade" name="quantidade" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-3">
                                        <label class="bmd-label-floating" for="inputState">Tipo de Animal</label>
                                        <select id="inputState" class="form-control" id="tipoAnimal" name="tipoAnimal" required>
                                            <option selected>Selecione</option>
                                            <c:forEach var="c" items="${categorias}">
                                                <option value="${c.id}">${c.nome}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputState">Raça</label>
                                        <select id="inputState" class="form-control" id="raca" name="raca">
                                            <option selected>Selecione</option>
                                            <option>...</option>
                                            <option>...</option>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floating" for="inputState">Categoria</label>
                                        <select id="inputState" class="form-control" id="categoria" name="categoria" required>
                                            <option selected>Selecione</option>
                                            <c:forEach var="c" items="${categorias}">
                                                <option value="${c.id}">${c.nome}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label class="bmd-label-floatin" for="inputState">Fornecedor</label>
                                        <select id="inputState" class="form-control" id="fornecedor" name="fornecedor" required>
                                            <option selected>Selecione</option>
                                            <option>...</option>
                                            <option>...</option>
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
                                    <div class="col-md-3">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Preço Compra</label>
                                            <input type="text" class="form-control" id="precoCompra" name="precoCompra" required>
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                        <div class="form-group bmd-form-group">
                                            <label class="bmd-label-floating">Preço Venda</label>
                                            <input type="text" class="form-control" id="precoVenda" name="PrecoVenda" required>
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
                                <button type="submit" class="btn btn-success pull-right">Alterar</button>
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
