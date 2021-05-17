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
public class Productos {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idProducto;
    private int idCategoria;
    private String nombre;
    private double precio;
    private String caducidad;
    private double descuento;
    private int activo = 1;

    public Productos(){
    }

    public Productos(int idProducto, int idCategoria, String nombre, double precio, String caducidad, double descuento) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.precio = precio;
        this.caducidad = caducidad;
        this.descuento = descuento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    public int isActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT p.idProducto AS ID, p.nombre AS Producto, c.nombre AS Categoria, p.precio AS Precio, p.caducidad AS Caducidad, p.descuento AS Descuento  "
                + "FROM Productos p "
                + "INNER JOIN Categorias c ON p.idCategoria = c.idCategoria "
                + "WHERE p.activo = 1";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderAsc(){
        String query = "SELECT p.idProducto AS ID, p.nombre AS Producto, c.nombre AS Categoria, p.precio AS Precio, p.caducidad AS Caducidad, p.descuento AS Descuento  "
                + "FROM Productos p "
                + "INNER JOIN Categorias c ON p.idCategoria = c.idCategoria "
                + "WHERE p.activo = 1 "
                + "ORDER BY p.nombre";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearch(String busqueda){
        String query = "SELECT p.idProducto AS ID, p.nombre AS Producto, c.nombre AS Categoria, p.precio AS Precio, p.caducidad AS Caducidad, p.descuento AS Descuento  "
                + "FROM Productos p "
                + "INNER JOIN Categorias c ON p.idCategoria = c.idCategoria "
                + "WHERE p.activo = 1 AND p.nombre LIKE '%" + busqueda + "%' "
                + "ORDER BY p.nombre";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM productos WHERE idProducto = " + idProducto;
        DefaultTableModel res = dataAccess.Query(query);
        idProducto = (int) res.getValueAt(0, 0);
        nombre = String.valueOf(res.getValueAt(0, 1));
        idCategoria = (int) res.getValueAt(0, 2);
        precio = Double.parseDouble(String.valueOf(res.getValueAt(0, 3)));
        caducidad = String.valueOf(res.getValueAt(0, 4));
        descuento = Double.parseDouble(String.valueOf(res.getValueAt(0, 5)));
    }

    public boolean Add(){
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO productos(nombre, idCategoria, precio, caducidad, descuento, activo) " + 
                "VALUES('" + nombre + "'," + idCategoria + "," + precio + ",'" + caducidad + "'," + descuento + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM productos WHERE idProducto = " + idProducto;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean DeleteLogic(){
        String query = "UPDATE productos SET " +
                "activo = " + 0 + " " +
                "WHERE idProducto = " + idProducto;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE productos SET " +
                "nombre = '" + nombre + "', " +
                "idCategoria = " + idCategoria + ", " +
                "precio = " + precio + ", " +
                "caducidad = '" + caducidad + "', " +
                "descuento = " + descuento + ", " +
                "activo = " + activo + " " +
                "WHERE idProducto = " + idProducto;
        return dataAccess.Execute(query) >= 1;
    }

}
