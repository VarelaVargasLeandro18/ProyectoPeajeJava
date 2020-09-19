/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import cajero.Cajero;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import vehiculos.FabricaDirectorVehiculo;

/**
 *
 * @author bapo
 */
public class Peaje extends JFrame
{
    
    private final int cantidadVehiculos = FabricaDirectorVehiculo.Vehiculos.values().length;
    private final JButton[] botonesVehiculos = new JButton [this.cantidadVehiculos];
    private final Cajero cajero;
    
    public Peaje ( Cajero cajero )
    {
        
        super ( "Peaje " + cajero.getDNI() );
        this.cajero = cajero;
        this.configuraciones();
        this.ConfigurarBotones();
        
    }
    
    private void configuraciones()
    {
        
        this.setLayout ( new FlowLayout ( FlowLayout.CENTER ) );
        this.setSize ( 350, 200 );
        this.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );
        this.setResizable ( false );
        this.setLocationRelativeTo ( null );
        
    }
    
    private void ConfigurarBotones()
    {
        
        for ( int i = 0; i < this.cantidadVehiculos; i++ )
        {
            
            String nombreBoton = FabricaDirectorVehiculo.getInstance().getVehiculo(FabricaDirectorVehiculo.Vehiculos.values()[i]).getDescripcion();
            
            this.botonesVehiculos[i] = new JButton ( nombreBoton );
            
            //this.botonesVehiculos[i].addActionListener( (ActionEvent l) -> {} );
            
            this.add( this.botonesVehiculos[i] );
            
        }
        
    }
    
    public Peaje Mostrar()
    {
        
        this.setVisible(true);
        return this;
        
    }
    
}
