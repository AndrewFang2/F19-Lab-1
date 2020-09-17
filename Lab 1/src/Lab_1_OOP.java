/**
 *
 */

public class Lab_1_OOP {
    int height, width, scale, xOffset, yOffset,A,B,C,D,E,F,xDisp,yDisp,dfasf;
    double u,v;
    private int[][] twoDarray;
    double[][] matrix;
    double x=0;
    double y=0;

    private void graphic(int i) {
            if (i == 1) {
                dfasf=1;
                scale = -500;
                height = 449;
                width = 519;
                xOffset = 439;
                yOffset = 509;
                twoDarray= new int[width][height];
                matrix = new double[][]{
                        {0.50,0,0,0.50,0,0},
                        {0.50,0,0,0.50,0,0.50},
                        {0.50,0,0,0.50,0.43,0.25}
                };
                A = 0; B = 1; C = 2; D = 3; E = 4; F = 5;
            } else {
                dfasf=2;
                scale=100;
                height=503;
                width=1019;
                xOffset=228;
                yOffset=1;
                twoDarray= new int[width][height];
                matrix = new double[][]{
                        {0.00,0.00,0.00,0.16,0.00,0.00},
                        {0.85,0.04,-0.04,0.85,0.00,1.60},
                        {0.20,-0.26,0.23,0.22,0.00,1.60},
                        {-0.15,0.28,0.26,0.24,0.00,0.44}
                };
                A = 0; B = 1; C = 2; D = 3; E = 4; F = 5;
            }
    }
    public int[][] s() {
        for (int i = 0; i < (height * width); i++) {
            double random = Math.random();
            //row here (int)
            int row = 0;

            if(dfasf == 1){
                if (random <0.33){
                    row = 0;
                }
                else if (random >= 0.33 && random <0.66){
                    row = 1;
                }
                else {
                    row = 2;
                }
            }
            else{
                if (random >= 0.00 && random <0.01){
                    row = 0;
                }
                else if(random >= 0.01 && random <0.85){
                    row = 1;
                }
                else if(random >= 0.85 && random <0.92){
                    row = 2;
                }
                else {
                    row = 3;
                }
            }
            double u = matrix[row][A] * x + matrix[row][B] * y + matrix[row][E];
            double v = matrix[row][C] * x + matrix[row][D] * y + matrix[row][F];

            x = u;
            y = v;
            xDisp = (int) (x * scale + xOffset);
            yDisp = (int) (y * scale + yOffset);
            twoDarray[yDisp][xDisp]++;
        }
        return twoDarray;
    }
    public static void main(String[] arg){
        Lab_1_OOP lab1 = new Lab_1_OOP();
        lab1.graphic(1);
        IfsViewer.view(lab1.s());
        lab1.graphic(2);
        IfsViewer.view(lab1.s());
    }
}