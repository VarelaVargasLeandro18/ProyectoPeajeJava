
package ventanas;

import cajero.Cajero;
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
    
    private JTextField jtbUsuario;
    private JPasswordField jpfContrasenia;
    private JButton jbIngresar;
    
    private boolean ingresoCorrecto = false;
    
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
        this.jpfContrasenia = new JPasswordField (20);
        this.jbIngresar = new JButton ( "Ingresar" );
        
        this.jbIngresar.addActionListener ( (ActionEvent l) -> {
            
            if ( Cajero.Validar( Login.this.jtbUsuario.getText(),  Login.this.jpfContrasenia.getPassword() ) )
            {
                this.ingresoCorrecto = true;
                new Peaje ( Cajero.getInstance() ).Mostrar();
                this.dispose();
            }
            
        });
        
        this.add ( new JLabel ( "Usuario: " ) );
        this.add(this.jtbUsuario);
        this.add ( new JLabel ( "Contraseña: " ) );
        this.add(this.jpfContrasenia);
        this.add(this.jbIngresar);
        
    }
 
    public Login Mostrar()
    {
        
        this.setVisible (true);
        return this;
        
    }
    
    public boolean getIngresoCorrecto()
    {
        return this.ingresoCorrecto;
    }
    
}
