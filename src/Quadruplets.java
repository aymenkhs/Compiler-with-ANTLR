import java.util.ArrayList;

public class Quadruplets {

    private ArrayList<QuadElement> quadruplets;

    private int tempraires;
    private int number_quadruplets;


    public Quadruplets(){
        this.quadruplets = new ArrayList<QuadElement>();
        this.number_quadruplets = 0;
        this.tempraires = 0;
    }

    public void addQuad(QuadElement quad){
        this.quadruplets.add(quad);
    }

    public void addQuad(String operateur, String operande1, String operande2, String resultats){
        this.quadruplets.add(new QuadElement(operateur, operande1, operande2, resultats, this.number_quadruplets));
        this.number_quadruplets++;
    }

    public QuadElement getQuad(int index){
        return this.quadruplets.get(index);
    }

    public int size(){
        return this.quadruplets.size();
    }
}
