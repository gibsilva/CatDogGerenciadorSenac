package br.senac.tads.catdoggerenciador.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.tads.catdoggerenciador.dao.interfaces.IProdutoDao;
import br.senac.tads.catdoggerenciador.entidades.Produto;

public class ProdutoDao extends BaseDao implements IProdutoDao {

    private Connection conn;

    @Override
    public Produto obterPorId(int id) {
        this.conn = conexao.getConnection();
        Produto produto = null;

        try {
            this.stmt = conn.prepareStatement("SELECT `produto`.`Id`,\r\n"
                    + "    `produto`.`Nome`,\r\n"
                    + "    `produto`.`Descricao`,\r\n"
                    + "    `produto`.`Especificacao`,\r\n"
                    + "    `produto`.`PrecoCompra`,\r\n"
                    + "    `produto`.`PrecoVenda`,\r\n"
                    + "    `produto`.`Quantidade`,\r\n"
                    + "    `produto`.`Ativo`,\r\n"
                    + "    `produto`.`IdRaca`,\r\n"
                    + "    `produto`.`IdCategoria`,\r\n"
                    + "    `produto`.`IdFornecedor`\r\n"
                    + "FROM `catdog`.`produto` where `produto`.`Id` = ?;");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = new Produto(rs.getInt("Id"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getString("Especificacao"),
                        rs.getDouble("PrecoCompra"),
                        rs.getDouble("PrecoVenda"),
                        rs.getInt("Quantidade"),
                        rs.getInt("IdCategoria"),
                        rs.getInt("IdFornecedor"),
                        rs.getInt("IdRaca"));
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
            this.stmt = conn.prepareStatement("SELECT `produto`.`Id`,\r\n"
                    + "    `produto`.`Nome`,\r\n"
                    + "    `produto`.`Descricao`,\r\n"
                    + "    `produto`.`Especificacao`,\r\n"
                    + "    `produto`.`PrecoCompra`,\r\n"
                    + "    `produto`.`PrecoVenda`,\r\n"
                    + "    `produto`.`Quantidade`,\r\n"
                    + "    `produto`.`Ativo`,\r\n"
                    + "    `produto`.`IdRaca`,\r\n"
                    + "    `produto`.`IdCategoria`,\r\n"
                    + "    `produto`.`IdFornecedor`\r\n"
                    + "FROM `catdog`.`produto`;");

            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = new Produto(rs.getInt("Id"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getString("Especificacao"),
                        rs.getDouble("PrecoCompra"),
                        rs.getDouble("PrecoVenda"),
                        rs.getInt("Quantidade"),
                        rs.getInt("IdCategoria"),
                        rs.getInt("IdFornecedor"),
                        rs.getInt("IdRaca"));

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
                    + "IDRACA, "
                    + "IDCATEGORIA, "
                    + "IDFORNECEDOR) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");

            this.stmt.setString(1, produto.getNome());
            this.stmt.setString(2, produto.getDescricao());
            this.stmt.setString(3, produto.getEspecificacao());
            this.stmt.setDouble(4, produto.getPrecoCompra());
            this.stmt.setDouble(5, produto.getPrecoVenda());
            this.stmt.setInt(6, produto.getQuantidade());
            this.stmt.setBoolean(7, produto.getAtivo());
            this.stmt.setInt(8, produto.getIdRaca());
            this.stmt.setInt(9, produto.getIdCategoria());
            this.stmt.setInt(10, produto.getIdFornecedor());

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
    	
    	try{
    		this.stmt = this.conn.prepareStatement("update produto set "
    				+ "nome = ?, "
    				+ "descricao = ?, "
    				+ "especificacao = ?, "
    				+ "precocompra = ?, "
    				+ "precovenda = ?, "
    				+ "quantidade = ?, "
    				+ "ativo = ?, "
    				+ "idraca = ?, "
    				+ "idcategoria = ?, "
    				+ "idfornecedor = ? "
    				+ "where id = ?");
    		
            this.stmt.setString(1, produto.getNome());
            this.stmt.setString(2, produto.getDescricao());
            this.stmt.setString(3, produto.getEspecificacao());
            this.stmt.setDouble(4, produto.getPrecoCompra());
            this.stmt.setDouble(4, produto.getPrecoVenda());
            this.stmt.setInt(5, produto.getQuantidade());
            this.stmt.setBoolean(6, produto.getAtivo());
            this.stmt.setInt(7, produto.getIdRaca());
            this.stmt.setInt(8, produto.getIdCategoria());
            this.stmt.setInt(9, produto.getIdFornecedor());
            this.stmt.setInt(9, produto.getId());
            
            this.stmt.executeUpdate();
    	}catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }

    }

}
