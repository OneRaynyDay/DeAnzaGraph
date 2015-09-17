import java.awt.FlowLayout; 
import java.awt.Graphics;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;

public class Table extends JPanel{
   protected static String[] columnNames = {"X" , "Y"};
   protected DefaultTableModel model; 
   protected JTable table; 
   protected double[][] vals;
   public Table(double[][] vals){
      this.vals = vals;
      //g.drawString("ESTssssssssssssssss", 110,110);
      //super.paintComponent(g);
      model = new DefaultTableModel(columnNames, vals.length); 
      table = new JTable(model){
         @Override 
         public boolean isCellEditable(int arg0, int arg1) { return false; }
      };
      JScrollPane pane = new JScrollPane(table);
      for(int i = 0; i < vals.length; i++){
         table.setValueAt((int)vals[i][0], i, 0);
         table.setValueAt(vals[i][1], i, 1);
      }
      add(pane);
   }
}
