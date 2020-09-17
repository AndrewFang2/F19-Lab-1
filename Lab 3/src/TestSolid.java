/**
 * Class to test labs 3 and 5.
 * @author      Howard Rosenblum rosenbh@algonquincollege.com
 * @version     1.0
 */
public class TestSolid {

    /**
     * Application main
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        // Define corner points
        Vertex v1 = new Vertex(0,0,0);  // bottom lower left
        Vertex v2 = new Vertex(100,0,0);  // bottom lower right
        Vertex v3 = new Vertex(50,Math.sin(60*Math.PI/180)*100,0);  // bottom behind
        Vertex v4 = new Vertex(50,Math.sqrt(3)*100/6,Math.sqrt(6)*100/3);  // top height

        // Create facets
        Facet f1=new Facet(v1,v3,v2);  // bottom
        Facet f2=new Facet(v1,v2,v4);  // front
        Facet f3=new Facet(v2,v3,v4);  // right
        Facet f4=new Facet(v3,v1,v4);  // left

        // Create solid
        Solid solid = new Solid("Tetrahedron");
        solid.addFacet(f1);
        solid.addFacet(f2);
        solid.addFacet(f3);
        solid.addFacet(f4);

        System.out.println(solid);
    }
}