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
    
    private int idVenda;
    private Date  data;
    private String  nomeComprador;
    private String  cartaoComprador;
    private String  codSegurancaComprador;
    private BigDecimal  valor;
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
        return "Venda{" + "idVenda=" + idVenda + ", data=" + data + ", nomeComprador=" + nomeComprador + ", cartaoComprador=" + cartaoComprador + ", codSegurancaComprador=" + codSegurancaComprador + ", valor=" + valor + ", idProduto=" + idProduto + ", idFilial=" + idFilial + '}';
    }

    
    
}
