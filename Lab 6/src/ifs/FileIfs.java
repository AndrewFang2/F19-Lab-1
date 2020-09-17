package ifs;
/**
 * This program is the data for FileIfs
 * @author Andrew
 * @version 2020-04-08
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIfs implements AffineTransform {

    private String name;
    private double[][] affine;
    private double scale;
    private int height;
    private int width;
    private int xOffset;
    private int yOffset;
    /**
     * Set The variables for FileIfs(Golden Dragon)
     */
    public FileIfs(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));

        while(file.hasNextLine()) {
            String data =file.next();
            if (data.equals("affine")) {
                int rows = file.nextInt();
                this.affine = new double[rows][7];
                for (int i = 0; i < rows; i++) {
                    for(int j = 0; j < 7; j++) {
                        affine[i][j] = file.nextDouble();
                    }
                }
            } else if (data.equals("scale")) {
                this.scale = file.nextDouble();
            } else if (data.equals("height")) {
                this.height = file.nextInt();
            } else if (data.equals("width")) {
                this.width = file.nextInt();
            } else if (data.equals("xOffset")) {
                this.xOffset = file.nextInt();
            } else if (data.equals("yOffset")) {
                this.yOffset = file.nextInt();
            } else if (data.equals("name")) {
                this.name = file.nextLine();

            }
        }
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