
package ticket;

import java.time.LocalDateTime;
import vehiculos.Vehiculo;

/**
 *
 * @author bapo
 */
public class DecoratorTicketHorario extends AbstractDecoratorTicket
{

    FabricaDirectorBandaHoraria bandasHorarias = FabricaDirectorBandaHoraria.getInstance();
    
    public DecoratorTicketHorario(AbstractTicket ticket)
    {
        super(ticket);
    }

    @Override
    public double getMonto()
    {
        
        if ( bandasHorarias.getBandaHorariaporHora ( super.ticket.getFecha() ).getTipo().equals("Pico") )
        {
            this.ticket.setMonto( ticket.getVehiculo().getPrecioPico()  );
        }
        
        return this.ticket.getMonto();
        
    }

    @Override
    public LocalDateTime getFecha() 
    {
        return this.ticket.getFecha();
    }

    @Override
    public Vehiculo getVehiculo() 
    {
        return this.ticket.getVehiculo();
    }
    
    @Override
    protected void setMonto(double Monto)
    {
        this.ticket.setMonto(Monto);
    }
    
    @Override
    protected void setTelePase(boolean isTelepase)
    {
        this.ticket.setTelePase(isTelepase);
    }

    @Override
    protected boolean getTelePase() 
    {
        return this.ticket.getTelePase();
    }
    
}
