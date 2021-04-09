import nodes.AdresseQuad;
import nodes.IDF;

import java.util.ArrayList;
import java.util.Iterator;

public class CodeObjetGeneration implements Iterable<String>{
    private Quadruplets quadruplets;
    private SymbolesTable table_Symboles;

    private ArrayList<String> codeObjet;

    private ArrayList<Integer> adresses;

    public CodeObjetGeneration(Quadruplets quadruplets, SymbolesTable table_Symboles) {
        this.quadruplets = quadruplets;
        this.table_Symboles = table_Symboles;

        this.codeObjet = new ArrayList<>();

        this.adresses = new ArrayList<>();

        adressesEtiquetes();
        declaration();
        operations();
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

            if (adresses.contains(quad.getNum())){
                codeObjet.add("Etiq@" + quad.getNum() + ":");
            }

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
                    codeObjet.add("JMP Etiq" + quad.getResultats());
                    break;
                case "BZ":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("CMP AX,0");
                    codeObjet.add("JZ Etiq" + quad.getResultats());
                    break;
                case "BNZ":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("CMP AX,0");
                    codeObjet.add("JNZ Etiq" + quad.getResultats());
                    break;
                case "BE":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("CMP AX," + quad.getOperande2());
                    codeObjet.add("JE Etiq" + quad.getResultats());
                    break;
                case "BNE":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("CMP AX," + quad.getOperande2());
                    codeObjet.add("JNE Etiq" + quad.getResultats());
                    break;
                case "BGE":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("CMP AX," + quad.getOperande2());
                    codeObjet.add("JGE Etiq" + quad.getResultats());
                    break;
                case "BG":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("CMP AX," + quad.getOperande2());
                    codeObjet.add("JG Etiq" + quad.getResultats());
                    break;
                case "BLE":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("CMP AX," + quad.getOperande2());
                    codeObjet.add("JLE Etiq" + quad.getResultats());
                    break;
                case "BL":
                    codeObjet.add("MOV AX," + quad.getOperande1());
                    codeObjet.add("CMP AX," + quad.getOperande2());
                    codeObjet.add("JL Etiq" + quad.getResultats());
                    break;
                default:
                    System.out.println("erreur dans la generation de code objet");
            }
        }

    }

    public void adressesEtiquetes(){
        for(QuadElement quad : quadruplets){
            if(quad.getResultats() instanceof AdresseQuad){
                adresses.add(((AdresseQuad) quad.getResultats()).getAdresse());
            }
        }
    }

    @Override
    public Iterator<String> iterator() {
        return codeObjet.iterator();
    }
}
