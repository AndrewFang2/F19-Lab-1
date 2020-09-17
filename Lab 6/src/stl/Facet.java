package stl;
/**
 * This program is setting up facet
 * @author Andrew
 * @version 2020-03-28
 */
public class Facet {
    private Vertex normal, v1, v2, v3;
    /**
     * This program is declaring and setting the variable to equal itself
     * @param v1 for the x
     * @param v2 for the y
     * @param v3 for the z
     */
    public Facet(Vertex v1, Vertex v2, Vertex v3){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.normal = Vertex.calcNormal(v1,v2,v3);
    }
    /**
     * This program builds a String to print out to the program later
     */
    public String toString(){
        String restring = "";

        restring += "facet normal " +normal.toString()+ "\n";
        restring += "  outer loop\n";
        restring += "    vertex "+v1.toString()+ "\n";
        restring += "    vertex "+v2.toString()+ "\n";
        restring += "    vertex "+v3.toString()+ "\n";
        restring += "  endloop\n";
        restring += "endfacet\n";

        return restring;
    }

}
