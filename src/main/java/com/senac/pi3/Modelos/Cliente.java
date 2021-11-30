/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.pi3.Modelos;

/**
 *
 * @author Gabri
 */
import java.util.Date;



public class Cliente extends Usuario
{
    public Cliente() {
    }

    public Cliente(int id, String nome, Date dtNascimento, String cpf, String rg, String telefone, String email, String endereco, String senha, int tipoAcesso, char sexo, Filial filial) {
        super(id, nome, dtNascimento, cpf, rg, telefone, email, endereco, senha, tipoAcesso, sexo, filial);
    }
}