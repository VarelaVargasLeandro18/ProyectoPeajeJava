
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
            for ( int i = 0; i < 5 ; i++ )
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
            
            if ( Boolean.logicalAnd(horaEnHoras.isAfter ( bh.getInicio() ), horaEnHoras.isBefore ( bh.getFin() )) )
            {
                return bh;
            }
            else if ( horaEnHoras.equals ( bh.getInicio() ) || horaEnHoras.equals ( bh.getFin() ) )
            {
                return bh;
            }
            
        }
        
        System.out.println ( "NULL" );
        
        return null;
        
    }
    
}
