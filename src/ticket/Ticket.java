
package ticket;

import java.time.LocalDateTime;
import vehiculos.Vehiculo;

/**
 *
 * @author bapo
 */
public class Ticket extends AbstractTicket
{
    
    public Ticket ( LocalDateTime Fecha, Vehiculo vehiculo, int DNI )
    {
        this.DNI = DNI;
        this.Fecha = Fecha;
        this.Vehiculo = vehiculo;
        this.Monto = this.Vehiculo.getPrecioNoPico();
        this.telepase = false;
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