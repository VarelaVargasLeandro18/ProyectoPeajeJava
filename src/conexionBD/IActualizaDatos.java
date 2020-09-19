/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.SQLException;

/**
 *
 * @author bapo
 */
interface IActualizaDatos 
{
    public boolean actualizarProcedure (String sCall) throws SQLException;
    public boolean actualizarStatement (String sQuery) throws SQLException;
}
