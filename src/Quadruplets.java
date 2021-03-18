import java.util.ArrayList;

public class Quadruplets {
    private ArrayList<QuadElement> quadruplets;

    public Quadruplets(){
        this.quadruplets = new ArrayList<QuadElement>();
    }

    public void addQuad(QuadElement quad){
        this.quadruplets.add(quad);
    }

    public void addQuad(String Elem1, String Elem2, String Elem3, String Elem4){
        this.quadruplets.add(new QuadElement(Elem1, Elem2, Elem3, Elem4));
    }

    public QuadElement getQuad(int index){
        return this.quadruplets.get(index);
    }

    public int size(){
        return this.quadruplets.size();
    }
}
