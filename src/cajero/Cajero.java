
package cajero;

import conexionBD.accesoADatos;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import ventanas.Login;
import ventanas.Peaje;

/**
 *
 * @author bapo
 */
public class Cajero 
{
    
    private static Cajero cajero = null;
    
    private int DNI;
    
    private Cajero ( int DNI ) { this.DNI = DNI; }
    
    public static boolean Validar ( String Usuario, char[] Password)
    {
        System.out.println (Password);
        boolean logCorrecto = false;
        int DNI;
        
        try
        {

            List<String> existeUsuario;
            existeUsuario = accesoADatos.getInstance().consultarProcedure ( "CALL getCajerosDNI ( \"" + Usuario + "\", \"" + String.copyValueOf(Password) + "\" );" );
            logCorrecto = existeUsuario.size() > 0;
                System.out.println ( "DNI de Usuario: " + existeUsuario );
            
            if (logCorrecto)
            {
                DNI = Integer.parseInt ( existeUsuario.get(0) );
                Cajero.cajero = new Cajero (DNI);
            }
            else
                Cajero.cajero = null;

        }
        catch ( SQLException ex )
        {
            System.out.println ( ex.getMessage() );
        }
        
        return logCorrecto;
        
    }
    
    public static Cajero getInstance ()
    {
        return cajero;
    }
    
    public int getDNI ()
    {
        return this.DNI;
    }
    
}
