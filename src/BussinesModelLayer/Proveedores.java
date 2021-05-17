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
public class Proveedores {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idProveedor;
    private String nombre;
    private int idContacto;
    private int activo = 1;

    public Proveedores() {
    }

    public Proveedores(int idProveedor, String nombre, int idContacto) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.idContacto = idContacto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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
        String query = "SELECT p.idProveedor AS ID, p.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Proveedores p "
                + "INNER JOIN Contactos c ON p.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE p.activo = 1";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderAsc() {
        String query = "SELECT p.idProveedor AS ID, p.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Proveedores p "
                + "INNER JOIN Contactos c ON p.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE p.activo = 1 "
                + "ORDER BY p.nombre";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearch(String busqueda){
        String query = "SELECT p.idProveedor AS ID, p.nombre AS Nombre, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Proveedores p "
                + "INNER JOIN Contactos c ON p.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE p.activo = 1 AND p.nombre LIKE '%" + busqueda + "%' "
                + "ORDER BY p.nombre";
        return dataAccess.Query(query);
    }

    public void GetById(){
        String query = "SELECT * FROM Proveedores WHERE idProveedor = " + idProveedor;
        DefaultTableModel res = dataAccess.Query(query);
        idProveedor = (int)res.getValueAt(0, 0);
        nombre = String.valueOf(res.getValueAt(0, 1));
        idContacto = (int)res.getValueAt(0, 2);
    }
    
    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Proveedores(nombre, idContacto, activo) "
                + "VALUES('" + nombre + "'," + idContacto + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Proveedores WHERE idProveedor = " + idProveedor;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean DeleteLogic() {
        String query = "UPDATE Proveedores SET "
                + "activo = " + 0 + " "
                + "WHERE idProveedor = " + idProveedor;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Proveedores SET "
                + "nombre = '" + nombre + "', "
                + "idContacto = " + idContacto + ", "
                + "activo = " + activo + " "
                + "WHERE idProveedor = " + idProveedor;
        return dataAccess.Execute(query) >= 1;
    }
    
}
