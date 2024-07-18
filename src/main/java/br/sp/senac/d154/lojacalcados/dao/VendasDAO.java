/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.d154.lojacalcados.dao;

import br.sp.senac.d154.lojacalcados.models.Vendas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Classe criada para a tranferência de dados entre o Java e o MySQL
 * @author vitoria, valmir, lorena e matheus
 * @since 2023-11-30
 * @version 1.0
 */
public class VendasDAO {
    
    static String url = "jdbc:mysql://localhost:3306/loja";
    static String login = "root";
    static String senha = "admin000";

      /**
     * Método criado para acessar o banco de dados
     * @param  url String
     * @param login String
     * @param senha String
     
     */

    
   public static boolean salvar(Vendas novaVenda) {
    boolean retorno = false;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection conexao = DriverManager.getConnection(url, login, senha);
         PreparedStatement comandoSQL = conexao.prepareStatement(
                 "INSERT INTO vendas (produto, quantidade, valorTotal, datanota) VALUES ( ?, ?, ?, ? ) " ,
                 PreparedStatement.RETURN_GENERATED_KEYS)) {
        comandoSQL.setString(1, novaVenda.getNomeproduto());
        comandoSQL.setString(2, novaVenda.getQuantidade());
        comandoSQL.setDouble(3, novaVenda.getValorTotal());
        comandoSQL.setDate(4, new java.sql.Date(novaVenda.getDataNota().getTime()));

        int linhasAfetadas = comandoSQL.executeUpdate();

        if (linhasAfetadas > 0) {
            retorno = true;
        }
        
        
        
        
        
    } catch (SQLException ex) {
        ex.printStackTrace(); // Trate a exceção conforme necessário
        retorno = false;
    }
} catch (ClassNotFoundException e) {
    e.printStackTrace(); // Trate a exceção conforme necessário
    retorno = false;
}
return retorno;
   }
   
     public static List<Vendas> buscarVendasPorPeriodo(java.util.Date dataInicial, java.util.Date dataFinal) throws ClassNotFoundException {
        List<Vendas> vendas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, login, senha);

       String query = "SELECT * FROM vendas WHERE datanota BETWEEN ? AND ?";
    try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
        preparedStatement.setDate(1, new java.sql.Date(dataInicial.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(dataFinal.getTime()));
        ResultSet resultSet = preparedStatement.executeQuery();
            // Processar e adicionar os resultados à lista
            
            while (resultSet.next()) {
                Vendas venda = new Vendas();
                venda.setNomeproduto(resultSet.getString("produto"));
                venda.setQuantidade(resultSet.getString("quantidade"));
                venda.setValorTotal(resultSet.getDouble("valor_total"));
                vendas.add(venda);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Você pode lançar uma exceção personalizada ou lidar de outra forma
        throw new RuntimeException("Erro ao buscar vendas do banco de dados: " + ex.getMessage(), ex);
    }

    return vendas;
}

}