package nodes;

import java.util.ArrayList;

public class Semantic_Table {

    private ArrayList<IDF> symbol_table;

    public Semantic_Table() {
        this.symbol_table =new ArrayList<IDF>();
    }

    public ArrayList<IDF> getSymbol_table() {
        return symbol_table;
    }

    public void addVar(IDF idf){
        symbol_table.add(idf);
    }


    public Boolean containsVar(String s){
        for(int i=0;i<symbol_table.size();i++){
            if(symbol_table.get(i).getName().equals(s)){
                return true;
            }

        }
        return false;
    }

    public void setValueToVar(String s,Object value){
        for(int i=0;i<symbol_table.size();i++){
            if(symbol_table.get(i).getName().equals(s)){
                symbol_table.get(i).setValue(value);
            }
        }
    }

}
