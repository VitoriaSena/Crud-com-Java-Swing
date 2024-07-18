/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.d154.lojacalcados.models;

import java.util.Date;

/**
 *classe criada para a criação de uma loja
 * @author vitoria, valmir, lorena e matheus
 * @since 2023-11-30
 * @version 1.0
 */
public class Relatorio {
    
    private Date dataInicial;
    private Date dataFinal;
    private String nome;
    private String ValorProd;
    private int ClienteID;
    private double ValorTotal;
    
      /**
     * Construtor criado para inserir dados ao MySQl
     * @param dataInicial Date
     * @param dataFinal Date
     * @param nome String
     * @param ValorProd String
     * @param ClienteID int
     * @param ValorTotal double
     */


    public Relatorio(Date dataInicial, Date dataFinal, String nome, String ValorProd, int ClienteID, double ValorTotal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.nome = nome;
        this.ValorProd = ValorProd;
        this.ClienteID = ClienteID;
        this.ValorTotal = ValorTotal;
      
    }
    
    public Relatorio() {
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValorProd() {
        return ValorProd;
    }

    public void setValorProd(String ValorProd) {
        this.ValorProd = ValorProd;
    }

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }
     
    
    
}
