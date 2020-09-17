/**
 * Class labs 3.
 * @author      Andrew Fang Fang0064@algonquinLive.com
 * @version     1.0
 */
import java.text.DecimalFormat;
public class Vertex {
    private double x, y, z;
    private static DecimalFormat df = new DecimalFormat("#.##");


    public Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString(){
        return df.format(x)+" "+df.format(y)+" "+df.format(z);
    }

    public static Vertex calcNormal(Vertex v1, Vertex v2, Vertex v3){

        double a1 = v2.x - v1.x;
        double b1 = v2.y - v1.y;
        double c1 = v2.z - v1.z;
        double a2 = v3.x - v1.x;
        double b2 = v3.y - v1.y;
        double c2 = v3.z - v1.z;
        double x = b1 * c2 - b2 * c1;
        double y = a2 * c1 - a1 * c2;
        double z = a1 * b2 - b1 * a2;
        double t = Math.sqrt(x*x+y*y+z*z);
        return new Vertex(x/t, y/t, z/t);
    }
}