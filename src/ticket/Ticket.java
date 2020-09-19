
package ticket;

import java.time.LocalDateTime;
import vehiculos.Vehiculo;

/**
 *
 * @author bapo
 */
public class Ticket extends AbstractTicket
{
    
    private double Monto;
    private final LocalDateTime Fecha;
    private final Vehiculo Vehiculo;
    private boolean telepase;
    
    public Ticket ( LocalDateTime Fecha, Vehiculo vehiculo )
    {
        this.Fecha = Fecha;
        this.Vehiculo = vehiculo;
        this.Monto = this.Vehiculo.getPrecioNoPico();
    }
    
    @Override
    public double getMonto() 
    {
        return this.Monto;
    }

    @Override
    public LocalDateTime getFecha()
    {
        return this.Fecha;
    }

    @Override
    public Vehiculo getVehiculo()
    {
        return this.Vehiculo;
    }

    @Override
    protected void setMonto(double Monto) 
    {
        this.Monto = Monto;
    }

    @Override
    protected void setTelePase(boolean isTelepase) 
    {
        this.telepase = isTelepase;
    }

    @Override
    protected boolean getTelePase() 
    {
        return this.telepase;
    }
    
}
