/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.pi3.Modelos;

import java.util.Date;


import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario 
{
   private int id;
    private String nome;
    private Date dtNascimento;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private String endereco;
    private String senha;
    private Filial filial;
    
    /**
     * tipoAcesso = 1 -> Acesso de Cliente
     * tipoAcesso = 2 -> Acesso de Funcionário de filial
     * tipoAcesso = 3 -> Acesso de Funcionário Gerente de filial
     * tipoAcesso = 4 -> Acesso de Funcionário Gerente Regional
     * tipoAcesso = 5 -> Acesso de Funcionário TI
     * tipoAcesso = 6 -> Acesso de Funcionário Backoffice
     * tipoAcesso = 7 -> Acesso de Funcionário RH
     */
    private int tipoAcesso;
    private char sexo;
    
    public Usuario() {
        
    }
    
    public Usuario(int id, String nome, Date dtNascimento, String cpf, String rg, String telefone, String email, String endereco, String senha, int tipoAcesso, char sexo, Filial filial) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
        this.sexo = sexo;
        this.filial = filial;
    }
}

