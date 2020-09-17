package stl;
/**
 * This program prints the 3d format for 3 shapes: sierpisnki, mapleLeaf, BarnsleyFern
 * @author Andrew
 * @version 2020-03-28
 */
import java.io.PrintWriter;
import java.util.ArrayList;
public class Solid {
    private String name;
    private ArrayList<Facet> facets = new ArrayList<Facet>();

    public Solid(String name){
        this.name = name;
    }

    public boolean addFacet(Facet facet) {
        return facets.add(facet);
    }
    //Connect to Vertex here
    //Vargargs method take multiples variable *like an array
    public boolean addFacet(Vertex ... vertices) {
        if(vertices.length < 3) {
            return false;
        }else{
            for(int i = 0; i < vertices.length - 2; i++) {
                facets.add(new Facet(vertices[0],vertices[i+1],vertices[i+2]));
            }
        }
        return true;
    }
    //Build a the file
    public String toString() {
        StringBuilder s =new StringBuilder("solid "+name+"\n");

        for (int i=0 ;i < facets.size();i++) {
            s.append(facets.get(i).toString());

        }
        s.append("endsolid");
        return s.toString();

    }

    public void print(PrintWriter printWriter) {
        printWriter.print(this.toString());
    }
}