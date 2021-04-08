package nodes;

public abstract class Constante extends Node {

    private String type;
    private final boolean abstractCont;

    public Constante(String type) {
        this.type = type;
        this.abstractCont = false;
    }

    public Constante() {
        this.abstractCont = true;
    }

    public String getType() {
        return type;
    }

    public abstract Object getValue();
}
