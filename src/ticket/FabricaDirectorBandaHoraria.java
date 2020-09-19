
package ticket;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author bapo
 */
public class FabricaDirectorBandaHoraria 
{
    
    private List<BandaHoraria> bandasHorarias = new ArrayList();
    private static FabricaDirectorBandaHoraria singleton = null;
    
    private FabricaDirectorBandaHoraria ()
    {
        
        try
        {
            for ( int i = 0; i < 4; i++ )
            {
                this.bandasHorarias.add ( new BandaHoraria ( i ) );
            }
        }
        catch ( SQLException ex )
        {
            System.out.println ( ex.toString() );
        }
        
    }
    
    public static FabricaDirectorBandaHoraria getInstance ()
    {
        
        if ( singleton == null )
            singleton = new FabricaDirectorBandaHoraria();
        
        return singleton;
        
    }
    
    public BandaHoraria getBandaHoraria ( int i )
    {
        return this.bandasHorarias.get(i);
    }
    
    public BandaHoraria getBandaHorariaporHora ( LocalDateTime hora )
    {
        
        LocalTime horaEnHoras = hora.toLocalTime();
        
        for ( BandaHoraria bh : this.bandasHorarias )
        {
            
            LocalTime inicio = bh.getInicio();
            LocalTime fin = bh.getFin();
            
            if ( horaEnHoras.compareTo ( inicio ) > 0 && horaEnHoras.compareTo ( fin ) < 0 )
                return bh;
            
        }
        
        return null;
        
    }
    
}
