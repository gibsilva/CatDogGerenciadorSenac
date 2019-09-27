/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.catdoggerenciador.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.tads.catdoggerenciador.dao.interfaces.IUsuario;
import br.senac.tads.catdoggerenciador.entidades.Usuario;

/**
 *
 * @author Girlaine
 */
public class UsuarioDao extends BaseDao implements IUsuario {

    private Connection conn;

    @Override
    public Usuario obterPorId(int id) {
        Connection conn = conexao.getConnection();
        Usuario usuario = null;

        try {
            this.stmt = conn.prepareStatement("select id, nome, cpf, Email,"
                    + "login, senha, ativo, permissao, from usuario where id = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("IdUsuario"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("Email"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo"),
                        rs.getString("permissao")
                );
            }

            return usuario;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }
    
        public Usuario obterPorEmail(String email) {
        Connection conn = conexao.getConnection();
        Usuario usuario = null;

        try {
             this.stmt = conn.prepareStatement("select id, nome, cpf, Email,"
                    + "login, senha, ativo, permissao, from usuario where id = ?");

            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("IdUsuario"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("Email"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo"),
                        rs.getString("permissao")
                );
            }

            return usuario;
        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt, rs);
            return null;
        }
    }

    public Usuario obterPorEmail(String email, int id) {
        Connection conn = conexao.getConnection();
        Usuario usuario = null;

        try {
             this.stmt = conn.prepareStatement("select id, nome, cpf, Email,"
                    + "login, senha, ativo, permissao, from usuario where id = ?");

            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("IdUsuario"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("Email"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo"),
                        rs.getString("permissao")
                );
 
            }

            return usuario;
        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt, rs);
            return null;
        }
    }

    @Override
    public List<Usuario> obterTodos() {
        this.conn = conexao.getConnection();
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            this.stmt = conn.prepareStatement("select id, nome, cpf, Email,"
                    + "login, senha, ativo, permissao, from usuario where id = ?");

            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("IdUsuario"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("Email"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo"),
                        rs.getString("permissao")
                );

                usuarios.add(usuario);
            }

            return usuarios;
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void salvar(Usuario usuario) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("insert into usuario(nome, cpf, Email,"
                    + "login, senha, permissao) values (?, ?, ?, ?, ?, ?)");

            this.stmt.setString(1, usuario.getNome());
            this.stmt.setString(2, usuario.getCpf());
            this.stmt.setString(3, usuario.getEmail());
            this.stmt.setString(4, usuario.getLogin());
            this.stmt.setString(5, usuario.getSenha());
            this.stmt.setString(7, usuario.getPermissao());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }

    }

    @Override
    public void alterar(Usuario usuario) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("update usuario set nome = ?, cpf = ?, Email = ?,"
                    + "login = ?, senha = ?, ativo = ?, permissao = ? where id = ?");

            this.stmt.setString(1, usuario.getNome());
            this.stmt.setString(2, usuario.getCpf());
            this.stmt.setString(3, usuario.getEmail());
            this.stmt.setString(4, usuario.getLogin());
            this.stmt.setString(5, usuario.getSenha());
            this.stmt.setBoolean(6, usuario.getAtivo());
            this.stmt.setString(7, usuario.getPermissao());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void alterarStatus(Usuario usuario) {
        this.conn = conexao.getConnection();

        try {
            this.stmt = conn.prepareStatement("update usuario set ativo = 0 where id = ?");
            this.stmt.setInt(1, usuario.getId());

            this.stmt.executeUpdate();
        } catch (SQLException e) {
            this.conexao.closeConnection(conn, stmt, rs);
            throw new RuntimeException(e.getMessage());
        } finally {
            this.conexao.closeConnection(conn, stmt, rs);
        }
    }
    
    @Override
    public Usuario autenticar(String nome, String senha) {
        Connection conn = conexao.getConnection();
        Usuario usuario = null;

        try {
           this.stmt = conn.prepareStatement("select id, nome, cpf, Email,"
                    + "login, senha, ativo, permissao from usuario where login = ? and senha = ?");

            stmt.setString(1, nome);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("IdUsuario"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("Email"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getBoolean("ativo"),
                        rs.getString("permissao")
                );
            }

            return usuario;
        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void alterarSenha(Usuario usuario) {
        Connection conn = conexao.getConnection();

        try {
            stmt = conn.prepareStatement("update usuario set senha = ? where id = ?");
            stmt.setString(1, usuario.getSenha());
            stmt.setInt(2, usuario.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt);
            throw new RuntimeException(ex.getMessage());
        } finally {
            conexao.closeConnection(conn, stmt);
        }
    }

    @Override
    public boolean validarLogin(String login, String senha) {
        Connection conn = conexao.getConnection();
        boolean condicao = false;

        try {
            stmt = conn.prepareStatement("select login, "
                    + "senha "
                    + "from usuario where login = ? and senha = ?");

            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                condicao = true;
            }

        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt, rs);
            return false;
        } finally {
            conexao.closeConnection(conn, stmt, rs);
        }
        return condicao;
    }

}
