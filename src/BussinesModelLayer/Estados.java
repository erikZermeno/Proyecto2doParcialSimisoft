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
public class Estados {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idEstado;
    private String estado;

    public Estados() {
    }

    public Estados(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public DefaultTableModel GetAllModel() {
        String query = "SELECT idEstado AS ID, estado AS Estado FROM Estados";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderAsc() {
        String query = "SELECT idEstado AS ID, estado AS Estado FROM Estados ORDER BY estado";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearch(String busqueda) {
        String query = "SELECT idEstado AS ID, estado AS Estado FROM Estados WHERE estado LIKE '%" + busqueda + "%' ORDER BY estado";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM Estados WHERE idEstado = " + idEstado;
        DefaultTableModel res = dataAccess.Query(query);
        idEstado = (int)res.getValueAt(0, 0);
        estado = String.valueOf(res.getValueAt(0, 1));
    }
    
    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Estados(estado) "
                + "VALUES('" + estado + "');";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Estados WHERE idEstado = " + idEstado;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Estados SET "
                + "estado = '" + estado + "' "
                + "WHERE idEstado = " + idEstado;
        return dataAccess.Execute(query) >= 1;
    }
}
