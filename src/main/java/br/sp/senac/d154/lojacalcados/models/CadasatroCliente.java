/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.d154.lojacalcados.models;

/**
 *classe criada para a criação de uma loja
 * @author vitoria, valmir, lorena e matheus
 * @since 2023-11-30
 * @version 1.0
 */

public class CadasatroCliente {
   private String nome;
   private String cpf;
   private String complemento;
   private String endereco;
   private String telefone;
   private int ClienteID;
   private String numero;
   private String email;
   private String estadocivil;
   private String sexo;

     /**
     * Construtor criado para inserir dados ao MySQl
     * @param ClienteID int
     * @param nome String
     * @param cpf String
     * @param endereco String
     * @param telefone String
     */
   
    public CadasatroCliente(int ClienteID,String nome, String cpf, String endereco, String telefone ) {
        this.ClienteID = ClienteID;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        
    }

    
    public CadasatroCliente(){

    }   

    public CadasatroCliente(String nome, String cpf, String complemento, String endereco, String telefone, int ClienteID, String numero, String email, String estadocivil, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.complemento = complemento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.ClienteID = ClienteID;
        this.numero = numero;
        this.email = email;
        this.estadocivil = estadocivil;
        this.sexo = sexo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}