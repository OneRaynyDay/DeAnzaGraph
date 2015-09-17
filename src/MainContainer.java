import javax.swing.*;


public class MainContainer {
   public static void main(String[] args){
      JFrame frame = new JFrame("Graph");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 300);
      
      ValueLoader load = new ValueLoader("quad.txt");
      double[][] vals = load.loadValues();
      double maxY = 0, minY = 0;
      
      for(int i = 0; i < vals.length; i++){
         System.out.println((int)vals[i][0] + "  " + vals[i][1]);
         if(vals[i][1] > maxY)
            maxY = vals[i][1];
         if(vals[i][1] < minY)
            minY = vals[i][1];
      }
      frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS ));
      frame.getContentPane().add(new Table(vals));
      frame.getContentPane().add(new Graph(vals, maxY, minY, vals.length));
      frame.setVisible(true);
   }
}
