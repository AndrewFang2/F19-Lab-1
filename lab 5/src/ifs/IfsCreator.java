package ifs;
/**
 * This program is creating the Ifs
 * @author Andrew
 * @version 2020-03-28
 */
import java.io.FileNotFoundException;

public class IfsCreator {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 3;
    private static final int E = 4;
    private static final int F = 5;
    private static final int PROB = 6;
    //set an array to determine which one to print out
    public IfsCreator() {
    }
    public AffineTransform[] getTransfrom() throws FileNotFoundException {
        AffineTransform[] array =new AffineTransform[4];
        array[0] = new BarnsleyFernIfs();
        array[1] = new MapleIfs();
        array[2] = new SierpinskiIfs();
        array[3] = new FileIfs("C:\\temp2020\\GoldenDragon.ifs");
        return array;
    }
//create ifs
    public int[][] generateIfs(AffineTransform affineTrans){

        String affineName = affineTrans.getName();
        double[][] affine = affineTrans.getAffine();
        double scale = affineTrans.getScale();
        int height = affineTrans.getHeight();
        int width = affineTrans.getWidth();
        int xOffset = affineTrans.getXoffset();
        int yOffset = affineTrans.getYoffset();
        double x=0;
        double y=0;
        int xDisp = 0;
        int yDisp = 0;
        int[][] twoDArray = new int[width][height];
        for(int i = 0 ; i < width* height; i++) {
            double randNum = Math.random();
            int row = 0;

            if(affineName.equals("Barnsley Fern")) {
                if(randNum >= 0.00 && randNum <= 0.01) {
                    row = 0;
                }
                else if(randNum > 0.01 && randNum <= 0.85) {
                    row = 1;
                }
                else if(randNum > 0.85 && randNum <= 0.92) {
                    row = 2;
                }
                else {
                    row = 3;
                }
            } else if(affineName.equals("Sierpinski Gasket")) {
                if(randNum >= 0.00 && randNum <= 0.33) {
                    row = 0;
                }
                else if(randNum > 0.33 && randNum <= 0.66) {
                    row = 1;
                }
                else {
                    row = 2;
                }
            }else if(affineName.equals("Maple Leaf")) {
                if(randNum <= 0.10) {
                    row = 0;
                }else if(randNum > 0.10 && randNum <= 0.45) {
                    row = 1;
                }else if(randNum > 0.45 && randNum <= 0.80) {
                    row = 2;
                }else {
                    row = 3;
                }

            }else {
                if(randNum <= 0.45) {
                    row = 0;
                }else {
                    row = 1;
                }
            }

            double u = affine[row][A]*x + affine[row][B]*y + affine[row][E];
            double v = affine[row][C]*x + affine[row][D]*y + affine[row][F];
            x = u;
            y = v;
            xDisp =(int) (x * scale + xOffset);
            yDisp =(int) (y * scale + yOffset);
            twoDArray[yDisp][xDisp]++;
        }
        return twoDArray;
    }
}