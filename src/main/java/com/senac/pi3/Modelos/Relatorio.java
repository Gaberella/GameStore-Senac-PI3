/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Modelos;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author macba
 */
@Getter
@Setter
public class Relatorio {
    
    private int idPedido;
    private Cliente cliente;
    private Funcionario funcionario;
    private int idFilial;
    private Date data;
    private double precovenda;
    
}
