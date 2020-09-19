
package vehiculos;

/**
 *
 * @author bapo
 */
public class Vehiculo
{
    
    private final double precioPico;
    private final double precioNoPico;
    private final String descripcion;
    
    protected Vehiculo ( String descripcion, double precioPico, double precioNoPico )
    {
        this.descripcion = descripcion;
        this.precioPico = precioPico;
        this.precioNoPico = precioNoPico;
    }
    
    public double getPrecioPico()
    {
        return this.precioPico;
    }
    
    public double getPrecioNoPico()
    {
        return this.precioNoPico;
    }
    
    public String getDescripcion()
    {
        return this.descripcion;
    }

    @Override
    public String toString() 
    {
        return "Vehiculo{" + "precioPico=" + precioPico + ", precioNoPico=" + precioNoPico + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
