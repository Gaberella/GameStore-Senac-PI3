
package com.senac.pi3.Modelos;

import java.util.Date;

/**
 *
 * @author Gabri
 */
public class Relatorio 
{
    private int idPedido;
    private Cliente cliente;
    private Funcionario funcionario;
    private int idFilial;
    private Date data;
    private double precoVenda;

    public int getIdPedido() 
    {
        return idPedido;
    }

    public void setIdPedido(int idPedido) 
    {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() 
    {
        return cliente;
    }

    public void setCliente(Cliente cliente) 
    {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() 
    {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) 
    {
        this.funcionario = funcionario;
    }

    public int getIdFilial() 
    {
        return idFilial;
    }

    public void setIdFilial(int idFilial) 
    {
        this.idFilial = idFilial;
    }

    public Date getData() 
    {
        return data;
    }

    public void setData(Date data) 
    {
        this.data = data;
    }

    public double getPrecoVenda() 
    {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) 
    {
        this.precoVenda = precoVenda;
    }
    
    
}
