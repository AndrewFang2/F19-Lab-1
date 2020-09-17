/**
 * Class labs 3.
 * @author      Andrew Fang Fang0064@algonquinLive.com
 * @version     1.0
 */
public class Facet {
    private Vertex normal, v1, v2, v3;

    public Facet(Vertex v1, Vertex v2, Vertex v3){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.normal = Vertex.calcNormal(v1,v2,v3);
    }
    public String toString(){
        String restring = "";

        restring += "facet normal " +normal.toString()+ "\n";
        restring += " outer loop\n";
        restring += "  vertex "+v1.toString()+ "\n";
        restring += "  vertex "+v2.toString()+ "\n";
        restring += "  vertex "+v3.toString()+ "\n";
        restring += " endloop\n";
        restring += "endfacet\n";
        return restring;
    }

}
