/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.pi3.Modelos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Gabriela Oliveira
 */


@Getter
@Setter
public class Produto {
    private int idProduto;
    private String nome;
    private BigDecimal preco;
    private String fabricante;
    private int quantidade;
    private String modelo;
    private String codBarras;
    private Filial filial;
    

    public Produto() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    

    public Produto(String nome, BigDecimal preco, String fabricante, int quantidade, String modelo, String codBarras, Filial filial) {
        this.nome = nome;
        this.preco = preco;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.modelo = modelo;
        this.codBarras = codBarras;
        this.filial = filial;
    }
}