/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.services;

import br.senac.tads.catdoggerenciador.dao.RacaDao;
import br.senac.tads.catdoggerenciador.entidades.Notificacao;
import br.senac.tads.catdoggerenciador.entidades.Raca;
import java.util.List;

/**
 *
 * @author Gi
 */
public class RacaService {
        private final RacaDao racaDao;
    private final Notificacao notificacao;

    public RacaService() {
        this.notificacao = new Notificacao();
        this.racaDao = new RacaDao();
    }
    
    public List<Raca> obterTodas(){
        return this.racaDao.obterTodas();
    }
}
