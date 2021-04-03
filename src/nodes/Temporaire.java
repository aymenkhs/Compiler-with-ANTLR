package nodes;

public class Temporaire extends Node{
    static private int nbTemp = 0;
    private int num;

    public Temporaire(int num) {
        this.num = num;
        nbTemp++;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "T" + num;
    }
}
