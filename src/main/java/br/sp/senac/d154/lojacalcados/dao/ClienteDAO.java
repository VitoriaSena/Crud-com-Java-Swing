/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.d154.lojacalcados.dao;

import br.sp.senac.d154.lojacalcados.models.CadasatroCliente;
import br.sp.senac.d154.lojacalcados.models.CadastroProduto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *Classe criada para a tranferência de dados entre o Java e o MySQL
 * @author vitoria, valmir, lorena e matheus
 * @since 2023-11-30
 * @version 1.0
 */
public class ClienteDAO {
    
    static String url = "jdbc:mysql://localhost:3306/loja";
    static String login = "root";
    static String senha = "admin000";
    
     /**
     * Método criado para acessar o banco de dados
     * @param  url String
     * @param login String
     * @param senha String
     */
    
    public static boolean salvar(CadasatroCliente novoCliente) {
    boolean retorno = false;
    Connection conexao = null;
    PreparedStatement comandoSQL = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        conexao = DriverManager.getConnection(url, login, senha);

        // Verificar se o CPF já existe
        if (cpfExiste(novoCliente.getCpf())) {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado. Verifique o CPF e tente novamente.");
        } else {
            comandoSQL = conexao.prepareStatement(
                    "INSERT INTO cliente(nome,cpf,telefone,endereco,numero,complemento,email,sexo,estadoCivil) "
                            + "VALUES(?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, novoCliente.getNome());
            comandoSQL.setString(2, novoCliente.getCpf());
            comandoSQL.setString(3, novoCliente.getTelefone());
            comandoSQL.setString(4, novoCliente.getEndereco());
            comandoSQL.setString(5, novoCliente.getNumero());
            comandoSQL.setString(6, novoCliente.getComplemento());
            comandoSQL.setString(7, novoCliente.getEmail());
            comandoSQL.setString(8, novoCliente.getSexo());
            comandoSQL.setString(9, novoCliente.getEstadocivil());

            // Executar

            int linhasafetadas = comandoSQL.executeUpdate();

            if (linhasafetadas > 0) {
                retorno = true;

                rs = comandoSQL.getGeneratedKeys();

                if (rs != null) {
                    while (rs.next()) {
                        int idgerado = rs.getInt(1);
                    }
                }
            }
        }
    } catch (ClassNotFoundException ex) {
        retorno = false;
    } catch (SQLException ex) {
        retorno = false;
    } finally {

        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    return retorno;
}
          
             // fim do salvar

public static ArrayList<CadasatroCliente> listar(){
        
        ArrayList<CadasatroCliente> lista = new ArrayList<>();
        
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
          conexao = DriverManager.getConnection(url,login,senha);
            
         comandoSQL = conexao.prepareStatement( " SELECT *FROM Cliente " );
            
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    CadasatroCliente item = new CadasatroCliente();
                    item.setClienteID(rs.getInt("ClienteID"));
                    item.setNome(rs.getNString("nome"));
                    item.setCpf(rs.getNString("cpf"));
                    item.setTelefone(rs.getNString("telefone"));
                    item.setEndereco(rs.getNString("endereco"));
                    item.setNumero(rs.getNString("numero"));
                    item.setComplemento(rs.getNString("complemento"));
                    item.setEmail(rs.getNString("email"));
                    item.setSexo(rs.getNString("sexo"));
                    item.setEstadocivil(rs.getNString("estadoCivil"));
                    
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
public static ArrayList<CadasatroCliente> buscarPorNumero(int numeroBuscar){
         
        ArrayList<CadasatroCliente> lista = new ArrayList<>();
        
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
          conexao = DriverManager.getConnection(url,login,senha);
            
         comandoSQL = conexao.prepareStatement("SELECT *FROM Cliente WHERE ClienteID = ? " );
         comandoSQL.setInt(1, numeroBuscar);
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    CadasatroCliente item = new CadasatroCliente();
                    item.setClienteID(rs.getInt("ClienteID"));
                    item.setNome(rs.getNString("nome"));
                    item.setCpf(rs.getNString("cpf"));
                    item.setTelefone(rs.getNString("telefone"));
                    item.setEndereco(rs.getNString("endereco"));
                    item.setNumero(rs.getNString("numero"));
                    item.setComplemento(rs.getNString("complemento"));
                    item.setEmail(rs.getNString("email"));
                    item.setSexo(rs.getNString("sexo"));
                    item.setEstadocivil(rs.getNString("estadoCivil"));
                    
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
            
            
public static boolean alterar(CadasatroCliente alterarCliente){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            conexao = DriverManager.getConnection(url, login,senha);
            
            comandoSQL=conexao.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, endereco = ?, telefone = ? WHERE ClienteID = ? " );
            
            comandoSQL.setString(1, alterarCliente.getNome());
            comandoSQL.setString(2, alterarCliente.getCpf());   
            comandoSQL.setString(3, alterarCliente.getEndereco());
            comandoSQL.setString(4, alterarCliente.getTelefone());
            comandoSQL.setInt(5, alterarCliente.getClienteID());
            
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
public static boolean Excluir(int ExcluirCliente){
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            conexao = DriverManager.getConnection(url, login,senha);
            
            comandoSQL=conexao.prepareStatement("DELETE FROM cliente WHERE ClienteID = ? " );
            
            comandoSQL.setInt(1, ExcluirCliente);
            
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
    public static CadasatroCliente buscarPorCPF(String cpf){
         
        CadasatroCliente clienteRetorno = new CadasatroCliente();
        
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection(url,login,senha);
            
            comandoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf = ? " );
            comandoSQL.setString(1, cpf);
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    clienteRetorno.setNome((rs.getString("nome")));
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
             
            return clienteRetorno;
        }
    
   public static boolean cpfExiste(String cpf) {
    boolean cpfEncontrado = false;

    Connection conexao = null;
    PreparedStatement comandoSQL = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection(url, login, senha);

        comandoSQL = conexao.prepareStatement("SELECT cpf FROM Cliente WHERE cpf = ?");
        comandoSQL.setString(1, cpf);

        rs = comandoSQL.executeQuery();

        // Se o ResultSet tiver alguma linha, significa que o CPF existe
        cpfEncontrado = rs.next();

    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    return cpfEncontrado;
   }
}