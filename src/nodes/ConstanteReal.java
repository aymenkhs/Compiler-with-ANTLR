package nodes;

public class ConstanteReal extends Constante{

    private float value;

    public ConstanteReal(String type, float value) {
        super(type);
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
