public class SierpinskiIfs extends AffineTransform {

    public String name;
    public double[][] affine;
    public double scale;
    public int height;
    public int width;
    public int xOffset;
    public int yOffset;


    public SierpinskiIfs() {
        this.name = "Sierpinski Gasket";
        this.affine = new double[][] {
                {0.5, 0.0, 0.0, 0.5, 0.0, 0.0},
                {0.5, 0.0, 0.0, 0.5, 0.0, -0.5},
                {0.5, 0.0, 0.0, 0.5, -0.43, -0.25}
        };
        this.scale = 500;
        this.height = 449;
        this.width = 519;
        this.xOffset = 439;
        this.yOffset = 509;
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
