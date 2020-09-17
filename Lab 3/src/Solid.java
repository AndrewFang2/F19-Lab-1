/**
 * Class labs 3.
 * @author      Andrew Fang Fang0064@algonquinLive.com
 * @version     1.0
 */
import java.util.ArrayList;
import java.util.List;

public class Solid {
    private String name;
    private final List<Facet> facets = new ArrayList<>();


    public void Solid(){
    }

    public Solid(String name){
        this.name = name;
    }

    public boolean addFacet(Facet facet) {
        return facets.add(facet);
    }

    public String toString(){
        StringBuilder str = new StringBuilder("solid " + name+"\n");
        for(int i = 0 ; i < 4; i++) {
            str.append(facets.get(i).toString());
        }

        str.append("endSolid");
        return str.toString();

    }
}