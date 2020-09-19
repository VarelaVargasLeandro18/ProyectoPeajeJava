/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

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
    
    //private final int cantidadVehiculos = FabricaDirectorVehiculo.Vehiculos.values().length;
    //private JButton[] botonesVehiculos = new JButton [this.cantidadVehiculos];
    
    public Peaje ( String DNI )
    {
        
        super ( "Peaje " + DNI );
        this.configuraciones();
        //this.ConfigurarBotones();
        
    }
    
    private void configuraciones()
    {
        
        this.setLayout ( new FlowLayout ( FlowLayout.CENTER ) );
        this.setSize ( 350, 200 );
        this.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );
        this.setResizable ( false );
        this.setLocationRelativeTo ( null );
        
    }
    
//    private void ConfigurarBotones()
//    {
//        
//        for ( int i = 0; i < this.cantidadVehiculos; i++ )
//        {
//            
//            this.botonesVehiculos[i] = new JButton ( FabricaDirectorVehiculo.Vehiculos.values()[i].gettipoVehiculo() );
//            
//            //this.botonesVehiculos[i].addActionListener( (ActionEvent l) -> {} );
//            
//            this.add( this.botonesVehiculos[i] );
//            
//        }
//        
//    }
    
    public Peaje Mostrar()
    {
        
        this.setVisible(true);
        return this;
        
    }
    
}
