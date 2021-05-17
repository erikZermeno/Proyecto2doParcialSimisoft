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
public class Sucursales {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idSucursal;
    private String nombre;
    private int idContacto;
    private int activo = 1;

    public Sucursales() {
    }

    public Sucursales(int idSucursal, String nombre, int idContacto) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.idContacto = idContacto;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
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
        String query = "SELECT s.idSucursal AS ID, s.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Sucursales s "
                + "INNER JOIN Contactos c ON s.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE s.activo = 1";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderAsc() {
        String query = "SELECT s.idSucursal AS ID, s.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Sucursales s "
                + "INNER JOIN Contactos c ON s.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE s.activo = 1 "
                + "ORDER BY s.nombre";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearch(String busqueda){
        String query = "SELECT s.idSucursal AS ID, s.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Sucursales s "
                + "INNER JOIN Contactos c ON s.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE s.activo = 1 AND s.nombre LIKE '%" + busqueda + "%' "
                + "ORDER BY s.nombre";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM Sucursales WHERE idSucursal = " + idSucursal;
        DefaultTableModel res = dataAccess.Query(query);
        idSucursal = (int)res.getValueAt(0, 0);
        nombre = String.valueOf(res.getValueAt(0, 1));
        idContacto = (int)res.getValueAt(0, 2);
    }
    
    public boolean Add(){
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Sucursales(nombre, idContacto, activo) " + 
                "VALUES('" + nombre + "'," + idContacto + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM Sucursales WHERE idSucursal = " + idSucursal;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean DeleteLogic(){
        String query = "UPDATE Sucursales SET " +
                "activo = " + 0 + " " +
                "WHERE idSucursal = " + idSucursal;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE Sucursales SET " +
                "nombre = '" + nombre + "', " +
                "idContacto = " + idContacto + ", " +
                "activo = " + activo + " " +
                "WHERE idSucursal = " + idSucursal;
        return dataAccess.Execute(query) >= 1;
    }
}
