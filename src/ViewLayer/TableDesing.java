/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLayer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author zerme
 */
public class TableDesing {

    public TableDesing() {
    }
    
    public void desingOfTable(JTable tableDesing){
        
        JTableHeader th;
        th = tableDesing.getTableHeader();
        Font fuente = new Font("Yu Gothic", Font.BOLD, 12);
        th.setFont(fuente);
        th.setReorderingAllowed(false);
        
        tableDesing.setRowHeight(30);
        tableDesing.setBackground(new Color(255, 255, 255));
        tableDesing.getTableHeader().setDefaultRenderer(new HeaderColor());
        tableDesing.setFocusable(false);
        tableDesing.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableDesing.setRowHeight(25);
        tableDesing.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tableDesing.setShowVerticalLines(false);



    }
    
}
