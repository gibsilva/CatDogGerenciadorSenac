/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.dao.interfaces;

import br.senac.tads.catdoggerenciador.entidades.Raca;
import java.util.List;

/**
 *
 * @author Gi
 */
public interface IRacaDao {
    List<Raca> obterTodas();
}
