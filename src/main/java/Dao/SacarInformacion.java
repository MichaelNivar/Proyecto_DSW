/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class SacarInformacion {

    private Connection con;
    private Modelo modelo = new Modelo();
    private String DNI;
    private String id_mer;
    private String id_parque;
    private String id_caja;
    private String id_evento;
    private String num_pulsera;
    private String nombre;
    private String apellidos;
    private String alergias;
    private String edad;

    public ArrayList<String[]> clientes() {
        ArrayList<String[]> Clientes = new ArrayList<>();

        con = modelo.getConnection();

        String sql = "select * from cliente";

        try {
            Statement st = con.createStatement();

            ResultSet res = st.executeQuery(sql);

            while (res.next()) {
                String[] Cliente = new String[10];
                DNI = res.getString("DNI");
                id_mer = res.getString("ID_MER");
                id_parque = res.getString("ID_PARQUE_");
                id_caja = res.getString("ID_CAJ");
                id_evento = res.getString("ID_EVENTO");
                num_pulsera = res.getString("N__PULSERA");
                nombre = res.getString("NOMBRE");
                apellidos = res.getString("APELLIDO");
                alergias = res.getString("ALERGIAS");
                edad = res.getString("EDAD");
                Cliente[0] = DNI;
                Cliente[1] = id_mer;
                Cliente[2] = id_parque;
                Cliente[3] = id_caja;
                Cliente[4] = id_evento;
                Cliente[5] = num_pulsera;
                Cliente[6] = nombre;
                Cliente[7] = apellidos;
                Cliente[8] = alergias;
                Cliente[9] = edad;
                Clientes.add(Cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SacarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Clientes;
    }

}
