
package com.senac.pi3.Utils;

import com.senac.pi3.DAOs.ClienteDAO;
import com.senac.pi3.Modelos.Cliente;
import java.sql.SQLException;

public class UsuarioSistemaService 
{
    public Cliente buscaPorEmail(String email) throws SQLException
    {
        return ClienteDAO.buscaPorEmail(email);
        
    }
}
