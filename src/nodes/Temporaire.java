package nodes;

public class Temporaire extends Node{
    static private int nbTemp = 0;
    private int num;

    public Temporaire() {
        this.num = nbTemp;
        nbTemp++;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "T" + num;
    }

    public static void deleteLastTemp(){
        nbTemp--;
    }
}
