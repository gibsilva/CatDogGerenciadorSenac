/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.services;

import br.senac.tads.catdoggerenciador.dao.ImagemDao;
import br.senac.tads.catdoggerenciador.entidades.Imagem;
import java.util.List;

/**
 *
 * @author Gi
 */
public class ImagemService {

    private final ImagemDao imagemDao;

    public ImagemService() {
        this.imagemDao = new ImagemDao();
    }

    public List<Imagem> obterTodas() {
        return this.imagemDao.obterTodos();
    }

    public Imagem obterPorId(int id) {
        return this.imagemDao.obterPorId(id);
    }

    public List<Imagem> obterPorIdDoProduto(int id) {
        return this.imagemDao.obterPorIdProduto(id);
    }

    public void salvar(Imagem imagem) {
        this.imagemDao.salvar(imagem);
    }

    public void alterar(Imagem imagem) {
        this.imagemDao.alterar(imagem);
    }
}
