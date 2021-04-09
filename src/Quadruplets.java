import nodes.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Quadruplets implements Iterable<QuadElement>{

    private final ArrayList<QuadElement> quadruplets;

    private int number_quadruplets;


    public Quadruplets(){
        this.quadruplets = new ArrayList<QuadElement>();
        this.number_quadruplets = 0;
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

    public QuadElement optimizeLastAssignement(){
        QuadElement quad = quadruplets.get(this.number_quadruplets-1);
        if (quad.getOperateur().equals("=") && this.number_quadruplets > 1){
            QuadElement quad2 = quadruplets.get(this.number_quadruplets-2);
            if (quad2.getResultats() instanceof Temporaire && quad2.getResultats() == quad.getOperande1()){
                // alors on mets l'affectation dans le precedant quadruplets
                quad2.setResultats(quad.getResultats());
                // on supprime le dernier quadruplets et le temporraire assosier
                Temporaire.deleteLastTemp();
                quadruplets.remove(this.number_quadruplets-1);
                this.number_quadruplets--;
                return quad2;
            }
        }
        return quad;
    }

    public void removeLastBR(){
        QuadElement quad = quadruplets.get(this.number_quadruplets-1);
        if (quad.getOperateur().equals("BR")){
            quadruplets.remove(this.number_quadruplets-1);
            this.number_quadruplets--;
        }
    }

    @Override
    public Iterator<QuadElement> iterator() {
        return quadruplets.iterator();
    }
}
