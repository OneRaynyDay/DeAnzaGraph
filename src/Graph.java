
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;


public class Graph extends JPanel
{
   protected static Color[] colors = 
      {
         Color.red,
         Color.orange,
         Color.yellow,
         Color.green,
         Color.cyan,
         Color.blue,
         Color.magenta
      };
   protected double[][] vals;
   protected double maxY, minY;
   protected int xSize;
   public Graph(double[][] vals, double maxY, double minY, int xSize)
   {
      this.vals = vals;
      this.maxY = maxY;
      this.xSize = xSize;
      this.minY = minY;
      
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Rectangle area = getBounds();
      area.setBounds(area.x, area.y, area.width-50, area.height-50);
      System.out.println("x bound : " + area.width);
      System.out.println("y bound : " + area.height);
      if (vals != null) {
         System.out.println("xSize : " + xSize);
         System.out.println("minY : " + minY);
         System.out.println("maxY : " + maxY);
         for(int i = 0; i < vals.length-1; i++){
            g.drawLine((int)(vals[i][0]/xSize*area.width), ((area.height-(int)((vals[i][1]-minY)/(maxY-minY)*area.height))+25), 
                  (int)(vals[i+1][0]/xSize*area.width), (area.height - (int)((vals[i+1][1]-minY)/(maxY-minY)*area.height))+25);
            if(vals[i][1] == maxY){
               g.drawString("global maximum : (" + vals[i][1] + ")" , (int)(vals[i][0]/xSize*area.width), (area.height-(int)((vals[i][1]-minY)/(maxY-minY)*area.height))+25);
            }
            if(vals[i][1] == minY)
               g.drawString("global minimum : (" + vals[i][1] + ")", (int)(vals[i][0]/xSize*area.width), (area.height-(int)((vals[i][1]-minY)/maxY*area.height))+25);
         }
      }
   }
}