/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.dao;

import br.senac.tads.catdoggerenciador.dao.interfaces.IRacaDao;
import br.senac.tads.catdoggerenciador.entidades.Raca;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gi
 */
public class RacaDao extends BaseDao implements IRacaDao {

    private Connection conn;

    @Override
    public List<Raca> obterTodas() {
        this.conn = conexao.getConnection();
        Raca raca = null;
        List<Raca> racas = new ArrayList<Raca>();

        try {
            this.stmt = conn.prepareStatement("select id, nome from raca");

            rs = stmt.executeQuery();

            while (rs.next()) {
                raca = new Raca(rs.getInt("Id"), rs.getString("Nome"));
                racas.add(raca);
            }

            return racas;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

}
