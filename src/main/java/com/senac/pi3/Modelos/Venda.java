/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Modelos;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author macba
 */
@Getter
@Setter
public class Venda {
    
    private Cliente cliente;
    private Usuario funcionario;
    private List<Produto> produtos;
    private Float valorTotal;
    private Date data;

   public Venda()
   {

   } 

   public Venda(Cliente cliente,List<Produto> produtos, Funcionario funcionario, Float valorTotal, Date data)
   {
       this.cliente = cliente;
       this.produtos = produtos;
       this.valorTotal = valorTotal;
       this.data = data;
   }

    

    
}
