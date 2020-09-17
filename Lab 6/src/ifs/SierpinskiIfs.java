package ifs;
/**
 * This program is the data for SierpinskiIfs
 * @author Andrew
 * @version 2020-04-08
 */
public class SierpinskiIfs implements AffineTransform {

    public String name;
    public double[][] affine;
    public double scale;
    public int height;
    public int width;
    public int xOffset;
    public int yOffset;
    /**
     * Set The variables for Sierpinski Gasket
     */
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
    /**
     * @return      The image name
     */
    public String getName() {
        return name;
    }
    /**
     * @return      The image affine
     */
    public double[][] getAffine() {
        return affine;
    }
    /**
     * @return      The image scale
     */
    public double getScale() {
        return scale;
    }
    /**
     * @return      The image height
     */
    public int getHeight() {
        return height;
    }
    /**
     * @return      The image width
     */
    public int getWidth() {
        return width;
    }
    /**
     * @return      The image X off set
     */
    public int getXoffset() {
        return xOffset;
    }
    /**
     * @return      The image Y off set
     */
    public int getYoffset() {
        return yOffset;
    }

}
