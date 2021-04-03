package nodes;

public abstract class Constante extends Node {

    private String type;

    public Constante(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract Object getValue();
}
