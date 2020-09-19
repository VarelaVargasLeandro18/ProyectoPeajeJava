
package cajero;

/**
 *
 * @author bapo
 */
public class Cajero 
{
    
    private static Cajero cajero = null;
    
    private int DNI;
    
    private Cajero () {}
    
    public static boolean Validar ( String Usuario, String Password)
    {
        
        return true;
        
    }
    
    public static Cajero getInstance ()
    {
        
        if ( cajero == null )
            cajero = new Cajero();
        
        return cajero;
        
    }
    
    public int getDNI ()
    {
        return this.DNI;
    }
    
}
