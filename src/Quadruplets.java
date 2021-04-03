import nodes.*;

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

    public QuadElement addQuad(String operateur, Node operande1, Node operande2, Node resultats){
        QuadElement quad = new QuadElement(operateur, operande1, operande2, resultats, this.number_quadruplets);
        this.quadruplets.add(quad);
        this.number_quadruplets++;
        return quad;
    }

    public QuadElement getQuad(int index){
        return this.quadruplets.get(index);
    }

    public int size(){
        return this.quadruplets.size();
    }
}
