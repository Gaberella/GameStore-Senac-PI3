/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.BLL;

import com.senac.pi3.DAOs.RelatorioDAO;
import com.senac.pi3.Modelos.Relatorio;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author macba
 */
public class RelatoriBLL {
    
    public static List<Relatorio> listar(int filtro, int tipoacesso, int idFilial)throws SQLException, ClassNotFoundException{
        return RelatorioDAO.listar(filtro, tipoacesso, idFilial);
    }
    
}
