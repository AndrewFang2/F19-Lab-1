package ifs;

public class BarnsleyFernIfs extends AffineTransform {

    public String name;
    public double[][] affine;
    public double scale;
    public int height;
    public int width;
    public int xOffset;
    public int yOffset;

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
