
package ventanas;

import conexionBD.accesoADatos;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author bapo
 */
public final class Login extends JFrame
{
    
    private final accesoADatos chequeoUsuario = accesoADatos.getInstance();
    private JTextField jtbUsuario;
    private JPasswordField jtbContrasenia;
    private boolean logCorrecto = false;
    
    private JButton jbIngresar;
    
    public Login()
    {
        
        super ( "Login TelePeaje" );
        
        this.configuracionVentana();
        this.agregarComponentes();
        
    }
    
    private void configuracionVentana ()
    {
        
        this.setLayout ( new FlowLayout ( FlowLayout.CENTER ) );
        this.setSize ( 350, 150 );
        this.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );
        this.setResizable ( false );
        this.setLocationRelativeTo ( null );
    
    }
    
    private void agregarComponentes ()
    {
        
        this.jtbUsuario = new JTextField (20);
        this.jtbContrasenia = new JPasswordField (20);
        this.jbIngresar = new JButton ( "Ingresar" );
        
        this.jbIngresar.addActionListener ( (ActionEvent l) -> {
            
            String checkUsuario = Login.this.jtbUsuario.getText();
            String checkContrasenia = new String ( Login.this.jtbContrasenia.getPassword() ); // No debería usarse así, pero bueno xD
            System.out.println("------------------------------------------------");
            System.out.println ( "Usuario: " + checkUsuario + "\tContraseña: " + checkContrasenia );
            System.out.println("------------------------------------------------");
            
            try
            {
                
                List<String> existeUsuario;
                existeUsuario = Login.this.chequeoUsuario.consultarProcedure ( "CALL getCajerosDNI ( \"" + checkUsuario + "\", \"" +  checkContrasenia + "\" );" );
                Login.this.logCorrecto = existeUsuario.size() > 0;
                
                if ( Login.this.logCorrecto )
                {
                    new Peaje( existeUsuario.get(0) ).Mostrar();
                    Login.this.dispose();//Tal vez sacarlo.
                }
                
            }
            catch ( SQLException ex )
            {
                System.out.println ( ex.getMessage() );
            }
            
        });
        
        this.add ( new JLabel ( "Usuario: " ) );
        this.add(this.jtbUsuario);
        this.add ( new JLabel ( "Contraseña: " ) );
        this.add(this.jtbContrasenia);
        this.add(this.jbIngresar);
        
    }
 
    public Login Mostrar()
    {
        
        this.setVisible (true);
        return this;
        
    }
    
    public boolean getIngresoCorrecto()
    {
        
        return this.logCorrecto;
        
    }
    
}
