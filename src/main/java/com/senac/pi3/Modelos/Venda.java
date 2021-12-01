
package com.senac.pi3.Modelos;

import java.util.List;

public class Venda 
{   
    private Cliente cliente;
    private Cliente funcionario;
    private List<Produto> produtos;
    private Float valorTotal;
    
   public Venda()
   {
      
   } 
   
   public Venda(Cliente cliente,List<Produto> produtos, Funcionario funcionario)
   {
       this.cliente = cliente;
       this.produtos = produtos;
       this.funcionario = funcionario;
   }

    public Cliente getCliente() 
    {
        return cliente;
    }

    public void setCliente(Cliente cliente) 
    {
        this.cliente = cliente;
    }

    public Cliente getFuncionario()
    {
        return funcionario;
    }

    public void setFuncionario(Cliente funcionario) 
    {
        this.funcionario = funcionario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) 
    {
        this.produtos = produtos;
    }

    public Float getValorTotal() 
    {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) 
    {
        this.valorTotal = valorTotal;
    }
   
}
