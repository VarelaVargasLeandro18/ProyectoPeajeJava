
package ejerciciotelepeaje;

import java.time.LocalDateTime;
import ticket.AbstractTicket;
import ticket.DecoratorTicketHorario;
import ticket.Ticket;
import vehiculos.FabricaDirectorVehiculo;

/**
 *
 * @author bapo
 */
public class EjercicioTelepeaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        AbstractTicket ticket = new DecoratorTicketHorario ( new Ticket ( LocalDateTime.now(), FabricaDirectorVehiculo.getInstance().getVehiculo(FabricaDirectorVehiculo.Vehiculos.MOTO) ) );
        
        System.out.println ( ticket.getMonto() );
        
    }
    
}
