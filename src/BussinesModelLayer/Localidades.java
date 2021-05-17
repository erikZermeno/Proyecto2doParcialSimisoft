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
public class Localidades {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idLocalidad;
    private int idMunicipio;
    private String localidad;

    public Localidades() {
    }

    public Localidades(int idLocalidad, int idMunicipio, String localidad) {
        this.idLocalidad = idLocalidad;
        this.idMunicipio = idMunicipio;
        this.localidad = localidad;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT l.idLocalidad AS ID, l.localidad AS Localidad, m.municipio AS Municipio "
                + "FROM Localidades l "
                + "INNER JOIN Municipios m ON l.idMunicipio = m.idMunicipio";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelIDMunicipio() {
        String query = "SELECT l.idLocalidad AS ID, l.localidad AS Localidad, m.municipio AS Municipio "
                + "FROM Localidades l "
                + "INNER JOIN Municipios m ON l.idMunicipio = m.idMunicipio "
                + "WHERE l.idMunicipio = " + idMunicipio;
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderAsc() {
        String query = "SELECT l.idLocalidad AS ID, l.localidad AS Localidad, m.municipio AS Municipio "
                + "FROM Localidades l "
                + "INNER JOIN Municipios m ON l.idMunicipio = m.idMunicipio "
                + "ORDER BY l.localidad";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearch(String busqueda) {
        String query = "SELECT l.idLocalidad AS ID, l.localidad AS Localidad, m.municipio AS Municipio "
                + "FROM Localidades l "
                + "INNER JOIN Municipios m ON l.idMunicipio = m.idMunicipio "
                + "WHERE l.localidad LIKE '%" + busqueda + "%' "
                + "ORDER BY l.localidad";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM Localidades WHERE idLocalidad = " + idLocalidad;
        DefaultTableModel res = dataAccess.Query(query);
        idLocalidad = (int)res.getValueAt(0, 0);
        idMunicipio = (int)res.getValueAt(0, 1);
        localidad = String.valueOf(res.getValueAt(0, 2));
    }
    
    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Localidades(idMunicipio, localidad) "
                + "VALUES(" + idMunicipio + ",'" + localidad + "');";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Localidades WHERE idLocalidad = " + idLocalidad;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Localidades SET "
                + "idMunicipio = " + idMunicipio + ", "
                + "localidad = '" + localidad + "' "
                + "WHERE idLocalidad = " + idLocalidad;
        return dataAccess.Execute(query) >= 1;
    }
}
