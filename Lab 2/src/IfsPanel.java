import java.util.Scanner;

public class IfsPanel {
    public static void main(String[] arg){

        AffineTransform[] affineObject = new AffineTransform[3];
        affineObject[0] = new SierpinskiIfs();
        affineObject[1] = new BarnsleyFernIfs();
        affineObject[2]= new MapleIfs();


        IfsCreator display = new IfsCreator();

        System.out.println("Available fractal images are:");

        for (int i = 0; i < affineObject.length; i++) {
            System.out.println((i+1) + " " + affineObject[i].getName());
        }
        System.out.print("What image number do you want?");
        Scanner input = new Scanner(System.in);
        int inp = input.nextInt();
        while (inp > affineObject.length || inp < 0) {
            System.out.print("Please select a value from 1 to "+ affineObject.length +":");
            inp = input.nextInt();
        }


        int[][] name = display.generateIfs(affineObject[inp-1]);

        IfsViewer.view(name);
    }
}
