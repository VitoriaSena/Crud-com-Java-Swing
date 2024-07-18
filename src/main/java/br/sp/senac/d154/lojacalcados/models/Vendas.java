/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.d154.lojacalcados.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *classe criada para a criação de uma loja
 * @author vitoria, valmir, lorena e matheus
 * @since 2023-11-30
 * @version 1.0
 */

public class Vendas {
    private int idcompra;
    private String nomeproduto; 
    private String tamanho; 
    private int codigoP; 
    private double produtoPreco; 
    private String quantidade;
    private double valorTotal;
    private Date dataNota;
    private String cpfcompra;
    
    /**
     * Construtor criado para inserir dados ao MySQl
     * @param nomeproduto String
     * @param quantidade String
     * @param valorTotal double
     * @param dataNota Date
     * @param cpfcompra 
     */

    public Vendas(String nomeproduto, String quantidade, double valorTotal, Date dataNota, String cpfcompra) {
        this.nomeproduto = nomeproduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.dataNota = dataNota;
        this.cpfcompra = cpfcompra;
    }
 
    public Vendas(String nomeproduto, String quantidade, double valorTotal, Date dataNota) {
        this.nomeproduto = nomeproduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.dataNota = dataNota;
    }
    public Vendas(int idcompra, String nomeproduto, String tamanho, int codigoP, double produtoPreco, String quantidade, double valorTotal, Date dataNota, String cpfcompra) {
        this.idcompra = idcompra;
        this.nomeproduto = nomeproduto;
        this.tamanho = tamanho;
        this.codigoP = codigoP;
        this.produtoPreco = produtoPreco;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.dataNota = dataNota;
        this.cpfcompra = cpfcompra;
    }

    public Vendas() {
        
    }

    public String getCpfcompra() {
        return cpfcompra;
    }

    public void setCpfcompra(String cpfcompra) {
        this.cpfcompra = cpfcompra;
    }
    

    public Date getDataNota() {
        return dataNota;
    }

    public void setDataNota(Date dataNota) {
        this.dataNota = dataNota;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

    public double getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(double produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
 
    public void setDataVenda(String dataString) {
        // Aqui você precisará converter a String para um objeto Date
        // Você pode usar SimpleDateFormat novamente para isso
        try {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            this.dataNota = formatoData.parse(dataString);
        } catch (java.text.ParseException e) {
            // Lide com a exceção de parsing, se necessário
            e.printStackTrace();
        }
    }
}


    