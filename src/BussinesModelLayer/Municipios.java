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
public class Municipios {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idMunicipio;
    private int idEstado;
    private String municipio;

    public Municipios() {
    }

    public Municipios(int idMunicipio, int idEstado, String municipio) {
        this.idMunicipio = idMunicipio;
        this.idEstado = idEstado;
        this.municipio = municipio;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    public DefaultTableModel GetAllModel() {
        String query = "SELECT m.idMunicipio AS ID, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Municipios m "
                + "INNER JOIN Estados e ON m.idEstado = e.idEstado";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelIDEstado() {
        String query = "SELECT m.idMunicipio AS ID, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Municipios m "
                + "INNER JOIN Estados e ON m.idEstado = e.idEstado "
                + "WHERE m.idEstado = " + idEstado;
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderAsc() {
        String query = "SELECT m.idMunicipio AS ID, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Municipios m "
                + "INNER JOIN Estados e ON m.idEstado = e.idEstado "
                + "ORDER BY m.municipio";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearch(String busqueda){
        String query = "SELECT m.idMunicipio AS ID, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Municipios m "
                + "INNER JOIN Estados e ON m.idEstado = e.idEstado "
                + "WHERE m.municipio LIKE '%" + busqueda + "%' "
                + "ORDER BY m.municipio";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM Municipios WHERE idMunicipio = " + idMunicipio;
        DefaultTableModel res = dataAccess.Query(query);
        idMunicipio = (int)res.getValueAt(0, 0);
        idEstado = (int)res.getValueAt(0, 1);
        municipio = String.valueOf(res.getValueAt(0, 2));
    }
    
    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Municipios(idEstado, municipio) "
                + "VALUES(" + idEstado + ",'" + municipio + "');";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Municipios WHERE idMunicipio = " + idMunicipio;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Municipios SET "
                + "idEstado = " + idEstado + ", "
                + "municipio = '" + municipio + "' "
                + "WHERE idMunicipio = " + idMunicipio;
        return dataAccess.Execute(query) >= 1;
    }
}
