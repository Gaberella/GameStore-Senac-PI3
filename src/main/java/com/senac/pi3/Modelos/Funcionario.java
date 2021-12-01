/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.pi3.Modelos;

import java.util.Date;

public class Funcionario extends Cliente
       
{
    public Funcionario()
    {
        
    }
    
    public Funcionario(int id, String nome, Date dataNascimento, String cpf, String rg, char sexo, String telefone, String email, String endereco, String senha,Filial filial)
    {
         super(id, nome, dataNascimento, cpf, rg, sexo, telefone,email,endereco,senha,filial);
    }
    
}


