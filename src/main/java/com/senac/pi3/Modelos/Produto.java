/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.pi3.Modelos;

import java.math.BigDecimal;

/**
 *
 * @author Gabriela Oliveira
 */
public class Produto 
{
    
    private int idProduto;
    private String nomeProduto;
    private BigDecimal preco;
    private String fabricante;
    private int quantidade;
    private String modelo;
    private String codBarras;
    //private Filial filal;
    
    public Produto()
    {
        
    }
   
    public Produto(String nomeProduto, BigDecimal preco, String fabricante, int quantidade, String modelo, String codBarras)
    {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.modelo = modelo;
        this.codBarras = codBarras; 
    }
    
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }
}
