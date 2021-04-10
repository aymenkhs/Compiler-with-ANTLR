import nodes.*;

import java.util.ArrayList;

public class SymbolesTable {

    private final ArrayList<IDF> declaredVars, unDeclaredVars;

    private String programName;

    public SymbolesTable() {
        this.declaredVars =new ArrayList<IDF>();
        this.unDeclaredVars =new ArrayList<IDF>();
    }

    public ArrayList<IDF> getDeclaredVars() {
        return declaredVars;
    }

    public void addprogramName(String programName){
        this.programName = programName;
    }

    public boolean isProgramName(String idfName){
        return idfName.equals(programName);
    }

    public void addDeclaredVar(IDF idf){
        declaredVars.add(idf);
    }

    public void addUnDeclaredVar(IDF idf){
        unDeclaredVars.add(idf);
    }

    public boolean containsVar(String idfName){
        for (IDF idf : declaredVars) {
            if (idf.getName().equals(idfName)) {
                return true;
            }
        }
        return false;
    }

    public boolean alreadyUndeclared(String idfName){
        for (IDF idf : unDeclaredVars) {
            if (idf.getName().equals(idfName)) {
                return true;
            }
        }
        return false;
    }

    public IDF getIDF(String idfName){
        for (IDF idf : declaredVars) {
            if (idf.getName().equals(idfName)) {
                return idf;
            }
        }

        for (IDF idf : unDeclaredVars) {
            if (idf.getName().equals(idfName)) {
                return idf;
            }
        }
        return null;
    }

    public void setValueToVar(String s,Object value){
        for (IDF idf : declaredVars) {
            if (idf.getName( ).equals(s)) {
                idf.setValue(value);
            }
        }
    }

}
