/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.SacarInformacion;
import Model.Modelo;
import VIew.MenuPrincipalf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class ControladorPrincipal implements ActionListener{

    private Modelo modelo;
    private MenuPrincipalf vista;
    private SacarInformacion Dao;
    private ArrayList<String[]> clientesoEventos = new ArrayList<>();//variable reutilizada para recuperar datos de la BD
    private String[] nombres = {"DNI", "ID_MER", "ID_PARQUE_", "ID_CAJ", "ID_EVENTO", "N__PULSERA", "NOMBRE", "APELLIDO", "ALERGIAS", "EDAD"};


    public ControladorPrincipal(Modelo modelo, MenuPrincipalf view, SacarInformacion dao) {
        this.modelo = modelo;
        this.Dao = dao;
        this.vista = view;
    }
    
    public void iniciarVista() {
        vista.setTitle("Principal");
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.setResizable(false);
        this.vista.getGetCliente().addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == vista.getGetCliente()) {//cuando se seleciona el boton de informacion de los clientes, se llama al metodo del dao para recuperar los clientes
            clientesoEventos=Dao.clientes();//se meten en una variable
            vista.modelo.setColumnIdentifiers(nombres);
            meterenTabla();//y se ponen en la tabla
        }
    }
    
    private void meterenTabla() {
        while (vista.modelo.getRowCount() > 0) {
            vista.modelo.removeRow(0);
        }
        for (String[] jugador : clientesoEventos) {
            vista.modelo.addRow(jugador);
        }
    }
}
