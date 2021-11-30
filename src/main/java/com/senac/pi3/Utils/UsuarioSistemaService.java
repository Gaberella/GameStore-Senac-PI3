
package com.senac.pi3.Utils;

import com.senac.pi3.DAOs.ClienteDAO;
import com.senac.pi3.Modelos.Usuario;
import java.sql.SQLException;

public class UsuarioSistemaService 
{
    public Usuario buscarPorEmail(String email) throws SQLException {
        return ClienteDAO.buscarPorEmail(email);
    }
}
