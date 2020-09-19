
package ticket;

import java.time.*;
import vehiculos.Vehiculo;

/**
 *
 * @author bapo
 */
public abstract class AbstractTicket 
{
    
    public abstract double getMonto();
    public abstract LocalDateTime getFecha();
    public abstract Vehiculo getVehiculo();
    
    protected abstract void setMonto( double Monto );
    protected abstract void setTelePase( boolean isTelepase );
    protected abstract boolean getTelePase();
    
}
