
package vehiculos;

import conexionBD.accesoADatos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bapo
 */
public class ConcreteBuilder
{
    
    private final String descripcion;
    private final Double Precio_HoraNoPico;
    private final Double Precio_HoraPico;
    
    protected ConcreteBuilder( int id ) throws SQLException
    {
        
        List<String> tarifas = accesoADatos.getInstance().consultarProcedure("CALL getTarifasVehiculo( " + id +" )");
        
        this.descripcion = accesoADatos.getInstance().consultarProcedure("CALL getTipoVehiculo( " + id + " )").get(0);
        this.Precio_HoraNoPico = Double.parseDouble(tarifas.get(0));
        this.Precio_HoraPico = Double.parseDouble(tarifas.get(1));
        
    }
    
    protected Vehiculo construir()
    {
        return new Vehiculo ( this.descripcion, this.Precio_HoraPico, this.Precio_HoraNoPico );
    }
    
}
