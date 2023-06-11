/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import Controller.ControladorPrincipal;
import Dao.SacarInformacion;
import Model.Modelo;
import VIew.MenuPrincipalf;

/**
 *
 * @author usuario
 */
public class main {
    public static void main(String[] args) {
        SacarInformacion dao = new SacarInformacion();
        Modelo modelo = new Modelo();
        MenuPrincipalf view = new MenuPrincipalf();
        ControladorPrincipal controlador = new ControladorPrincipal(modelo, view, dao);
        controlador.iniciarVista();
    }
}
