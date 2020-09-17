package ifs;
/**
 * This program is to declare the variable
 * @author Andrew
 * @version 2020-04-08
 */
public interface AffineTransform {

    String getName();
    double[][] getAffine();
    double getScale();
    int getHeight();
    int getWidth();
    int getXoffset();
    int getYoffset();
}
