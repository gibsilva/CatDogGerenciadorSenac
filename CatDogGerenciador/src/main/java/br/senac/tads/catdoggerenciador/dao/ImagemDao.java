/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.dao;

import br.senac.tads.catdoggerenciador.dao.interfaces.IImagemDao;
import br.senac.tads.catdoggerenciador.entidades.Imagem;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gi
 */
public class ImagemDao extends BaseDao implements IImagemDao {

    private Connection conn;

    @Override
    public Imagem obterPorId(int id) {
        this.conn = conexao.getConnection();
        Imagem img = null;

        try {
            this.stmt = conn.prepareStatement("select id, idproduto, nome, caminho, tipo from imagem where id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                img = new Imagem(
                        rs.getInt("Id"),
                        rs.getString("nome"),
                        rs.getString("caminho"),
                        rs.getString("tipo"),
                        rs.getInt("idProduto"));
            }

            return img;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public List<Imagem> obterTodos() {
        this.conn = conexao.getConnection();
        Imagem img = null;
        List<Imagem> imagens = new ArrayList<Imagem>();

        try {
            this.stmt = conn.prepareStatement("select id, idproduto, nome, caminho, tipo from imagem");

            rs = stmt.executeQuery();

            while (rs.next()) {
                img = new Imagem(
                        rs.getInt("Id"),
                        rs.getString("nome"),
                        rs.getString("caminho"),
                        rs.getString("tipo"),
                        rs.getInt("idProduto"));
                imagens.add(img);
            }

            return imagens;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void salvar(Imagem imagem) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("insert into imagem(nome, caminho, "
                    + "tipo, idproduto) values(?, ?, ?, ?)");

            this.stmt.setString(1, imagem.getNome());
            this.stmt.setString(2, imagem.getCaminho());
            this.stmt.setString(3, imagem.getTipo());
            this.stmt.setInt(4, imagem.getIdProduto());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void alterar(Imagem imagem) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("update imagem set nome = ?, caminho = ?, tipo = ?, idproduto = ? where id = ?");

            this.stmt.setString(1, imagem.getNome());
            this.stmt.setString(2, imagem.getCaminho());
            this.stmt.setString(3, imagem.getTipo());
            this.stmt.setInt(4, imagem.getIdProduto());
            this.stmt.setInt(5, imagem.getId());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void excluir(Imagem imagem) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("delete from imagem where id = ?");

            this.stmt.setInt(1, imagem.getId());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public List<Imagem> obterPorIdProduto(int id) {
        this.conn = conexao.getConnection();
        Imagem img = null;
        List<Imagem> imagens = new ArrayList<Imagem>();

        try {
            this.stmt = conn.prepareStatement("select id, idproduto, nome, caminho, tipo from imagem where idproduto = ?");
            this.stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                img = new Imagem(
                        rs.getInt("Id"),
                        rs.getString("nome"),
                        rs.getString("caminho"),
                        rs.getString("tipo"),
                        rs.getInt("idProduto"));
                imagens.add(img);
            }

            return imagens;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

}
