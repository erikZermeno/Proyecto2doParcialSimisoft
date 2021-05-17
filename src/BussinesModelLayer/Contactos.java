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
public class Contactos {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idContacto;
    private int codigoPostal;
    private String comuna;
    private String calle;
    private String telefono;
    private int idEstado;
    private int idMunicipio;
    private int idLocalidad;
    private int activo = 1;

    public Contactos() {
    }

    public Contactos(int idContacto, int codigoPostal, String comuna, String calle, String telefono, int idEstado, int idMunicipio, int idLocalidad) {
        this.idContacto = idContacto;
        this.codigoPostal = codigoPostal;
        this.comuna = comuna;
        this.calle = calle;
        this.telefono = telefono;
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
        this.idLocalidad = idLocalidad;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
    
    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT c.idContacto AS ID, c.codigoPostal AS [Codigo Postal], c.comuna AS Comuna, c.calle AS Calle, c.telefono AS Telefono, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Contactos c "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad ";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderAsc(){
        String query = "SELECT c.idContacto AS ID, c.codigoPostal AS [Codigo Postal], c.comuna AS Comuna, c.calle AS Calle, c.telefono AS Telefono, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Contactos c "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "ORDER BY c.calle";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearch(String busqueda){
        String query = "SELECT c.idContacto AS ID, c.codigoPostal AS [Codigo Postal], c.comuna AS Comuna, c.calle AS Calle, c.telefono AS Telefono, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado "
                + "FROM Contactos c "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE c.calle LIKE '%" + busqueda + "%' "
                + "ORDER BY c.calle";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM Contactos WHERE idContacto = " + idContacto;
        DefaultTableModel res = dataAccess.Query(query);
        idContacto = (int)res.getValueAt(0, 0);
        codigoPostal = (int)res.getValueAt(0, 1);
        comuna = String.valueOf(res.getValueAt(0, 2));
        calle = String.valueOf(res.getValueAt(0, 3));
        telefono = String.valueOf(res.getValueAt(0, 4));
        idEstado = (int)res.getValueAt(0, 5);
        idMunicipio = (int)res.getValueAt(0, 6);
        idLocalidad = (int)res.getValueAt(0, 7);
    }
    
    public boolean Add(){
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Contactos(codigoPostal, comuna, calle, telefono, idEstado, idMunicipio, idLocalidad, activo) " + 
                "VALUES(" + codigoPostal + ",'" + comuna + "','" + calle + "','" + telefono + "'," + idEstado + "," + idMunicipio + "," + idLocalidad + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM Contactos WHERE idContacto = " + idContacto;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean DeleteLogic(){
        String query = "UPDATE Contactos SET " +
                "activo = " + 0 + " " +
                "WHERE idContacto = " + idContacto;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE Contactos SET " +
                "codigoPostal = " + codigoPostal + ", " +
                "comuna = '" + comuna + "', " +
                "calle = '" + calle + "', " +
                "telefono = '" + telefono + "', " +
                "idEstado = " + idEstado + ", " +
                "idMunicipio = " + idMunicipio + ", " +
                "idLocalidad = " + idLocalidad + ", " +
                "activo = " + activo + " " +
                "WHERE idContacto = " + idContacto;
        return dataAccess.Execute(query) >= 1;
    }

}
