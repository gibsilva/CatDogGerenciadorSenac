package br.senac.tads.catdoggerenciador.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.tads.catdoggerenciador.dao.interfaces.ICategoriaDao;
import br.senac.tads.catdoggerenciador.entidades.Categoria;

public class CategoriaDao extends BaseDao implements ICategoriaDao {

    private Connection conn;

    @Override
    public Categoria obterPorId(int id) {
        this.conn = conexao.getConnection();
        Categoria categoria = null;

        try {
            this.stmt = conn.prepareStatement("select id, nome from categoria where id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                categoria = new Categoria(rs.getInt("Id"), rs.getString("Nome"));
            }

            return categoria;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public List<Categoria> obterTodas() {
        this.conn = conexao.getConnection();
        Categoria categoria = null;
        List<Categoria> categorias = new ArrayList<Categoria>();

        try {
            this.stmt = conn.prepareStatement("select id, nome from categoria");

            rs = stmt.executeQuery();

            while (rs.next()) {
                categoria = new Categoria(rs.getInt("Id"), rs.getString("Nome"));
                categorias.add(categoria);
            }

            return categorias;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void salvar(Categoria categoria) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("insert into categoria(nome) values(?)");
            this.stmt.setString(1, categoria.getNome());
            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void alterar(Categoria categoria) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("update categoria set nome = ? where id = ?");
            this.stmt.setString(1, categoria.getNome());
            this.stmt.setInt(2, categoria.getId());
            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }

    }

    @Override
    public void excluir(Categoria categoria) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("delete from categoria where id = ?");
            this.stmt.setInt(1, categoria.getId());
            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }

    }

    @Override
    public Categoria obterPorNome(String nome) {
        this.conn = conexao.getConnection();
        Categoria categoria = null;

        try {
            this.stmt = conn.prepareStatement("select id, nome from categoria where nome = ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while (rs.next()) {
                categoria = new Categoria(rs.getInt("Id"), rs.getString("Nome"));
            }

            return categoria;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

}
