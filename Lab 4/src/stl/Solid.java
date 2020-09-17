package stl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Solid {
    private String name;
    private final List<Facet> facets = new ArrayList<>();

    public Solid(String name){
        this.name = name;
    }

    public boolean addFacet(Facet facet) {
        return facets.add(facet);
    }

    public  boolean addFacet(Vertex ... vertices) {
        if(vertices.length <3){
                return false;
            }
            else if(vertices.length==3){
                Facet one = new Facet(vertices[0],vertices[1],vertices[2]);
                facets.add(one);
            }
            else if(vertices.length==4){
                Facet one = new Facet(vertices[0],vertices[1],vertices[2]);
                Facet two = new Facet(vertices[0],vertices[2],vertices[3]);
                facets.add(one);
                facets.add(two);
            }
            else if(vertices.length==5){
                Facet one = new Facet(vertices[0],vertices[1],vertices[2]);
                Facet two = new Facet(vertices[0],vertices[2],vertices[3]);
                Facet three = new Facet(vertices[0],vertices[3],vertices[4]);
                facets.add(one);
                facets.add(two);
                facets.add(three);
            }
        return facets.contains(vertices);
    }

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
