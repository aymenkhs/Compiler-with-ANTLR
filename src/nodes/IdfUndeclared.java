package nodes;

import java.util.ArrayList;

public class IdfUndeclared extends IDF{

    private ArrayList<Integer[]> positions;

    public IdfUndeclared(String name) {
        super(name);
        positions = new ArrayList<>();
    }

    public void setValue(Object o){}

    public void addOcurence(int row, int column){
        Integer[] tab = new Integer[2];
        tab[0] = row;
        tab[1] = column;
        positions.add(tab);
    }

    @Override
    public String toString() {
        String ret= "{"+super.toString()+", IDF non declaré," +
                "Occurences : ";
                for(int i=0;i<positions.size();i++){
                    ret+="["+positions.get(i)[0]+",";ret+=positions.get(i)[1]+"], ";
                }
                return ret+"}\n";
    }
}
