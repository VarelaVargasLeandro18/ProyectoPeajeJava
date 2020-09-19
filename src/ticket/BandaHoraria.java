
package ticket;

import conexionBD.accesoADatos;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author bapo
 */
public class BandaHoraria 
{
    
    private int ID;
    private LocalTime Inicio;
    private LocalTime Fin;
    private String Tipo;
    
    protected BandaHoraria ( int ID ) throws SQLException
    {
        
        List<String> datos = accesoADatos.getInstance().consultarProcedure("CALL getBandaHorariaID( " + ID + " )");
        this.ID = Integer.parseInt(datos.get(0));
        this.Inicio = LocalTime.parse ( datos.get(1) , DateTimeFormatter.ofPattern( "HH:mm:ss" ) );
        this.Fin = LocalTime.parse ( datos.get(2) , DateTimeFormatter.ofPattern( "HH:mm:ss" ) );
        this.Tipo = datos.get(3);    
        
    }
    
    public LocalTime getInicio()
    {
        return this.Inicio;
    }
    
    public LocalTime getFin()
    {
        return this.Fin;
    }
    
    public String getStrInicio()
    {
        return this.Inicio.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    
    public String getStrFin()
    {
        return this.Fin.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    
    public String getStrTipo()
    {
        return this.Tipo;
    }
    
}
