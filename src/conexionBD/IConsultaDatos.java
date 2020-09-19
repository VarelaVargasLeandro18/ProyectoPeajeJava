/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bapo
 */
interface IConsultaDatos 
{
    public List<String> consultarProcedure (String sCall) throws SQLException;
    public List<String> consultarStatement (String sQuery) throws SQLException;    
}
