package ifs;

public class MapleIfs extends AffineTransform {

    public String name;
    public double[][] affine;
    public double scale;
    public int height;
    public int width;
    public int xOffset;
    public int yOffset;

    public MapleIfs() {
        this.name = "Maple Leaf";
        this.affine = new double[][]{
                {0.51,0.00,0.01,0.14,1.31,0.08},
                {0.50,-0.45,0.52,0.43,0.75,-1.49},
                {0.47,0.47,-0.49,0.45,0.74,1.62},
                {0.51,0.00,0.00,0.49,-1.62,-0.02},
        };
        this.scale = 100;
        this.height = 702;
        this.width = 885;
        this.xOffset = 340;
        this.yOffset = 445;
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
