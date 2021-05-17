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
public class Usuarios {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idUsuario;
    private int idSucursal;
    private int idContacto;
    private String tipo;
    private String nombre;
    private String usuario;
    private String password;
    private int activo = 1;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, int idSucursal, int idContacto, String tipo, String nombre, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.idSucursal = idSucursal;
        this.idContacto = idContacto;
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT u.idUsuario AS ID, u.nombre AS Nombre, u.tipoUsuario AS Tipo, s.nombre AS Sucursal, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado, u.usuario AS Usuario, u.password AS Contraseña "
                + "FROM Usuarios u "
                + "INNER JOIN Sucursales s ON u.idSucursal = s.idSucursal "
                + "INNER JOIN Contactos c ON u.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE u.activo = 1 ";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderAsc(){
        String query = "SELECT u.idUsuario AS ID, u.nombre AS Nombre, u.tipoUsuario AS Tipo, s.nombre AS Sucursal, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado, u.usuario AS Usuario, u.password AS Contraseña "
                + "FROM Usuarios u "
                + "INNER JOIN Sucursales s ON u.idSucursal = s.idSucursal "
                + "INNER JOIN Contactos c ON u.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE u.activo = 1 "
                + "ORDER BY u.nombre";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearch(String busqueda){
        String query = "SELECT u.idUsuario AS ID, u.nombre AS Nombre, u.tipoUsuario AS Tipo, s.nombre AS Sucursal, l.localidad AS Localidad, m.municipio AS Municipio, e.estado AS Estado, u.usuario AS Usuario, u.password AS Contraseña "
                + "FROM Usuarios u "
                + "INNER JOIN Sucursales s ON u.idSucursal = s.idSucursal "
                + "INNER JOIN Contactos c ON u.idContacto = c.idContacto "
                + "INNER JOIN Estados e ON c.idEstado = e.idEstado "
                + "INNER JOIN Municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN Localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE u.activo = 1 AND u.nombre LIKE '%" + busqueda + "%' "
                + "ORDER BY u.nombre";
        return dataAccess.Query(query);
    }

    public void GetById(){
        String query = "SELECT * FROM Usuarios WHERE idUsuario = " + idUsuario;
        DefaultTableModel res = dataAccess.Query(query);
        idUsuario = (int)res.getValueAt(0, 0);
        idSucursal = (int)res.getValueAt(0, 1);
        tipo = String.valueOf(res.getValueAt(0, 2));
        nombre = String.valueOf(res.getValueAt(0, 3));
        idContacto = (int)res.getValueAt(0, 4);
        usuario = String.valueOf(res.getValueAt(0, 5));
        password = String.valueOf(res.getValueAt(0, 6));
    }
    
    public boolean Add(){
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Usuarios(idSucursal, tipoUsuario, nombre, idContacto, usuario, password, activo) " + 
                "VALUES(" + idSucursal + ",'" + tipo + "','" + nombre + "'," + idContacto + ",'" + usuario + "','" + password + "'," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM Usuarios WHERE idUsuario = " + idUsuario;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean DeleteLogic(){
        String query = "UPDATE Usuarios SET " +
                "activo = " + 0 + " " +
                "WHERE idUsuario = " + idUsuario;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE Usuarios SET " +
                "idSucursal = " + idSucursal + ", " +
                "tipoUsuario = '" + tipo + "', " +
                "nombre = '" + nombre + "', " +
                "idContacto = " + idContacto + ", " +
                "usuario = '" + usuario + "', " +
                "password = '" + password + "', " +
                "activo = " + activo + " " +
                "WHERE idUsuario = " + idUsuario;
        return dataAccess.Execute(query) >= 1;
    }

}
