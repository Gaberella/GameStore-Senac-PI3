/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Modelos;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author macba
 */
@Getter
@Setter
public class Venda {
    
    private String nome;
    private String endereco;
    private String email;
    private Date  dataVenda;
    private BigDecimal  valorVenda;
    private String  tipoPagamento;
    private int idVenda;
    private int idProduto;
    private int idFilial;

    /*public Venda(int idVenda, Date data, String nomeComprador, String cartaoComprador, String codSegurancaComprador, Double valor, int idProduto, int idFilial) {
        this.idVenda = idVenda;
        this.data = data;
        this.nomeComprador = nomeComprador;
        this.cartaoComprador = cartaoComprador;
        this.codSegurancaComprador = codSegurancaComprador;
        this.valor = valor;
        this.idProduto = idProduto;
        this.idFilial = idFilial;
    }*/

    @Override
    public String toString() {
        return "Venda{" + "nome=" + nome + ", endereco=" + endereco + ", email=" + email + ", dataVenda=" + dataVenda + ", valorVenda=" + valorVenda + ", tipoPagamento=" + tipoPagamento + ", idVenda=" + idVenda + ", idProduto=" + idProduto + ", idFilial=" + idFilial + '}';
    }

    

    
}
