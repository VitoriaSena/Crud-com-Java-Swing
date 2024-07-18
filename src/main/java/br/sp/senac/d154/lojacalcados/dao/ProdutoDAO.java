/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.d154.lojacalcados.dao;

import br.sp.senac.d154.lojacalcados.models.CadastroProduto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Classe criada para a tranferência de dados entre o Java e o MySQL
 * @author vitoria, valmir, lorena e matheus
 * @since 2023-11-30
 * @version 1.0
 */
public class ProdutoDAO {
    static String url = "jdbc:mysql://localhost:3306/loja";
    static String login = "root";
    static String senha = "admin000";
    
     /**
     * Método criado para acessar o banco de dados
     * @param  url String
     * @param login String
     * @param senha String
     */
    
    public static boolean salvar(CadastroProduto novoProduto){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            conexao = DriverManager.getConnection(url, login,senha);
            
            comandoSQL=conexao.prepareStatement("INSERT INTO Estoque(nomeproduto,modelo,tamanho,cor,quantidade,preco) "
                    + "VALUES(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, novoProduto.getNomeproduto());
            comandoSQL.setString(2, novoProduto.getModelo());
            comandoSQL.setString(3, novoProduto.getTamanho());
            comandoSQL.setString(4, novoProduto.getCor());
            comandoSQL.setInt(5, novoProduto.getQuantidade());
            comandoSQL.setDouble(6, novoProduto.getPreco());
            //Executar
            
            int linhasafetadas = comandoSQL.executeUpdate();
            
            if(linhasafetadas>0){
                retorno= true;
            
                rs = comandoSQL.getGeneratedKeys();
                
                if(rs!=null){
                    while(rs.next()){
                      int idgerado = rs.getInt(1);
                    }
                }
            }
            
                    } catch(ClassNotFoundException ex){
                        retorno= false;
                    }  catch(SQLException ex){
                        System.out.println(ex);
                    }finally{
            
                if(conexao != null){
                    try {
                        conexao.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        }
        
        return retorno;
    }
public static ArrayList<CadastroProduto> listar(){
        
        ArrayList<CadastroProduto> lista = new ArrayList<>();
        
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
          conexao = DriverManager.getConnection(url,login,senha);
            
         comandoSQL = conexao.prepareStatement("SELECT *FROM estoque");
            
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    CadastroProduto item = new CadastroProduto();
                    item.setCodigoP(rs.getInt("codigoP"));
                    item.setNomeproduto(rs.getNString("nomeproduto"));
                    item.setModelo(rs.getNString("Modelo"));
                    item.setCor(rs.getNString("Cor"));
                    item.setTamanho(rs.getNString("Tamanho"));
                    item.setQuantidade(rs.getInt("Quantidade"));
                    item.setPreco(rs.getDouble("Preco"));
                    
                    lista.add(item);
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            if(conexao!= null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         }
             
            return lista;
        }

public static ArrayList<CadastroProduto> buscarPorNumero(int numeroBuscar){
         
        ArrayList<CadastroProduto> lista = new ArrayList<>();
        
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
          conexao = DriverManager.getConnection(url,login,senha);
            
         comandoSQL = conexao.prepareStatement("SELECT *FROM estoque WHERE codigoP = ? " );
         comandoSQL.setInt(1, numeroBuscar);
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    CadastroProduto item = new CadastroProduto();
                    item.setCodigoP(rs.getInt("codigoP"));
                    item.setNomeproduto(rs.getNString("nomeproduto"));
                    item.setModelo(rs.getNString("Modelo"));
                    item.setCor(rs.getNString("Cor"));
                    item.setTamanho(rs.getNString("Tamanho"));
                    item.setQuantidade(rs.getInt("Quantidade"));
                    item.setPreco(rs.getDouble("Preco"));
                    
                    lista.add(item);
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            if(conexao!= null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         }
             
            return lista;
        }
            
        public static boolean alterar(CadastroProduto alterarProduto){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            conexao = DriverManager.getConnection(url, login,senha);
            
            comandoSQL=conexao.prepareStatement("UPDATE estoque SET  nomeproduto = ? , modelo = ? , cor = ? , tamanho = ?,quantidade = ?, preco = ?  WHERE CodigoP = ? " );
            
            comandoSQL.setString(1, alterarProduto.getNomeproduto());
            comandoSQL.setString(2, alterarProduto.getModelo());   
            comandoSQL.setString(3, alterarProduto.getCor());
            comandoSQL.setString(4, alterarProduto.getTamanho());
            comandoSQL.setInt(5, alterarProduto.getQuantidade());
            comandoSQL.setDouble(6, alterarProduto.getPreco());
            comandoSQL.setInt(7, alterarProduto.getCodigoP());
            
            int linhasafetadas = comandoSQL.executeUpdate();
            
            if(linhasafetadas>0){
                retorno= true;
            
            }
            
                    } catch(ClassNotFoundException ex){
                        retorno= false;
                    }  catch(SQLException ex){
                       retorno= false;
                    }finally{
            
                if(conexao != null){
                    try {
                        conexao.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        }
        
        return retorno;
    }        
public static boolean Excluir(int ExcluirProduto){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            conexao = DriverManager.getConnection(url, login,senha);
            
            comandoSQL=conexao.prepareStatement("DELETE FROM estoque WHERE codigoP = ? " );
            
            comandoSQL.setInt(1, ExcluirProduto);
            
            int linhasafetadas = comandoSQL.executeUpdate();
            
            if(linhasafetadas>0){
                retorno= true;
            
            }
            
                    } catch(ClassNotFoundException ex){
                        retorno= false;
                    }  catch(SQLException ex){
                       retorno=false;
                    }finally{
            
                if(conexao != null){
                    try {
                        conexao.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        }
        
        return retorno;
    }        
    public static boolean atualizarQuantidadeEstoque(int idProduto, int quantidadeRetirar) {
        boolean sucesso = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            // Realizar a retirada da quantidade do estoque no banco de dados
            comandoSQL = conexao.prepareStatement("UPDATE Estoque SET quantidade = quantidade - ? WHERE codigoP = ?");
            comandoSQL.setInt(1, quantidadeRetirar);
            comandoSQL.setInt(2, idProduto);

            int linhasAfetadas = comandoSQL.executeUpdate();

            sucesso = linhasAfetadas > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            sucesso = false;
            System.out.println(ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return sucesso;
    }
    public static void atualizarEstoque(int idProduto, int quantidade) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            conexao = DriverManager.getConnection(url, login, senha);

            comandoSQL = conexao.prepareStatement("UPDATE estoque SET Quantidade = Quantidade + ? WHERE codigoP = ?" );
            comandoSQL.setInt(1, quantidade);
            comandoSQL.setInt(2, idProduto);

            comandoSQL.executeUpdate();
        } finally {
            if (comandoSQL != null) {
                comandoSQL.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace(); // Lida com a exceção conforme necessário
    }
}
}