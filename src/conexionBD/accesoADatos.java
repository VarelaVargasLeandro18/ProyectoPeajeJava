
package conexionBD;

import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.TimeZone;

/**
 *
 * @author bapo
 */
public class accesoADatos implements IConsultaDatos, IActualizaDatos
{
    
    private static accesoADatos accesoADatosSingleton = null;
    private Connection conn;
    
    public static accesoADatos getInstance()
    {
        
        if ( accesoADatosSingleton == null )
        {
            
            try
            {
                accesoADatosSingleton = new accesoADatos ();
            }
            catch ( ClassNotFoundException | SQLException ex )
            {
                System.out.println ( ex.getMessage() );
                return null;
            }
            
        }
        
        return accesoADatosSingleton;
        
    }
    
    private accesoADatos () throws SQLException, ClassNotFoundException
    {
        this.conectar();
    }
    
    private void conectar() throws SQLException, ClassNotFoundException
    {
        
        ResourceBundle propiedades = ResourceBundle.getBundle("BDPropiedades");
        
        Class.forName( propiedades.getString("Driver") );
        
        this.conn = DriverManager.getConnection( propiedades.getString("BD_URL") + 
                propiedades.getString("BD_Nombre") + "?serverTimezone=" + TimeZone.getDefault().getID(),
                propiedades.getString("User"), 
                propiedades.getString("Password")
                                                                            );
        
    }

    @Override
    public List<String> consultarProcedure(String sCall) throws SQLException
    {
        
        CallableStatement cs = this.conn.prepareCall(sCall);
        
        return this.obtenerDatosBD ( cs.executeQuery() );
        
    }

    @Override
    public boolean actualizarProcedure(String sCall) throws SQLException
    {
        
        CallableStatement cs;
        
        cs = this.conn.prepareCall(sCall);

        return cs.executeUpdate() == 1;
        
    }

    @Override
    public List<String> consultarStatement(String sQuery) throws SQLException
    {
        
        PreparedStatement ps = this.conn.prepareStatement(sQuery);
        
        return this.obtenerDatosBD(ps.executeQuery());
        
    }
    
    @Override
    public boolean actualizarStatement(String sQuery) throws SQLException
    {
        
        PreparedStatement ps;
            
        ps = this.conn.prepareStatement(sQuery);

        return ps.executeUpdate() == 1;
        
    }
    
    private List<String> obtenerDatosBD ( ResultSet rs ) throws SQLException
    {
        
        List<String> ret = new ArrayList();
        String sDato = "";
        
        while ( rs.next() )
        {
            
            for ( int i = 1; i <= rs.getMetaData().getColumnCount(); i++ )
            {
                
                switch ( rs.getMetaData().getColumnType(i) )
                {
                    
                    case Types.SMALLINT:
                    case Types.BIGINT:
                    case Types.INTEGER:
                        sDato = String.valueOf ( rs.getInt(i) );
                        break;

                    case Types.VARCHAR:
                        sDato = rs.getString(i);
                        break;

                    case Types.TIME:
                        sDato = rs.getTime(i).toString();
                        break;

                    case Types.TIMESTAMP:
                        sDato = rs.getTimestamp(i).toLocalDateTime().toString();
                        break;

                    case Types.DATE:
                        sDato = rs.getDate ( i ).toLocalDate().toString();
                        break;

                    case Types.DOUBLE:
                        sDato = String.valueOf ( rs.getDouble ( i ) );
                        break;

                }
                
                ret.add (sDato);
                
            }
            
        }
        
        return ret;
        
    }
    
}
