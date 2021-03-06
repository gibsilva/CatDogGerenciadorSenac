package br.senac.tads.catdoggerenciador.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBd {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //private static final String URL = "jdbc:mysql://localhost:3306/catdog";
    private static final String URL = "jdbc:mysql://localhost:3307/catdog";
    private static final String USER = "root";
    //private static final String PASS = "mysql";
    private static final String PASS = "";
    
    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao se conectar com o banco de dados: ", ex);
        }
    }
    
    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao fechar a conexão: ", ex);
        }
    }

    public void closeConnection(Connection conn, PreparedStatement stmt) {
        closeConnection(conn);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao fechar a conexão: ", ex);
        }
    }

    public void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConnection(conn, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao fechar a conexão: ", ex);
        }
    }
}
