
package ticket;

import conexionBD.accesoADatos;
import java.time.LocalDateTime;
import vehiculos.Vehiculo;
import java.sql.SQLException;

/**
 *
 * @author bapo
 */
public class DecoratorTicketHorario extends AbstractDecoratorTicket
{

    private String bandaHoraria;
    FabricaDirectorBandaHoraria bandasHorarias = FabricaDirectorBandaHoraria.getInstance();
    
    public DecoratorTicketHorario(AbstractTicket ticket)
    {
        this.ticket = ticket;
        this.DNI = ticket.DNI;
        this.Fecha = this.ticket.Fecha;
        this.Vehiculo = this.ticket.Vehiculo;
        this.telepase = this.ticket.telepase;
        this.Monto = this.averiguarMonto();
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
    
    private final double averiguarMonto()
    {
        
        double monto;
        
        this.bandaHoraria = FabricaDirectorBandaHoraria.getInstance().getBandaHorariaporHora( LocalDateTime.now() ).getTipo();
        monto = bandaHoraria.equals("Pico") ? this.Vehiculo.getPrecioPico() : this.Vehiculo.getPrecioNoPico();
        
        return monto;
        
    }
    
    @Override
    protected void setMonto( double Monto )
    {
        this.Monto = Monto;
        this.ticket.setMonto(Monto);
    }
    
    @Override
    protected void setTelePase( boolean isTelepase )
    {
        this.ticket.telepase = false;
        this.telepase = false;
    }

    @Override
    protected boolean getTelePase() 
    {
        return this.telepase;
    }
    
    @Override
    public boolean IngresarTicket()
    {
        
        try
        {
            //CALL crearTicket ( 0, '2017-03-13T14:39:01.123', 'Moto', 'Pico');
            accesoADatos.getInstance().actualizarProcedure( String.format("CALL crearTicket ( %d, \'%s\', \'%s\', \'%s\', %s );", this.DNI, this.Fecha, this.Vehiculo.getDescripcion(), this.bandaHoraria, this.Monto ) );
            System.out.println ( "\tIngresado" );
            return true;
        }
        catch ( SQLException ex )
        {
            
            System.out.println ( "ERROR de Ingreso." );
            return false;
            
        }
        
    }
    
}
