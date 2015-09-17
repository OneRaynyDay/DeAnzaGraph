
public class Quaternion {
   public double w,i,j,k;
   public void rotateX(double theta){
      w = Math.cos(theta/2);
      i *= w;
   }
}
