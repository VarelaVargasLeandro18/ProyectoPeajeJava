
package vehiculos;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author bapo
 */
public class FabricaDirectorVehiculo
{
    
    private List<Vehiculo> vehiculos;
    private static FabricaDirectorVehiculo singleton = null;
    
    public static enum Vehiculos
    {
        
        MOTO,
        LIVIANO,
        LIVIANO_REMOLQUE,
        PESADO_DOS_EJES,
        PESADO_TRES_EJES,
        PESADO_CUATRO_EJES,
        PESADO_CINCO_A_SIETE_EJES
    
    }
    
    private FabricaDirectorVehiculo ()
    {
        
        vehiculos = new ArrayList();
        
        try
        {
            for ( int i = 0; i < Vehiculos.values().length; i++ )
                vehiculos.add ( new ConcreteBuilder ( i ).construir() );
        }
        catch ( SQLException ex ){}
        
    }
    
    public static FabricaDirectorVehiculo getInstance ()
    {
        
        if ( singleton == null )
            singleton = new FabricaDirectorVehiculo();
        
        return singleton;
        
    }
    
    public Vehiculo getVehiculo ( Vehiculos v )
    {
        
        return this.vehiculos.get(v.ordinal());
        
    }
    
    
    
}
