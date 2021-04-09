import nodes.IDF;

import java.util.ArrayList;

public class CodeObjetGeneration {
    private Quadruplets quadruplets;
    private SymbolesTable table_Symboles;

    private ArrayList<String> codeObjet;

    public CodeObjetGeneration(Quadruplets quadruplets, SymbolesTable table_Symboles) {
        this.quadruplets = quadruplets;
        this.table_Symboles = table_Symboles;

        this.codeObjet = new ArrayList<>();
    }

    public void declaration(){
        codeObjet.add("section.bss");
        for( IDF idf : table_Symboles.getDeclaredVars()){
            if (idf.getType().equals("intCompil")){
                codeObjet.add(idf.getName() + " DD 0");
            }else if (idf.getType().equals("floatCompil")){
                codeObjet.add(idf.getName() + " DQ 0");
            }else{

            }
        }
    }

}
