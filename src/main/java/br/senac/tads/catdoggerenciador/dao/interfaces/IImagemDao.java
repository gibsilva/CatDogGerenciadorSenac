/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.dao.interfaces;

import br.senac.tads.catdoggerenciador.entidades.Imagem;
import java.util.List;

/**
 *
 * @author Gi
 */
public interface IImagemDao {

    Imagem obterPorId(int id);

    List<Imagem> obterPorIdProduto(int id);

    List<Imagem> obterTodos();

    void salvar(Imagem imagem);

    void alterar(Imagem imagem);

    void excluir(Imagem imagem);

    void excluirPorIdProduto(int id);
}
