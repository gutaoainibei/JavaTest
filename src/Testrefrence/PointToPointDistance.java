package Testrefrence;


public class PointToPointDistance {
   private double x;
   private double y;
   private double z;
   public PointToPointDistance(double x,double y,double z){
	   this.x=x;
	   this.y=y;
	   this.z=z;
   }
   public double distance(PointToPointDistance p){
	   double d = Math.sqrt((x-p.x)*(x-p.x)+(z-p.z)*(z-p.z)+(y-p.y)*(y-p.y));
	   return d;
   }
   public static void main(String[] args) {
	PointToPointDistance p = new PointToPointDistance(0, 0, 0);
	PointToPointDistance p1 = new PointToPointDistance(0, 0, 1);
	System.err.println(p1.distance(p));
}
}
