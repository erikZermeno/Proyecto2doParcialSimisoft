/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesModelLayer;

import DataAccessLayer.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zerme
 */
public class Clientes {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idCliente;
    private String nombre;
    private int idContacto;
    private int activo = 1;

    public Clientes() {
    }

    public Clientes(int idCliente, String nombre, int idContacto) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.idContacto = idContacto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public DefaultTableModel GetAllModel() {
        String query = "SELECT cl.idCliente AS ID, cl.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Clientes cl "
                + "INNER JOIN Contactos c ON cl.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE cl.activo = 1";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderAsc() {
        String query = "SELECT cl.idCliente AS ID, cl.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Clientes cl "
                + "INNER JOIN Contactos c ON cl.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE cl.activo = 1 "
                + "ORDER BY cl.nombre";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearch(String busqueda) {
        String query = "SELECT cl.idCliente AS ID, cl.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Clientes cl "
                + "INNER JOIN Contactos c ON cl.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE cl.activo = 1 AND cl.nombre LIKE '%" + busqueda + "%' "
                + "ORDER BY cl.nombre";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM Clientes WHERE idCliente = " + idCliente;
        DefaultTableModel res = dataAccess.Query(query);
        idCliente = (int)res.getValueAt(0, 0);
        nombre = String.valueOf(res.getValueAt(0, 1));
        idContacto = (int)res.getValueAt(0, 2);
    }
    
//    public DefaultTableModel GetByIdModel(){
//        String query = "SELECT cl.idCliente AS ID, cl.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
//                + "FROM Clientes cl "
//                + "INNER JOIN Contactos c ON cl.idContacto = c.idContacto "
//                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
//                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
//                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
//                + "WHERE idCliente = " + idCliente;
//        return dataAccess.Query(query);
//    }
    
    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Clientes(nombre, idContacto, activo) "
                + "VALUES('" + nombre + "'," + idContacto + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Clientes WHERE idCliente = " + idCliente;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean DeleteLogic() {
        String query = "UPDATE Clientes SET "
                + "activo = " + 0 + " "
                + "WHERE idCliente = " + idCliente;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Clientes SET "
                + "nombre = '" + nombre + "', "
                + "idContacto = " + idContacto + ", "
                + "activo = " + activo + " "
                + "WHERE idCliente = " + idCliente;
        return dataAccess.Execute(query) >= 1;
    }
}
