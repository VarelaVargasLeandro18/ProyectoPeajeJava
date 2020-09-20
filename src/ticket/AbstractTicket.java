
package ticket;

import conexionBD.accesoADatos;
import java.time.*;
import vehiculos.Vehiculo;

/**
 *
 * @author bapo
 */
public abstract class AbstractTicket
{
    
    protected int DNI;
    protected double Monto;
    protected LocalDateTime Fecha;
    protected Vehiculo Vehiculo;
    protected boolean telepase;
    
    public abstract double getMonto();
    public abstract LocalDateTime getFecha();
    public abstract Vehiculo getVehiculo();
    
    protected abstract void setMonto( double Monto );
    protected abstract void setTelePase( boolean isTelepase );
    protected abstract boolean getTelePase();
    
    public boolean IngresarTicket()
    {
        
        try
        {
            //CALL crearTicket ( 0, '2017-03-13T14:39:01.123', 'Moto', 'Pico');
            accesoADatos.getInstance().actualizarProcedure( String.format("CALL PROCEDURE crearTicket ( %d, %s, %s, %s, );", 0, this.Fecha, this.Vehiculo.getDescripcion(), "NoPico" ) );
            return true;
        }
        catch ( Exception ex )
        {
            
            return false;
            
        }
        
    }
    
    @Override
    public String toString()
    {
        
        String ret = new String();
        
        ret += String.format("Ticket:\n\tFecha: %s\n\tMonto: %s\n\tVehiculo: %s\n\tTelepase: %b\n", this.Fecha, this.Monto, this.Vehiculo.getDescripcion(), this.telepase );
        
        return ret;
        
    }
    
}
