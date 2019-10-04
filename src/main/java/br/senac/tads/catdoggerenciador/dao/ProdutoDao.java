package br.senac.tads.catdoggerenciador.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.tads.catdoggerenciador.dao.interfaces.IProdutoDao;
import br.senac.tads.catdoggerenciador.entidades.Produto;
import br.senac.tads.catdoggerenciador.entidades.enums.EPorteAnimal;
import br.senac.tads.catdoggerenciador.entidades.enums.ETipoAnimal;

public class ProdutoDao extends BaseDao implements IProdutoDao {

    private Connection conn;

    @Override
    public Produto obterPorId(int id) {
        this.conn = conexao.getConnection();
        Produto produto = null;

        try {
            this.stmt = conn.prepareStatement("SELECT `produto`.`Id`,\n"
                    + "    `produto`.`Nome`,\n"
                    + "    `produto`.`Descricao`,\n"
                    + "    `produto`.`Especificacao`,\n"
                    + "    `produto`.`PrecoCompra`,\n"
                    + "    `produto`.`PrecoVenda`,\n"
                    + "    `produto`.`Quantidade`,\n"
                    + "    `produto`.`Ativo`,\n"
                    + "    `produto`.`IdCategoria`,\n"
                    + "    `produto`.`IdFornecedor`,\n"
                    + "    `produto`.`PorteAnimal`,\n"
                    + "    `produto`.`TipoAnimal`\n"
                    + " FROM `catdog`.`produto` where id = ?;");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = new Produto(
                        rs.getInt("Id"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getString("Especificacao"),
                        rs.getDouble("PrecoCompra"),
                        rs.getDouble("PrecoVenda"),
                        rs.getInt("Quantidade"),
                        rs.getBoolean("ativo"),
                        rs.getInt("IdCategoria"),
                        rs.getInt("IdFornecedor"),
                        EPorteAnimal.fromInt(rs.getInt("PorteAnimal")),
                        ETipoAnimal.fromInt(rs.getInt("TipoAnimal"))
                );
            }

            return produto;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public List<Produto> obterTodos() {
        this.conn = conexao.getConnection();
        Produto produto = null;
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            this.stmt = conn.prepareStatement("SELECT `produto`.`Id`,\n"
                    + "    `produto`.`Nome`,\n"
                    + "    `produto`.`Descricao`,\n"
                    + "    `produto`.`Especificacao`,\n"
                    + "    `produto`.`PrecoCompra`,\n"
                    + "    `produto`.`PrecoVenda`,\n"
                    + "    `produto`.`Quantidade`,\n"
                    + "    `produto`.`Ativo`,\n"
                    + "    `produto`.`IdCategoria`,\n"
                    + "    `produto`.`IdFornecedor`,\n"
                    + "    `produto`.`PorteAnimal`,\n"
                    + "    `produto`.`TipoAnimal`\n"
                    + " FROM `catdog`.`produto` where ativo = 1");

            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = new Produto(
                        rs.getInt("Id"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getString("Especificacao"),
                        rs.getDouble("PrecoCompra"),
                        rs.getDouble("PrecoVenda"),
                        rs.getInt("Quantidade"),
                        rs.getBoolean("ativo"),
                        rs.getInt("IdCategoria"),
                        rs.getInt("IdFornecedor"),
                        EPorteAnimal.fromInt(rs.getInt("PorteAnimal")),
                        ETipoAnimal.fromInt(rs.getInt("TipoAnimal"))
                );

                produtos.add(produto);
            }

            return produtos;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void salvar(Produto produto) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = this.conn.prepareStatement("INSERT INTO PRODUTO ("
                    + "NOME, "
                    + "DESCRICAO, "
                    + "ESPECIFICACAO, "
                    + "PRECOCOMPRA, "
                    + "PRECOVENDA, "
                    + "QUANTIDADE, "
                    + "ATIVO, "
                    + "IDCATEGORIA, "
                    + "IDFORNECEDOR, "
                    + "PORTEANIMAL, "
                    + "TIPOANIMAL) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");

            this.stmt.setString(1, produto.getNome());
            this.stmt.setString(2, produto.getDescricao());
            this.stmt.setString(3, produto.getEspecificacao());
            this.stmt.setDouble(4, produto.getPrecoCompra());
            this.stmt.setDouble(5, produto.getPrecoVenda());
            this.stmt.setInt(6, produto.getQuantidade());
            this.stmt.setBoolean(7, produto.getAtivo());
            this.stmt.setInt(8, produto.getIdCategoria());
            this.stmt.setInt(9, produto.getIdFornecedor());
            this.stmt.setInt(10, produto.getPorteAnimal().getOpcao());
            this.stmt.setInt(11, produto.getTipoAnimal().getOpcao());

            this.stmt.executeUpdate();

        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt);
            throw new RuntimeException(ex.getMessage());
        } finally {
            conexao.closeConnection(conn, stmt);
        }

    }

    @Override
    public void alterar(Produto produto) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = this.conn.prepareStatement("update produto set "
                    + "nome = ?, "
                    + "descricao = ?, "
                    + "especificacao = ?, "
                    + "precocompra = ?, "
                    + "precovenda = ?, "
                    + "quantidade = ?, "
                    + "ativo = ?, "
                    + "idcategoria = ?, "
                    + "idfornecedor = ?, "
                    + "porteanimal = ?, "
                    + "tipoanimal = ? "
                    + "where id = ?");

            this.stmt.setString(1, produto.getNome());
            this.stmt.setString(2, produto.getDescricao());
            this.stmt.setString(3, produto.getEspecificacao());
            this.stmt.setDouble(4, produto.getPrecoCompra());
            this.stmt.setDouble(5, produto.getPrecoVenda());
            this.stmt.setInt(6, produto.getQuantidade());
            this.stmt.setBoolean(7, produto.getAtivo());
            this.stmt.setInt(8, produto.getIdCategoria());
            this.stmt.setInt(9, produto.getIdFornecedor());
            this.stmt.setInt(10, produto.getPorteAnimal().ordinal());
            this.stmt.setInt(11, produto.getTipoAnimal().ordinal());
            this.stmt.setInt(12, produto.getId());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }

    }

    @Override
    public int ultimoIdSalvo() {
        this.conn = conexao.getConnection();
        int id = 0;

        try {
            this.stmt = conn.prepareStatement("select id from produto "
                    + "order by id desc limit 1");
            rs = stmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }

            return id;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return 0;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }
}
