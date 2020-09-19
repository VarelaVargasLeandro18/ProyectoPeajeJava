
package ticket;

/**
 *
 * @author bapo
 */
public abstract class AbstractDecoratorTicket extends AbstractTicket
{
    
    protected final AbstractTicket ticket;
    
    public AbstractDecoratorTicket ( AbstractTicket ticket )
    {
        this.ticket = ticket;
    }
    
}
