import java.util.ArrayList;

public class Quadruplets {
    private ArrayList<QuadElement> quadruplets;

    public Quadruplets(){
        this.quadruplets = new ArrayList<QuadElement>();
    }

    public void addQuad(QuadElement quad){
        this.quadruplets.add(quad);
    }

    public void addQuad(String operateur, String operande1, String operande2, String resultats){
        this.quadruplets.add(new QuadElement(operateur, operande1, operande2, resultats));
    }

    public QuadElement getQuad(int index){
        return this.quadruplets.get(index);
    }

    public int size(){
        return this.quadruplets.size();
    }
}
