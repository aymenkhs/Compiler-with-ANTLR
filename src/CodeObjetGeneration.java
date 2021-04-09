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
                codeObjet.add(idf.getName() + " DW 0");
            }else if (idf.getType().equals("floatCompil")){
                codeObjet.add(idf.getName() + " DD 0");
            }else{

            }
        }
        codeObjet.add("");
    }

    public void operations(){
        // on parcours les quadruplets et on traduit en assembleur
        for( QuadElement quad : quadruplets){
            switch(quad.getOperateur()) {
                case "+":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("ADD " + quad.getOperande1());
                    codeObjet.add("MOV " + quad.getResultats() + ",AX");
                    break;
                case "-":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("SUB " + quad.getOperande1());
                    codeObjet.add("MOV " + quad.getResultats() + ",AX");
                    break;
                case "*":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("MUL " + quad.getOperande1());
                    codeObjet.add("MOV " + quad.getResultats() + ",AX");
                    break;
                case "/":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("DIV " + quad.getOperande1());
                    codeObjet.add("MOV " + quad.getResultats() + ",AX");
                    break;
                case "=":
                    codeObjet.add("MOV "+ quad.getResultats() + "," + quad.getOperande1());
                    break;
                case "scan":
                    codeObjet.add("INPUT " + quad.getResultats());
                    break;
                case "print":
                    codeObjet.add("OUTPUT " + quad.getResultats());
                    break;
                case "BR":
                    // code block
                    break;
                case "BZ":
                    // code block
                    break;
                case "BNZ":
                    // code block
                    break;
                case "BE":
                    // code block
                    break;
                case "BNE":
                    // code block
                    break;
                case "BGE":
                    // code block
                    break;
                case "BG":
                    // code block
                    break;
                case "BLE":
                    // code block
                    break;
                case "BL":
                    // code block
                    break;
                default:
                    // code block
            }
        }

    }

}
