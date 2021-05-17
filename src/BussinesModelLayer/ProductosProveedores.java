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
public class ProductosProveedores {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idProductoProveedor;
    private int idProveedor;
    private int idProducto;

    public ProductosProveedores() {
    }

    public ProductosProveedores(int idProductoProveedor, int idProveedor, int idProducto) {
        this.idProductoProveedor = idProductoProveedor;
        this.idProveedor = idProveedor;
        this.idProducto = idProducto;
    }

    public int getIdProductoproveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoproveedor(int idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT pp.idProductoProveedor AS ID, prov.nombre AS Proveedor, prod.nombre AS Producto "
                + "FROM ProductosProveedores pp "
                + "INNER JOIN Productos prod ON pp.idProducto = prod.idProducto "
                + "INNER JOIN Proveedores prov ON pp.idProveedor = prov.idProveedor";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderProdu() {
        String query = "SELECT pp.idProductoProveedor AS ID, prov.nombre AS Proveedor, prod.nombre AS Producto "
                + "FROM ProductosProveedores pp "
                + "INNER JOIN Productos prod ON pp.idProducto = prod.idProducto "
                + "INNER JOIN Proveedores prov ON pp.idProveedor = prov.idProveedor "
                + "ORDER BY prod.nombre";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearchProdu(String busqueda) {
        String query = "SELECT pp.idProductoProveedor AS ID, prov.nombre AS Proveedor, prod.nombre AS Producto "
                + "FROM ProductosProveedores pp "
                + "INNER JOIN Productos prod ON pp.idProducto = prod.idProducto "
                + "INNER JOIN Proveedores prov ON pp.idProveedor = prov.idProveedor "
                + "WHERE prod.nombre LIKE '%" + busqueda + "%' "
                + "ORDER BY prod.nombre";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelOrderProve() {
        String query = "SELECT pp.idProductoProveedor AS ID, prov.nombre AS Proveedor, prod.nombre AS Producto "
                + "FROM ProductosProveedores pp "
                + "INNER JOIN Productos prod ON pp.idProducto = prod.idProducto "
                + "INNER JOIN Proveedores prov ON pp.idProveedor = prov.idProveedor "
                + "ORDER BY prov.nombre";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel GetAllModelSearchProve(String busqueda) {
        String query = "SELECT pp.idProductoProveedor AS ID, prov.nombre AS Proveedor, prod.nombre AS Producto "
                + "FROM ProductosProveedores pp "
                + "INNER JOIN Productos prod ON pp.idProducto = prod.idProducto "
                + "INNER JOIN Proveedores prov ON pp.idProveedor = prov.idProveedor "
                + "WHERE prov.nombre LIKE '%" + busqueda + "%' "
                + "ORDER BY prov.nombre";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM ProductosProveedores WHERE idProductoProveedor = " + idProductoProveedor;
        DefaultTableModel res = dataAccess.Query(query);
        idProductoProveedor = (int)res.getValueAt(0, 0);
        idProveedor = (int)res.getValueAt(0, 1);
        idProducto = (int)res.getValueAt(0, 2);
    }
    
    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO ProductosProveedores(idProveedor, idProducto) "
                + "VALUES(" + idProveedor + "," + idProducto + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM ProductosProveedores WHERE idProductoProveedor = " + idProductoProveedor;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE ProductosProveedores SET "
                + "idProveedor = " + idProveedor + ", "
                + "idProducto = " + idProducto + " "
                + "WHERE idProductoProveedor = " + idProductoProveedor;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Check(){
        String query = "SELECT * FROM ProductosProveedores WHERE idProducto = " + idProducto + " AND idProveedor = " + idProveedor;
        return dataAccess.Execute(query) >= 1;
    }
}
