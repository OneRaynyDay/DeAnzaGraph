import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ValueLoader {
   Scanner scan;
   public ValueLoader(String fileName){
      try {
         scan = new Scanner(new File(fileName));
      } catch (FileNotFoundException e) {
         System.out.println("This file is faulty. "
               + "Constructing unsuccessful.");
      }
   }
   /**
    * Parses the file for a double value on each line [precondition]
    * @return an array with all the double values tabularly
    */
   public double[][] loadValues(){
      ArrayList<Double> valList = new ArrayList<Double>();
      try{
         while(scan.hasNext()){
            valList.add(Double.parseDouble(scan.nextLine()));
         }
      }
      catch(Exception e){
         e.printStackTrace();
         System.out.println("This scanner is faulty. "
               + "Loading values unsuccessful.");
      }
      double[][] vals = new double[valList.size()][2];
      for(int i = 0; i < valList.size(); i++){
         vals[i][0] = i;
         vals[i][1] = valList.get(i);
      }
      return vals;
   }
}
