package ifs;
/**
 * This program is the data for BarnsleyFernIfs
 * @author Andrew
 * @version 2020-03-28
 */
public class BarnsleyFernIfs extends AffineTransform {

    private String name;
    private double[][] affine;
    private double scale;
    private int height;
    private int width;
    private int xOffset;
    private int yOffset;
//sets the variable
    public BarnsleyFernIfs() {
        this.name = "Barnsley Fern";
        this.affine = new double[][]{
                {0.00, 0.00, 0.00, 0.16, 0.00, 0.00},
                {0.85, 0.04, -0.04, 0.85, 0.00, 1.60},
                {0.20, -0.26, 0.23, 0.22, 0.00, 1.60},
                {-0.15, 0.28, 0.26, 0.24, 0.00, 0.44}
        };
        this.scale = 100;
        this.height = 503;
        this.width = 1019;
        this.xOffset = 228;
        this.yOffset = 10;
    }
    public String getName() {
        return name;
    }
    public double[][] getAffine() {
        return affine;
    }
    public double getScale() {
        return scale;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getXoffset() {
        return xOffset;
    }
    public int getYoffset() {
        return yOffset;
    }

}
