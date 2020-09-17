package stl;

public class StlImage {
    private double minThick;
    private double thickScale;
    private double scale = 0.1;
    private double maxValue;

    public StlImage(double min, double max){
        minThick = min;
        thickScale = max-min;
    }

    public Solid createSolid(int[][] matrix) {

        Solid solid = new Solid("");

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] >= maxValue) {
                    maxValue = matrix[i][j];
                }
            }
        }
        for(int i = 0; i < matrix.length-1; i++) {
            for(int j = 0; j < matrix[i].length-1; j++) {

                solid.addFacet(
                        createIfsVertex(i, j, matrix[i][j]),
                        createIfsVertex(i+1, j,   matrix[i+1][j]),
                        createIfsVertex(i+1, j+1, matrix[i+1][j+1]),
                        createIfsVertex(i,   j+1, matrix[i][j+1]));
            }
        }
        int width = matrix.length;
        int length = matrix[0].length;

        solid.addFacet(
                new Vertex(0, 0, 0),
                new Vertex(width * scale, 0, 0),
                new Vertex(width * scale, 0, minThick),
                new Vertex(0, 0, minThick));

        solid.addFacet(
                new Vertex(0, length * scale, 0),
                new Vertex(0, 0, 0),
                new Vertex(0, 0, minThick),
                new Vertex(0, length * scale, minThick));

        solid.addFacet(
                new Vertex(width * scale, 0, 0),
                new Vertex(width * scale, length * scale, 0),
                new Vertex(width * scale, length * scale, minThick),
                new Vertex(width * scale, 0, minThick));

        solid.addFacet(
                new Vertex(width * scale, length * scale, 0),
                new Vertex(0, length * scale, 0),
                new Vertex(0, length * scale, minThick),
                new Vertex(width * scale, length * scale, minThick));

        solid.addFacet(
                new Vertex(0, 0, 0),
                new Vertex(0, length * scale, 0),
                new Vertex(width * scale, length * scale, 0),
                new Vertex(width * scale, 0, 0));
        return solid;
    }
    private Vertex createIfsVertex(double x, double y, double z){
        double thickness = minThick + thickScale * Math.sqrt(z/maxValue);
        return new Vertex(x * scale, y * scale, thickness);
    }
}
