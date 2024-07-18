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
public class CadastroProduto {
    
    private String nomeproduto;
    private String modelo;
    private String tamanho;
    private String cor;
    private int quantidade;
    private int codigoP;
    private double preco;   
    
     /**
     * Construtor criado para inserir dados ao MySQl
     * @param nomeproduto String
     * @param modelo String
     * @param tamanho String
     * @param cor String
     * @param quantidade int
     * @param codigoP int
     * @param preco double
     */

    
    public CadastroProduto(String nomeproduto, String modelo, String tamanho, String cor, int quantidade, int codigoP, double preco) {
        this.nomeproduto = nomeproduto;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.cor = cor;
        this.quantidade = quantidade;
        this.codigoP = codigoP;
        this.preco = preco;
    }
    
   public CadastroProduto() {
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
