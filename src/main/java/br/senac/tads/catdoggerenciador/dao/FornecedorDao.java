package br.senac.tads.catdoggerenciador.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.tads.catdoggerenciador.dao.interfaces.IFornecedorDao;
import br.senac.tads.catdoggerenciador.entidades.Fornecedor;

public class FornecedorDao extends BaseDao implements IFornecedorDao {

    private Connection conn;

    @Override
    public Fornecedor obterPorId(int id) {
        this.conn = conexao.getConnection();
        Fornecedor fornecedor = null;

        try {
            this.stmt = conn.prepareStatement("select id, nome, razaosocial, documento, ativo,"
                    + "cep, logradouro, cidade, bairro, estado, numero, complemento from fornecedor where id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                fornecedor = new Fornecedor(
                        rs.getInt("Id"),
                        rs.getString("nome"),
                        rs.getString("razaosocial"),
                        rs.getString("documento"),
                        rs.getString("cep"),
                        rs.getString("logradouro"),
                        rs.getString("cidade"),
                        rs.getString("bairro"),
                        rs.getString("estado"),
                        rs.getString("numero"),
                        rs.getString("complemento"));
            }

            return fornecedor;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public List<Fornecedor> obterTodos() {
        this.conn = conexao.getConnection();
        Fornecedor fornecedor = null;
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

        try {
            this.stmt = conn.prepareStatement("select id, nome, razaosocial, documento, ativo,"
                    + "cep, logradouro, numero, bairro, cidade, estado, complemento from fornecedor");

            rs = stmt.executeQuery();

            while (rs.next()) {
                fornecedor = new Fornecedor(
                        rs.getInt("Id"),
                        rs.getString("nome"),
                        rs.getString("razaosocial"),
                        rs.getString("documento"),
                        rs.getString("cep"),
                        rs.getString("logradouro"),
                        rs.getString("cidade"),
                        rs.getString("bairro"),
                        rs.getString("estado"),
                        rs.getString("numero"),
                        rs.getString("complemento"));

                fornecedores.add(fornecedor);
            }

            return fornecedores;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void salvar(Fornecedor fornecedor) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("insert into fornecedor(nome, razaosocial, documento, ativo,"
                    + "cep, logradouro, bairro, cidade, estado, numero, complemento) values (?, ?, ?, ?, ?)");

            this.stmt.setString(1, fornecedor.getNome());
            this.stmt.setString(2, fornecedor.getRazaoSocial());
            this.stmt.setString(3, fornecedor.getDocumento());
            this.stmt.setBoolean(4, fornecedor.getAtivo());
            this.stmt.setString(5, fornecedor.getCep());
            this.stmt.setString(6, fornecedor.getLogradouro());
            this.stmt.setString(7, fornecedor.getBairro());
            this.stmt.setString(8, fornecedor.getCidade());
            this.stmt.setString(9, fornecedor.getEstado());
            this.stmt.setString(10, fornecedor.getNumero());
            this.stmt.setString(11, fornecedor.getComplemento());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }

    }

    @Override
    public void alterar(Fornecedor fornecedor) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("update fornecedor set nome = ?, razaosocial = ?, documento = ?,"
                    + "ativo = ?, cep = ?, logradouro = ?, bairro = ?, cidade = ?, "
                    + "estado = ?, numero = ?, complemento = ? where id = ?");

            this.stmt.setString(1, fornecedor.getNome());
            this.stmt.setString(2, fornecedor.getRazaoSocial());
            this.stmt.setString(3, fornecedor.getDocumento());
            this.stmt.setBoolean(4, fornecedor.getAtivo());
            this.stmt.setString(5, fornecedor.getCep());
            this.stmt.setString(6, fornecedor.getLogradouro());
            this.stmt.setString(7, fornecedor.getBairro());
            this.stmt.setString(8, fornecedor.getCidade());
            this.stmt.setString(9, fornecedor.getEstado());
            this.stmt.setString(10, fornecedor.getNumero());
            this.stmt.setString(11, fornecedor.getComplemento());
            this.stmt.setInt(12, fornecedor.getId());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void alterarStatus(Fornecedor fornecedor) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("update fornecedor set ativo = ? where id = ?");

            this.stmt.setBoolean(1, fornecedor.getAtivo());
            this.stmt.setInt(2, fornecedor.getId());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void excluir(Fornecedor fornecedor) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("delete from fornecedor where id = ?");

            this.stmt.setInt(1, fornecedor.getId());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }
}
